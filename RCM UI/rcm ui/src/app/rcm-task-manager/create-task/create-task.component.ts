import {Component, OnInit, TemplateRef, ViewChild, Output} from '@angular/core';
import {CsiBaseComponent, ComponentRegistry} from 'csi-base';
import {CsiAlertService} from 'csi-alert';
import {ModalModule} from 'ngx-bootstrap/modal';
import {BsModalService} from 'ngx-bootstrap/modal';
import {BsModalRef} from 'ngx-bootstrap/modal/bs-modal-ref.service';
import {
  FormGroup,
  FormControl,
  Validators,
  ValidatorFn,
  AbstractControl,
  AsyncValidatorFn,
  ValidationErrors
} from '@angular/forms';
import {CreateTaskService} from './create-task.service';
import {CsiToastsServiceService} from 'csi-toastr';
import {ActivatedRoute, Router} from "@angular/router";
import {forEach} from '@angular/router/src/utils/collection';
import {EventEmitter} from '@angular/core';
import {DateConvertService} from '../../_shared/date-convert.service';
import {Observable} from 'rxjs/Observable';

@Component({
  selector: 'rcm-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.scss']
})
@ComponentRegistry({
  componentId: "b130ebe8-c278-4292-b3c8-631954d561b8"
})
export class CreateTaskComponent extends CsiBaseComponent {

  @Output() girdReloadEvent = new EventEmitter();

  filterTypes: any;
  assignPerids = [{text: "1 Day", value: "ONEDAY"},
    {text: "1 Week", value: "ONEWEEK"},
    {text: "1 Month", value: "ONEMONTH"},
    {text: "6 Month", value: "SIXMONTH"},
    {text: "1 Year", value: "ONEYEAR"}]

  statuses = [{text: "Active", value: "Active"}, {text: "Inactive", value: "Inactive"}]
  users = [{name: "Ameen", staffMember: 1}, {name: "Raheel", staffMember: 2}, {name: "Muhammed", staffMember: 3}]

  minDate = new Date();
  worklistId: number;
  workList: any = {};
  claimFilters = Array<ClaimFilter>();
  selectedClaimFilter: ClaimFilter = null;
  selectedFilterValues: Array<{ name: string, filterId: string, dateFrom: string, dateTo: string }>;
  dateFrom: string;
  dateTo: string;
  bsValue: any;
  modalRef: BsModalRef;

//this is use to store model name\
  filterItems: Array<{ name: string, filterId: string }>;

  @ViewChild('template')
  private defaultTabButtonsTpl: TemplateRef<any>;

  worklistForm: FormGroup;

  constructor(private csiAlertService: CsiAlertService, private modalService: BsModalService,
              private createTaskService: CreateTaskService, private toastr: CsiToastsServiceService,
              private route: ActivatedRoute, private router: Router, private dateConverter: DateConvertService) {
    super();
  }

