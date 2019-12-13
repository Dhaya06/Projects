import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, FormControlName, Validators, AbstractControl, ValidatorFn } from '@angular/forms';

import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { ActivatedRoute, Router } from '@angular/router';
import 'rxjs/add/operator/debounceTime';
import { CsiAlertService } from 'csi-alert';
import { CsiToastsServiceService } from 'csi-toastr';

import { CsiGridColumn, CsiGridOptions } from '../../../../csi-web-base/csi-grid/csi-grid.model';
import { CsiSelectOption } from '../../../../csi-web-base/csi-form-elements/models/csi-select.model';


import { PayerProfile } from '../payer-profile';
import { PayerProfileService } from '../rcm-payer-profile.service';
import { CompanyGroupService } from '../../rcm-company-group/rcm-company-group.service'


function ratingRange(min: number, max: number): ValidatorFn {
  return (c: AbstractControl): { [key: string]: boolean } | null => {
    if (c.value !== undefined && (isNaN(c.value) || c.value < min || c.value > max)) {
      return { 'range': true };
    };
    return null;
  };
}

@Component({
  selector: 'rcm-new-payer-profile',
  templateUrl: './create-new-profile.component.html',
  styleUrls: ['./create-new-profile.component.scss']
})

@ComponentRegistry({
  componentId: "95cfa25b-880c-42a3-8b3c-f37fe9c935bd"
})
export class CreateNewProfileComponent extends CsiBaseComponent {

  

  errorMessage: string;
  companygroupsdataSet: any[] = [];
  entry: any;
  companygroup: CsiSelectOption;
  companygroupArr: CsiSelectOption[] = new Array();
  i: number = 1;
  radioModel: string = 'Middle';
  message: string;

  @Output() onSave = new EventEmitter();
  @Output() onClose = new EventEmitter();


  profileCreateFormGroup: FormGroup;
  payerProfile: PayerProfile = new PayerProfile();

  constructor(private route: ActivatedRoute, private router: Router, private payerprofileservice: PayerProfileService, private _companygroupservice: CompanyGroupService, private toastr: CsiToastsServiceService, private _csialertservice: CsiAlertService) {
    super();
    this._companygroupservice.getCompanyGroups().subscribe(companygroups => {
      console.log(companygroups.body); this.companygroupsdataSet = companygroups.body;
      this.companygroupArr.push({ name: "-- select --", id: "" });
      for (let entry of this.companygroupsdataSet) {
        console.log(entry);
        this.companygroup = { name: entry.group_name, id: this.i++ };
        this.companygroupArr.push(this.companygroup);
      }

      console.log(this.companygroupArr);

    }, error => this.errorMessage = <any>error);

    // Defines all of the validation messages for the form.
    // These could instead be retrieved from a file or database.


  }




  ngOnInit() {
    this.profileCreateFormGroup = new FormGroup({
      profile_name: new FormControl('', Validators.required),
      category: new FormControl(Validators.required),
      group_name: new FormControl(Validators.required),
      company_id: new FormControl(Validators.required),
      submission_format: new FormControl(Validators.required),
      submission_url: new FormControl(''),
      submission_template: new FormControl('n/a'),
      submission_template_Json: new FormControl('n/a'),
      submission_template_db2db: new FormControl('n/a'),
      submission_template_excel: new FormControl('n/a'),
      payment_time_period: new FormControl('',Validators.required),
      submission_time_period: new FormControl('',Validators.required),
      resubmission_time_period: new FormControl('',Validators.required),
      submission_date_of_month: new FormControl('',Validators.required),
      payment_method: new FormControl('',Validators.required),
      is_portal_needed: new FormControl('false'),
      is_cover_letter_needed: new FormControl('false'),
      is_printouts_needed: new FormControl('false')
    });






    this.profileCreateFormGroup.get('group_name').valueChanges.subscribe(value => console.log(value));
    this.profileCreateFormGroup.get('company_id').valueChanges.subscribe(value => console.log(value));

    const profileNameControl = this.profileCreateFormGroup.get('profile_name');
    //profileNameControl.valueChanges.debounceTime(1000).subscribe(value => )

    //this.setMessage(profileNameControl));
    profileNameControl.valueChanges.debounceTime(1000).subscribe(value =>
      this.setMessage(profileNameControl));
  }


  ngOnDestroy(): void {
  }




  ////////////////////////////////////////////////////
  ///// SELECT BOX DATA //////////////////////////////

