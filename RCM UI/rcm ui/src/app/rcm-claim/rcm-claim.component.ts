
import { Component, ViewChild, ElementRef, Renderer2, ViewContainerRef, TemplateRef, SimpleChanges, AfterViewInit } from '@angular/core';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { CsiToastsServiceService } from 'csi-toastr';
import { Buttons } from 'csi-side-widget';
import { ClaimService } from './claim.service';
import {ActivatedRoute, Router} from "@angular/router";
import { EncounterSummaryWidjet } from './rcm-claim-widget/encounter-summary-widjet';
import { NurseNoteWidjet } from './rcm-claim-widget/nurse-note-widjet';
import { PatientHistoryWidjet } from './rcm-claim-widget/patient-history-widjet';
import { ClaimHeaderComponent } from './claim-header/claim-header.component';
import { ClaimBodyComponent } from './claim-body/claim-body.component';
import { Encounter } from './rcm-claim-widget/encounter';
import { DoctorNoteWidjet } from './rcm-claim-widget/doctor-notes-widjet';


@Component({
  selector: 'app-rcm-claim',
  templateUrl: './rcm-claim.component.html',
  styleUrls: ['./rcm-claim.component.scss'],

})

@ComponentRegistry({
  componentId: "04a7f372-336f-4edd-8642-35d4bc8fbc28"
})
export class RcmClaimComponent extends CsiBaseComponent {

  @ViewChild('template1') private template1Tpl: TemplateRef<any>;
  @ViewChild('template2') private template2Tpl: TemplateRef<any>;
  @ViewChild('template3') private template3Tpl: TemplateRef<any>;
  @ViewChild('template4') private template4Tpl: TemplateRef<any>;
  @ViewChild('template5') private template5Tpl: TemplateRef<any>;


  ButtonConf: Buttons[] = [];

  isReviewPage = false

  claim: any = {};
  appointments:any;
  encounterDiagnosis:any;
  doctorNotesList: any;
  nurseNotesList: any;
  encounterDescription :string;
  index:number=0;

  encounterWidjet:EncounterSummaryWidjet = new EncounterSummaryWidjet();
  encounterData: Encounter= new Encounter();

  nurseNoteWidjetArr : NurseNoteWidjet[] = [];
  nurseNoteWidjet : NurseNoteWidjet = new NurseNoteWidjet();

  doctorNoteWidget : DoctorNoteWidjet = new DoctorNoteWidjet();
  doctorNoteWidgetArr : DoctorNoteWidjet[] = [];

  patientHistoryWidjet: PatientHistoryWidjet = new PatientHistoryWidjet();
  patientHistoryWidjetArr:PatientHistoryWidjet[]=[];

  errorMessage :string;
  patientid :number=1;
  errorCount :number=0;

  policyErrors :string="";
  companyErrors :string="";

  activityErrors :string[]=[];
  attachmentPathErrors : string[]=[];
  diagnosisCodeErrors : string[]=[];
  companyShareErrors : string[]=[];
  discountErrors : string[]=[];
  discountPercentageErrors : string[]=[];
  encounterEndTypeErrors : string[]=[];
  payerIdErrors : string[]=[];
  netAmountErrors : string[]=[];

  medicalErrors : string[]=[];;

  

  
  

  @ViewChild("claimheader") claimHeader:ClaimHeaderComponent;
  @ViewChild("claimbody") claimBody:ClaimBodyComponent;

  constructor(private toastr: CsiToastsServiceService,private claimService: ClaimService,
    private route: ActivatedRoute,private router: Router) {
    super();
  }