  ngOnInit() {

    this.modalService.onHidden.subscribe((reason: string) => {

      if (this.selectedClaimFilter != null && this.selectedClaimFilter.filterValues.length == 0) {
        const index = this.filterTypes.indexOf(this.selectedClaimFilter.filterType);
        if (index === -1) {
          this.filterTypes.push(this.selectedClaimFilter.filterType);
        }
      }
    })

    this.worklistForm = new FormGroup({
      name: new FormControl('', [Validators.required], [this.getUniqueValidator(this.worklistId)]),
      assignPeriod: new FormControl('', Validators.required),
      activeFrom: new FormControl('', Validators.required),
      status: new FormControl('', Validators.required),
      process: new FormControl('', Validators.required),
      review: new FormControl('', Validators.required),
      submission: new FormControl('', Validators.required),
      reSubmission: new FormControl('', Validators.required),
      claimFilters: new FormControl(Validators.required)
    });

    this.initForm();

    this.route.params.subscribe(params => {
      this.worklistId = params.task_id;

      this.createTaskService.GetWorkListbyId(this.worklistId).subscribe(workList => {
        this.workList = workList
        this.initForm();

        if (this.workList != null) {
          // this.worklistForm.controls["name"].asyncValidator = this.getUniqueValidator(this.worklistId);
          this.worklistForm = new FormGroup({
            name: new FormControl('', [Validators.required], [this.getUniqueValidator(this.worklistId)]),
            assignPeriod: new FormControl('', Validators.required),
            activeFrom: new FormControl('', Validators.required),
            status: new FormControl('', Validators.required),
            process: new FormControl('', Validators.required),
            review: new FormControl('', Validators.required),
            submission: new FormControl('', Validators.required),
            reSubmission: new FormControl('', Validators.required),
            claimFilters: new FormControl(Validators.required)
          });
        }

        // alert(JSON.stringify(this.workList.process.map(assignment => assignment.staffMember)));
        this.worklistForm.setValue({
          name: this.workList.name,
          assignPeriod: this.workList.assignPeriod,
          activeFrom: new Date(this.workList.activeFrom),
          status: this.workList.status,
          process: this.workList.process.map(assignment => {
            return {staffMember: assignment.staffMember.id}
          }),
          review: this.workList.review.map(assignment => {
            return {staffMember: assignment.staffMember.id}
          }),
          submission: this.workList.submission.map(assignment => {
            return {staffMember: assignment.staffMember.id}
          }),
          reSubmission: this.workList.reSubmission.map(assignment => {
            return {staffMember: assignment.staffMember.id}
          }),
          claimFilters: this.workList.claimFilters
        })
        this.setupFilterValues(this.workList.claimFilters);
      });
    });

  }


  setupFilterValues(claimFilters: [ClaimFilter]) {

    this.claimFilters = claimFilters;
    const selectedFilterTypes = claimFilters.map(filter => filter.filterType);
    for (let claimFilter of claimFilters) {
      let selectedFilterType = claimFilter.filterType;

      for (let filterType of this.filterTypes) {
        if (filterType.id == selectedFilterType.id) {

          selectedFilterType.type = filterType.type;
          selectedFilterType.values = filterType.values;
          const index = this.filterTypes.indexOf(filterType);
          this.filterTypes.splice(index, 1);
        }
      }

    }
  }

  onItemDrop(e: any, dropArea: number) {
    if (e.dragData != null) {
      const newClaimFilter = new ClaimFilter();
      newClaimFilter.filterType = e.dragData;
      // this.claimFilters.push(newClaimFilter);
      this.selectedClaimFilter = newClaimFilter;
      this.selectedFilterValues = this.selectedClaimFilter.filterValues
      this.filterItems = e.dragData.values;
      this.openModal(this.defaultTabButtonsTpl);

      const index = this.filterTypes.indexOf(e.dragData);
      if (index !== -1) {
        this.filterTypes.splice(index, 1);
      }
    }

  }

  onModelFilterValueChange(event: any) {
    this.selectedFilterValues = event;
  }

