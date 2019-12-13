import { Component, OnInit, AfterViewInit, OnDestroy, ViewChildren, ElementRef, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { CsiSelectOption } from '../../../../csi-web-base/csi-form-elements/models/csi-select.model';
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn, FormControlName } from '@angular/forms';;
import { PayerProfile } from '../payer-profile';
import { PayerProfileService } from '../rcm-payer-profile.service';
import { CsiAlertService } from 'csi-alert';
import { CsiToastsServiceService } from 'csi-toastr';

import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: '',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.scss']
})
export class UpdateProfileComponent implements OnInit {
  //  @ViewChildren(FormControlName, { read: ElementRef }) formInputElements: ElementRef[];

  @Output() onClose = new EventEmitter();

  pageTitle: string = 'Payer Profile Edit';
  errorMessage: string;
  profileUpdateFormGroup: FormGroup;
  payerProfile: PayerProfile = new PayerProfile();

  private sub: Subscription;

  constructor(private _route: ActivatedRoute, private payerprofileservice: PayerProfileService,private _csialertservice: CsiAlertService,private toastr: CsiToastsServiceService) {
  }

  ngOnInit(): void {

    this.profileUpdateFormGroup = new FormGroup({
      profile_name: new FormControl('', Validators.required),
      category: new FormControl('', Validators.required),
      group_name: new FormControl('', Validators.required),
      company_id: new FormControl('', Validators.required),
      submission_format: new FormControl('', Validators.required),
      submission_url: new FormControl('', Validators.required),
      submission_template: new FormControl('n/a'),
      submission_template_Json: new FormControl('n/a'),
      submission_template_db2db: new FormControl('n/a'),
      submission_template_excel: new FormControl('n/a'),
      payment_time_period: new FormControl(''),
      submission_time_period: new FormControl(''),
      resubmission_time_period: new FormControl(''),
      submission_date_of_month: new FormControl(''),
      payment_method: new FormControl(''),
      is_portal_needed: new FormControl('false'),
      is_cover_letter_needed: new FormControl('false'),
      is_printouts_needed: new FormControl('false')
    });

    this.sub = this._route.params.subscribe(
      params => {
        let id = +params['profile_id'];
        this.getProduct(id);
      }
    );
  }

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

  insurenceGroupListItems: CsiSelectOption[] = [
    {
      id: "",
      name: "-- select --"
    },
    {
      id: 1,
      name: "BUPA"
    }, {
      id: 2,
      name: "Tawuniya"
    }, {
      id: 3,
      name: "Medgulf"
    }
  ]


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

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  getProduct(id: number): void {
    this.payerprofileservice.getProduct(id)
      .subscribe(
      (profile: PayerProfile) => this.onPayerProfileRetrieved(profile),
      (error: any) => this.errorMessage = <any>error
      );
  }

  updatePayerProfile(): void {
    console.log(this.profileUpdateFormGroup);
    if (this.profileUpdateFormGroup.valid) {
      let p = Object.assign({}, this.payerProfile, this.profileUpdateFormGroup.value);
      this.payerprofileservice.saveProduct(p)
      .subscribe(
      () => this.onUpdateComplete(),
      (error: any) =>  {
        this.errorMessage = <any>error;
        this._csialertservice.warning("Error", "Failed to Update Payer Profile", "Ok");
      }

      );
    }
  }

  onUpdateComplete(): void {
    // Reset the form to clear the flags
    this.profileUpdateFormGroup.reset();
    this.toastr.success("Payer Profile saved successfully", "Payer Profile", { timeOut: 3000, progressBar: true, closeButton: true });
  }

  onPayerProfileRetrieved(profile: PayerProfile): void {

    console.log(profile);
    if (this.profileUpdateFormGroup) {
      this.profileUpdateFormGroup.reset();
    }
    this.payerProfile = profile;

    if (this.payerProfile.profile_id == null) {
      this.pageTitle = 'Create Payer Profile';
    } else {//
      this.pageTitle = 'Edit Payer Profile: ${this.payerProfile[0].profile_id}';
    }


    //console.log(this.payerProfile[0].profile_name);

    this.profileUpdateFormGroup.patchValue({
      profile_name: this.payerProfile[0].profile_name,
      category: "3",
      group_name: this.payerProfile[0].group_name,
      company_id: this.payerProfile[0].company_id,
      is_portal_needed :String(this.payerProfile[0].is_portal_needed),
      is_cover_letter_needed:String(this.payerProfile[0].is_cover_letter_needed),
      is_printouts_needed:String(this.payerProfile[0].is_printouts_needed),
      submission_url: this.payerProfile[0].submission_url
      
    });
    console.log(this.profileUpdateFormGroup);
  }

  CloseForm() {
    this.onClose.emit();
  }

  selectBoxChange($event){

  }

}