  ngOnInit() {

    this.encounterDescription = "Encounter Summary (" + this.errorCount + "Errors Remaining)";

    this.ButtonConf = [
      {
        ButtonID: 1,
        Sorting: 1,
        HTMLTem: "Encounter Summary",
        template: this.template1Tpl,
        notifyCount: 0,
        isImage: false,
        HeaderText: this.encounterDescription
      },{
        ButtonID: 2,
        Sorting: 2,
        HTMLTem: "Doctor Notes",
        ImageURL:"/assets/images/sidebar_icons/doctor_notes.png",
        template: this.template2Tpl,
        isImage: true,
        notifyCount: 55,
        HeaderText: "Doctor Notes"
      },
      {
        ButtonID: 3,
        Sorting: 3,
        HTMLTem: "Nurse Notes",
        ImageURL:"/assets/images/sidebar_icons/nurse.png",
        template: this.template3Tpl,
        isImage: true,
        notifyCount: 55,
        HeaderText: "Nurse Notes"
      }
      , {
        ButtonID: 4,
        Sorting: 4,
        HTMLTem: "Patient History",
        ImageURL:"/assets/images/sidebar_icons/history.png",
        isImage:true,
        template: this.template5Tpl,
        HeaderText: "Patient History"
      },{
        ButtonID: 5,
        Sorting: 5,
        HTMLTem: "Discharge Summary",
        ImageURL:"/assets/images/sidebar_icons/discharge_summary.png",
        template: this.template4Tpl,
        isImage: true,
        HeaderText: "Discharge Summary"
      }
    ];

    this.loadEncounterWidjetData(1);
    this.loadNurseNoteWidjetData(1);
    this.loadPatientHistoryWidjetData(1);
    this.loadVitalSignData(288);
    this.loadComplaintData(288);
    this.loadOrderData(288); 

    this.route.params.subscribe(param => {
      this.claimService.GetClaimbyId(param.claim_id).subscribe(data =>{
        if(data != null){
          this.claim = data;
          this.claimHeader.setClaim(data);
          this.claimBody.setAppointments(data.appointments)
          this.appointments = data.appointments;
          this.encounterDiagnosis = data.encounterDiagnosis;
          this.doctorNotesList = data.doctorNotesList;
          // console.log(this.doctorNotesList);
          this.nurseNotesList = data.nurseNotesList;

          
          // console.log('encounter_data');
          // console.log(this.claim);
          // console.log(data.techErrorMap);
          // console.log(data.medErrorMap);

          //this.errorCount = this.claim.techErrorMap.activityCode.length;

          //error setting

          /*if(data.techErrorMap.activityCode){
            this.errorCount += data.techErrorMap.activityCode.length;
            for (let entry of data.techErrorMap.activityCode){
              this.activityErrors.push(entry);
            }
          }

          if(data.techErrorMap.companyShare){
            this.errorCount += data.techErrorMap.companyShare.length;
            for (let entry of data.techErrorMap.companyShare){
              this.companyShareErrors.push(entry);
            }
          }


          if(data.techErrorMap.diagnosisCode){
            this.errorCount += data.techErrorMap.diagnosisCode.length;
            for (let entry of data.techErrorMap.diagnosisCode){
              this.diagnosisCodeErrors.push(entry);
            }
          }

          if(data.techErrorMap.discount){
            this.errorCount += data.techErrorMap.discount.length;
            for (let entry of data.techErrorMap.discount){
              this.discountErrors.push(entry);
            }
          }

          if(data.techErrorMap.discountPercentage){
            this.errorCount += data.techErrorMap.discountPercentage.length;
            for (let entry of data.techErrorMap.discountPercentage){
              this.discountPercentageErrors.push(entry);
            }
          }

          if(data.techErrorMap.encounterEndType){
            this.errorCount += data.techErrorMap.encounterEndType.length;
            for (let entry of data.techErrorMap.encounterEndType){
              this.encounterEndTypeErrors.push(entry);
            }
          }

          
          if(data.techErrorMap.payerId){
            this.errorCount += data.techErrorMap.payerId.length;
            for (let entry of data.techErrorMap.payerId){
              this.payerIdErrors.push(entry);
            }
          }

          if(data.techErrorMap.attachmentPath){
            this.errorCount += data.techErrorMap.attachmentPath.length;
            for (let entry of data.techErrorMap.attachmentPath){
              this.attachmentPathErrors.push(entry);
            }
          }

          if(data.techErrorMap.netAmount){
            this.errorCount += data.techErrorMap.netAmount.length;
            for (let entry of data.techErrorMap.netAmount){
              this.netAmountErrors.push(entry);
            }

          }

          // Medical errors

          if(data.medErrorMap.activityCode != undefined){
            if(data.medErrorMap.activityCode.length){
             // this.errorCount += data.medErrorMap.activityCode.length;
              for (let entry of data.medErrorMap.activityCode){
                this.medicalErrors.push(entry);
              }

            }
          }*/

          this.ButtonConf[0].notifyCount= this.errorCount;
          this.ButtonConf[0].HeaderText = "Encounter Summary (" + this.errorCount + " Errors Remaining)";

  
          this.encounterWidjet.patientName=data.patient.patientName;
          this.encounterWidjet.patientGender=data.patient.gender;
          this.encounterWidjet.doctorNotes=this.claim.patient.doctorNotesList;
          this.encounterWidjet.encounterStatus= data.claimStatus;
          this.encounterWidjet.insuvaraneDetails = this.claim.companyId + "/" + this.claim.policyNumber ;

          this.loadEncounterDataById(this.claim.encounterType);

        //  if(this.claim.nurseNotesList.length > 0){
        //   //this.nurseNoteWidjetArr = this.claim.nurseNotesList;
        //  }

          // console.log(this.nurseNoteWidjet);

          if(this.claim.techErrorMap.policyNumber){
            for (let entry of this.claim.techErrorMap.policyNumber){
              this.policyErrors+=entry;
            }
          }

          if(this.claim.techErrorMap.companyId){
            for (let entry of this.claim.techErrorMap.companyId){
              this.companyErrors+=entry;
            }
          }
        }
      })
    });
    // console.log('claim data '  + this.claim);
    // console.log(this.claim);
  }