  addFilterValues(event: any) {

    const index = this.claimFilters.indexOf(this.selectedClaimFilter);
    if ((this.selectedFilterValues == null || this.selectedFilterValues.length == 0) && (this.dateFrom == null || this.dateTo == null)) {
      if (index !== -1) {
        this.claimFilters.splice(index, 1);
      }

      //move filter type back to the filter list
      const filterType = this.selectedClaimFilter.filterType;
      this.filterTypes.push(filterType);

      this.modalRef.hide();
      return;
    }

    //if this is a new claimfilter then we need to add that to claim filer array
    if (index === -1) {
      this.claimFilters.push(this.selectedClaimFilter);
    }
    if (this.selectedClaimFilter.filterType.type == 'select') {
      this.selectedClaimFilter.filterValues = this.selectedFilterValues;
    } else if (this.selectedClaimFilter.filterType.type === 'daterange') {
      this.selectedClaimFilter.filterValues = [{name: "", filterId: "", dateFrom: this.dateFrom, dateTo: this.dateTo}];
    }

    this.modalRef.hide();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  closeModel() {
    this.modalRef.hide();
  }

  updateFilterValue(claimFilter: ClaimFilter) {
    if (claimFilter.filterType.name != "") {

      if (claimFilter.filterType.type === 'select') {

        this.selectedClaimFilter = claimFilter;
        this.selectedFilterValues = this.selectedClaimFilter.filterValues;
        this.filterItems = claimFilter.filterType.values;
        this.openModal(this.defaultTabButtonsTpl);
      } else if (claimFilter.filterType.type = 'daterange') {
        this.selectedClaimFilter = claimFilter;

        this.dateFrom = this.selectedClaimFilter.filterValues[0].dateFrom;
        this.dateTo = this.selectedClaimFilter.filterValues[0].dateTo;
        this.filterItems = claimFilter.filterType.values;
        this.bsValue = [new Date(this.dateFrom), new Date(this.dateTo)]
        this.openModal(this.defaultTabButtonsTpl);
      }
    }
  }

  removeFilterValue(claimFilter: ClaimFilter, filterValue: any) {
    if (filterValue != null) {
      const filterIndex = claimFilter.filterValues.indexOf(filterValue);
      claimFilter.filterValues.splice(filterIndex, 1);

      if (claimFilter.filterValues.length == 0) {
        const filtervalueIndex = this.filterTypes.indexOf(claimFilter.filterType);
        if (filtervalueIndex === -1) {
          this.filterTypes.push(claimFilter.filterType);
        }

        const filterIndex = this.claimFilters.indexOf(claimFilter);
        if (filterIndex !== -1) {
          this.claimFilters.splice(filterIndex, 1);
        }
      }
    }
  }

  removeDateRange(claimFilter: ClaimFilter) {
    const filtervalueIndex = this.filterTypes.indexOf(claimFilter.filterType);
    if (filtervalueIndex === -1) {
      this.filterTypes.push(claimFilter.filterType);
    }

    const filterIndex = this.claimFilters.indexOf(claimFilter);
    if (filterIndex !== -1) {
      this.claimFilters.splice(filterIndex, 1);
    }
  }

  onSubmit() {
    this.claimFilters.forEach((claimFiter: ClaimFilter, index: number) => {
      claimFiter.order = index + 1;
    });

    this.worklistForm.value['claimFilters'] = this.claimFilters;
    this.worklistForm.value['activeFrom'] = this.dateConverter.convertDateToString(this.worklistForm.value['activeFrom'], "/");

    if (this.worklistForm.valid) {
      if (this.workList != null) {
        this.worklistForm.value['id'] = this.workList.id
      }
 
      const result = this.createTaskService.SaveOrUpdateWorkList(this.worklistForm.value).subscribe(
        data => {

          this.clearForm();

          this.router.navigate(['/taskmanager/']);
          this.girdReloadEvent.emit(null);
          this.toastr.success("Worklist saved successfully", "Worklist", {
            timeOut: 3000,
            progressBar: true,
            closeButton: true,
          });

        },
        err => {
          // alert(JSON.stringify(err.error));
          const errorMessage = err.error.errors.map(function (obj) {
            return obj.defaultMessage;
          }).join(', ');
          this.csiAlertService.warning("Error", errorMessage, "Ok")
        }
      );
    } else {

    }
  }

  clearForm() {
    this.initForm();
    this.router.navigate(['/taskmanager/']);
  }

  initForm() {
    this.worklistForm.reset();
    this.filterTypes = this.createTaskService.GetFilterTypes();
    this.claimFilters = [];
  }

  filterDateRangeChange(event: any) {
    this.dateFrom = this.dateConverter.convertDateToString(event[0], "/");
    this.dateTo = this.dateConverter.convertDateToString(event[1], "/");
  }

  getUniqueValidator(worklistId: number): AsyncValidatorFn {
    return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
      return this.createTaskService.GetWorkListbyName(control.value).map(
        worklists => {
          if (worklistId == null) {
            return worklists.length == 0 ? null : {"unique": true}
          }
          for (let value of worklists) {
            if (value["id"] != worklistId) {
              return {"unique": true};
            }
          }
          return null;
        }
      )
    };
  }

}


class ClaimFilter {
  id: number;
  order: number;
  filterType: { name: string, type: string, id: number, values: [any] } = {name: "", type: "", id: 0, values: [{}]};
  filterValues: Array<{ name: string, filterId: string, dateFrom: string, dateTo: string }> = [];
}




