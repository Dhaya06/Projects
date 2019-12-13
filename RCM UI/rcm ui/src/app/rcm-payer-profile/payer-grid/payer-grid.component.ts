import { Component, OnInit, TemplateRef } from '@angular/core';
import { ViewChild } from '@angular/core';
import { CsiGridColumn, CsiGridOptions } from '../../../../csi-web-base/csi-grid/csi-grid.model';
import { FormGroup } from '@angular/forms';
import { PayerProfileService } from '../rcm-payer-profile.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';
import { CsiAlertService } from 'csi-alert';
import { CsiToastsServiceService } from 'csi-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { PayerProfile } from '../payer-profile';


@Component({
  selector: 'rcm-payer-grid',
  templateUrl: './payer-grid.component.html',
  styleUrls: ['./payer-grid.component.scss']
})


@ComponentRegistry({
  componentId: "a915768d-f52d-46f9-a126-6d8ff36d00d8"
})
export class PayerGridComponent extends CsiBaseComponent {

  errorMessage: string;
  listFilter: string;
  dataArray : PayerProfile[];

  constructor(private router: Router, private _payerProfileService: PayerProfileService, private _csialertservice: CsiAlertService, private toastr: CsiToastsServiceService/*,private modalService: BsModalService*/) { super(); }

  dataSet: any[] = [];
  columns: CsiGridColumn[] = [];
  options: CsiGridOptions = { pageable: true, pageSize: 5 };

  @ViewChild('convertToYesNoCoverLetter') private convertToYesNoCoverLetter: TemplateRef<any>;
  @ViewChild('convertToYesNoPrintOut') private convertToYesNoPrintOut: TemplateRef<any>;
  @ViewChild('convertToYesNoPortal') private convertToYesNoPortal: TemplateRef<any>;
  @ViewChild('appendDaysSTP') private appendDaysSTP: TemplateRef<any>;
  @ViewChild('appendDaysRSTP') private appendDaysRSTP: TemplateRef<any>;
  @ViewChild('appendDaysPTP') private appendDaysPTP: TemplateRef<any>;
  @ViewChild('updateDelete') private updateDelete: TemplateRef<any>;
  @ViewChild('deletemodel') private deletemodel: TemplateRef<any>;
  modalRef: BsModalRef

  ngOnInit() {

    //Define grid columns
    this.columns = [
      {
        field: "profile_id", // -> fields from database array
        title: "Profile ID",    // -> Display name of the columns
        width: 100
      }, {
        field: "profile_name",
        title: "Profile Name",
        width: 100
      }, {
        field: "category",
        title: "Category",
        width: 100
      },
      {
        field: "group_name",
        title: "Group Name",
        width: 100
      },
      {
        field: "company_id",
        title: "Company Name / ID",
        width: 150
      },
      {
        field: "submission_format",
        title: "Submission Format",
        width: 150
      }, {
        field: "submission_template",
        title: "Submission Template",
        width: 150
      }, {
        field: "submission_time_period",
        title: "Submission Time Period",
        template: this.appendDaysSTP,
        width: 150
      }, {
        field: "resubmission_time_period",
        title: "Resubmission Time Period",
        template: this.appendDaysRSTP,
        width: 100
      }, {
        field: "submission_date_of_month",
        title: "Submission Deadline",
        width: 150
      }, {
        field: "payment_method",
        title: "Payment Method",
        width: 100
      }, {
        field: "payment_time_period",
        title: "Payment Time Period",
        template: this.appendDaysPTP,
        width: 150
      }, {
        field: "is_cover_letter_needed",
        title: "Covering Letter Needed",
        template: this.convertToYesNoCoverLetter,
        width: 150
      }, {
        field: "is_printouts_needed",
        title: "Printout Needed",
        template: this.convertToYesNoPrintOut,
        width: 150
      }, {
        field: "is_portal_needed",
        title: "Portal",
        template: this.convertToYesNoPortal,
        width: 100
      }, {
        field: "action",
        title: "Action",
        template: this.updateDelete,
        width: 100
      }
    ];
    this.loadPayerProfiles();
   
  }

  loadPayerProfiles(){
    this._payerProfileService.getPayerProfiles().subscribe(payerProfiles => {
      this.dataSet=payerProfiles.body;
      //this.dataArray = <PayerProfile[]> this.dataSet;
      //this.dataSet = this.dataArray.filter(entry => entry.group_name === "CLEAN");
    },
      error => this.errorMessage = <any>error);
    console.debug(this.dataSet);
  }


  openModal(template: TemplateRef<any>) {
   // this.modalRef = this.modalService.show(template);
  }

  closeModel(){
   // this.modalRef.hide();
  }

  update(id: number) {
    console.log(+ ' update')
    
  }

  delete(id: string) {
    console.log(id + ' delete');

    this._csialertservice.warning("Delete Payer Profile", "Do you Really want to delete the Payer Profile?", "Ok", "Cancel");
    this._payerProfileService.deleteProduct(id)
      .subscribe(
      () => this.onDeleteComplete(id),
      (error: any) => {
        this.errorMessage = <any>error;
        this._csialertservice.warning("Error", "Failed to delete Payer Profile", "Ok");
      }
      );
  }

  onDeleteComplete(id: string): void {
    // Reset the form to clear the flags
    this.removeByKey(this.dataSet, id);
    //this.toastr.success("Payer Profile deleted successfully", "Payer Profile", { timeOut: 3000, progressBar: true, closeButton: true, });
    this.loadPayerProfiles();

  }

  removeByKey(array: any, params: string) {
    array.some(function (item, index) {
      if (array[index]["_id"] === params) {
        array.splice(index, 1);
        return true;
      }
      return false;
    });
    return array;
  }

}