  rule: any[] = [
    {
      "rule": "required",
      "message": "Feild is required!"
    }]

  prayerListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "Insurance"
    }, {
      id: 2,
      name: "Government"
    }, {
      id: 3,
      name: "Regular"
    }
  ]

  // insurenceGroupListItems : CsiSelectOption[] = [
  //   {
  //     id: 1,
  //     name: "BUPA"
  //   }, {
  //     id: 2,
  //     name: "Tawuniya"
  //   }, {
  //     id: 3,
  //     name: "Medgulf"
  //   }
  // ] 



  insurenceGroupListItems: CsiSelectOption[] = this.companygroupArr;

  companyNameListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "CMP 01"
    }, {
      id: 2,
      name: "CMP 02"
    }, {
      id: 3,
      name: "CMP 03"
    }
  ]

  submissionFormatListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "JSON"
    }, {
      id: 2,
      name: "DB2DB"
    }, {
      id: 3,
      name: "Excel"
    },
    {
      id: 4,
      name: "Web services"
    },
    {
      id: 5,
      name: "XML"
    },

  ]

  submissionTimeListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: '10'
    }, {
      id: 2,
      name: '20'
    }, {
      id: 3,
      name: '30'
    }
  ]

  reSubmissionTimeListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "10"
    }, {
      id: 2,
      name: "20"
    }, {
      id: 3,
      name: "30"
    }

  ]

  submissionDataListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "1"
    }, {
      id: 2,
      name: "2"
    }, {
      id: 3,
      name: "3"
    },
    {
      id: 4,
      name: "4"
    },

  ]


  paymentMethodDataListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "Cash"
    }, {
      id: 2,
      name: "Cheque"
    }, {
      id: 3,
      name: "Card"
    },
  ]

  paymentTimePeriodDataListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "10"
    }, {
      id: 2,
      name: "20"
    }, {
      id: 3,
      name: "30"
    },
  ]

  savePayerProfile(): void {
    console.log(this.profileCreateFormGroup);
    console.log('saved ' + JSON.stringify(this.profileCreateFormGroup.value));
    this.onSave.emit(this.profileCreateFormGroup);

    if (/*this.profileCreateFormGroup.dirty &&*/ this.profileCreateFormGroup.valid) {
      // Copy the form values over the product object values
      let p = Object.assign({}, this.payerProfile, this.profileCreateFormGroup.value);

      p.group_name = (this.companygroupArr[this.profileCreateFormGroup.value.group_name]).name;
      p.category = (this.prayerListItems[this.profileCreateFormGroup.value.category]).name;
      p.company_id = (this.companyNameListItems[this.profileCreateFormGroup.value.company_id]).name;
      p.submission_format = (this.submissionFormatListItems[this.profileCreateFormGroup.value.submission_format]).name;
      p.submission_time_period = Number((this.submissionTimeListItems[this.profileCreateFormGroup.value.submission_time_period]).name);
      p.resubmission_time_period = Number((this.reSubmissionTimeListItems[this.profileCreateFormGroup.value.resubmission_time_period]).name);
      p.submission_date_of_month = Number((this.submissionDataListItems[this.profileCreateFormGroup.value.submission_date_of_month]).name);
      p.payment_method = (this.paymentMethodDataListItems[this.profileCreateFormGroup.value.payment_method]).name;
      p.payment_time_period = Number((this.paymentTimePeriodDataListItems[this.profileCreateFormGroup.value.payment_time_period]).name);

      console.log(p);
      this.payerprofileservice.saveProduct(p)
        .subscribe(
          () => this.onSaveComplete(),
          (error: any) => {
            this.errorMessage = <any>error;
            this._csialertservice.warning("Error", "Failed to Save Payer Profile", "Ok");
          }

        );
    }
  }

  onSaveComplete(): void {
    // Reset the form to clear the flags
    this.profileCreateFormGroup.reset();
    this.toastr.success("Payer Profile saved successfully", "Payer Profile", { timeOut: 3000, progressBar: true, closeButton: true });
    this.router.navigate(['/']);
  }

  private validationMessages = {
    required: 'Please enter Profile Name.'
  };

  setMessage(c: AbstractControl,): void {
    this.message = '';
    if ((c.pristine) && c.errors) {
      this.message = Object.keys(c.errors).map(key =>
        this.validationMessages[key]).join(' ');
    }
  }

  CloseForm() {
    this.onClose.emit();
  }

  selectBoxChange($event) {
    console.log("----select box ------");
  }
}

