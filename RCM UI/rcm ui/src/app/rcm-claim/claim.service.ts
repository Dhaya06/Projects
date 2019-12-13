import { Injectable } from '@angular/core';
import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service';

import { HttpErrorResponse } from '@angular/common/http';
import { EncounterSummaryWidjet } from './rcm-claim-widget/encounter-summary-widjet';
import { NurseNoteWidjet } from './rcm-claim-widget/nurse-note-widjet';
import { PatientHistoryWidjet } from './rcm-claim-widget/patient-history-widjet';
import { VitalSign } from './rcm-claim-widget/vital-sign';
import { Complaint } from './rcm-claim-widget/complaint';
import { Orders } from './rcm-claim-widget/orders';
import { Encounter } from './rcm-claim-widget/encounter';
import { RCMasterData } from '../_shared/rcm-master-data'

import {  } from './rcm-claim-widget/nurse-note-widjet';
import { API_URL } from '../_shared/API_URLS.const';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ClaimService {

  private getEncounterSummaryWidjetURL = API_URL.Widjet.GETENCOUNTER_SUMMARY;
  private getnurseNoteWidgetDataURL = API_URL.Widjet.GETNURSE_NOTES;
  private getpatientHistorytDataURL = API_URL.Widjet.PATIENT_HISTORY;
  private getVitalSignDataURL = API_URL.Widjet.VITAL_SIGN;
  private getComplaintDataURL = API_URL.Widjet.COMPLAINT;
  private getOrderDataURL = API_URL.Widjet.ORDERS;
  private getEncounterData = API_URL.Widjet.ENCOUNTER_DATA;
  

  constructor(private csiHttpService: CsiHttpService) { }

  GetClaimbyId(id: number): any {
    return this.csiHttpService.getSingleObject(API_URL.CLAIM.SINGLECLAIM,id);
  }

  SaveClaim(claim:any): any {
    return this.csiHttpService.post(API_URL.CLAIM.SAVE,claim);
  }

  getEncounterSummaryWidjetData(id:number): Observable<EncounterSummaryWidjet> {
    console.log(this.getEncounterSummaryWidjetURL);
    return this.csiHttpService.getAll<EncounterSummaryWidjet>(this.getEncounterSummaryWidjetURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getNurseNotesWidjetData(id:number): Observable<NurseNoteWidjet> {
    console.log(this.getnurseNoteWidgetDataURL);
    return this.csiHttpService.getAll<NurseNoteWidjet>(this.getnurseNoteWidgetDataURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getPatientHistoryWidjetData(id:number): Observable<PatientHistoryWidjet> {
    console.log(this.getnurseNoteWidgetDataURL);
    return this.csiHttpService.getAll<PatientHistoryWidjet>(this.getpatientHistorytDataURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getVitalSignsData(id:number): Observable<VitalSign[]> {
    console.log(this.getnurseNoteWidgetDataURL);
    return this.csiHttpService.getAll<VitalSign[]>(this.getVitalSignDataURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getComplaintData(id:number): Observable<Complaint[]> {
    console.log(this.getnurseNoteWidgetDataURL);
    return this.csiHttpService.getAll<Complaint[]>(this.getComplaintDataURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getOrderData(id:number): Observable<Orders[]> {
    console.log(this.getnurseNoteWidgetDataURL);
    return this.csiHttpService.getAll<Orders[]>(this.getOrderDataURL+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

 
  getEncounterName(id:number) : Observable<RCMasterData<Encounter>> {
    return this.csiHttpService.getAll<Encounter>(this.getEncounterData+id).do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }



  private handleError(err: HttpErrorResponse) {
    console.log(err.message);
    return Observable.throw(err.message);
  }



}