  submitData(){
    const claim = this.claimHeader.getClaimHeaderValue();
    claim['appointments'] = this.claimBody.getAppointments();
    // console.log(this.claimBody.getAppointments());
    claim['encounterDiagnosis'] = this.encounterDiagnosis;
    claim['doctorNotesList'] = this.doctorNotesList;
    claim['nurseNotesList'] = this.nurseNotesList;
    // console.log(claim['doctorNotesList']);
    const claims = [];
    claims.push(claim);

    this.claimService.SaveClaim(claims).subscribe(
      data => {
        
    },error=>{
      this.toastr.success("Claim saved successfully", "Claim", {
        timeOut: 3000,
        progressBar: true,
        closeButton: true,
      });
      this.router.navigate(['/claims']);
    })
  }


  loadEncounterWidjetData(id:number){
    this.claimService.getEncounterSummaryWidjetData(id).subscribe(encounterWidjetData => {
      this.encounterWidjet=encounterWidjetData;
      // console.log(this.encounterWidjet);
    },
      error => {this.errorMessage = <any>error;
        // console.log(this.errorMessage);
      }
    );
  }

  loadNurseNoteWidjetData(id:number){
    this.claimService.getNurseNotesWidjetData(id).subscribe(nursenoteWidjetData => {
    this.nurseNoteWidjetArr.push(nursenoteWidjetData);
    },
      error => {this.errorMessage = <any>error;
        // console.log(this.errorMessage);
      }
    );
  }

  loadPatientHistoryWidjetData(id:number){
    this.claimService.getPatientHistoryWidjetData(id).subscribe(patientHistory => {
     this.patientHistoryWidjetArr.push(patientHistory);
    },
      error => {this.errorMessage = <any>error;
        // console.log(this.errorMessage);
      }
    );
  }

  loadVitalSignData(id:number){
    
    this.claimService.getVitalSignsData(id).subscribe(vitalSign => {
      this.encounterWidjet.vitalSigns=[];
        this.encounterWidjet.vitalSigns.push(vitalSign);
      // console.log('vital sign');
      // console.log(this.encounterWidjet.vitalSigns);
     },
       error => {this.errorMessage = <any>error;
         // console.log(this.errorMessage);
       }
     );
  }

  loadComplaintData(id:number){
    this.claimService.getComplaintData(id).subscribe(complaint => {
      //this.nurseNoteWidjet.nurseNote = complaint.nurseNote;
      
     // this.nurseNote.vitalSigns.push(complaint);

      for(let complain of complaint ){
      this.nurseNoteWidjet.nurseNote = complain.nurseComment;
      // this.doctorNoteWidget.doctorNote = complain.doctorNote;
       this.nurseNoteWidjetArr.push(this.nurseNoteWidjet);
        //this.doctorNoteWidgetArr.push(this.doctorNoteWidget);
      }
      // console.log(complaint);
     },
       error => {this.errorMessage = <any>error;
         // console.log(this.errorMessage);
       }
     );
  }

  loadOrderData(id:number){
    this.claimService.getOrderData(id).subscribe(order => {
      //this.encounterWidjet.vitalSigns.push(vitalSign);
      // console.log(order);
     },
       error => {this.errorMessage = <any>error;
         // console.log(this.errorMessage);
       }
     );
  }

  loadEncounterDataById(id:number){
    this.claimService.getEncounterName(id).subscribe(data => {
      //this.encounterWidjet.vitalSigns.push(vitalSign);

     this.encounterData=data.body[0];
      if(this.claim.encounterType != undefined){
        this.encounterWidjet.encounterDetails = "Type : " +this.encounterData.name +"/ Start Type : " + this.encounterData.name + "/ End Type : " + this.encounterData.name;
      }else{
        this.encounterWidjet.encounterDetails = "Type : n/a " + "/ Start Type : " + this.encounterData.name + "/ End Type : " + this.encounterData.name;
      }

     // // console.log(encounter.body[0]);
     },
       error => {this.errorMessage = <any>error;
         // console.log(this.errorMessage);
       }
     );
  }

}
