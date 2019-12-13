import {Injectable} from '@angular/core';
import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../_shared/API_URLS.const';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { Subscriber } from 'rxjs/Subscriber';

@Injectable()
export class MasterDataService {

  constructor(private csiHttpService: CsiHttpService) { }

  GetActiveClaimLabels(): any {
    return [{id: 1, name: "Error"},
      {id: 2, name: "Clean"}];
  }


  GetActiveClaimLabelTypes(): any {
    return [{id: 1, name: "Technical Error"},
      {id: 2, name: "Medical Necessity"}];
  }

  GetActiveClaimStatus(): any {
    
    return [{id: "NEW", name: "New"},
      {id: "INPROGRESS", name: "Inprogress"},
      {id: "REVIEW", name: "Review"},
      {id: "COMPLETED", name: "Completed"},
      {id: "SUBMITTED", name: "Submitted"}];
  }

  GetActivePolicy(): any {
    return [{id: 1, name: "Policy 1"},
      {id: 2, name: "Policy 2"},
      {id: 3, name: "Policy 3"},
      {id: 4, name: "Policy 4"},
      {id: 5, name: "Policy 5"}];
  }

  GetActiveClinics(): Observable<any> {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.CLINIC.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data; 
  }

  public GetActivePatients(): Observable<any> {

    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.PATIENT.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  GetActiveInsuranceGroup(): Observable<any> {

    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.COMPANY_GROUP.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  GetActiveFacilities(): any {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.HOSPITAL.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  GetActiveCompanies(): any {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.COMPANY.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  GetActiveCompaniesByGroup(groupId:any): any {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.COMPANY.GET_FOR_COMPANYGROUP+groupId).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  GetActiveEncounterTypes(): any {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.ENCOUNTERTYPE.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }


  GetActiveDoctors(): any {
    let data: Observable<any> = new Observable(observer => {
      this.csiHttpService.getAll(API_URL.DOCTORS.GETALL).subscribe(res => {
        this.FilterMasterData(res['body'],observer)
      });
    });

    return data;
  }

  private FilterMasterData(records:any,observer: Subscriber<any>){
    let values = [];
    for(let data of records){
      values.push(data);
    }
    observer.next(values);
  }

}
