import { Injectable } from "@angular/core";
import { HttpErrorResponse } from '@angular/common/http';

import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service'

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';

import { RCMasterData } from '../_shared/rcm-master-data';
import {CompanyGroup } from '../rcm-company-group/company-group'
import { API_URL } from '../_shared/API_URLS.const';

@Injectable()
export class CompanyGroupService {

    private getAllPayerProfilesURL = API_URL.COMPANY_GROUP.GETALL;
    constructor(private _http: CsiHttpService) { }

    getCompanyGroups(): Observable<RCMasterData<CompanyGroup[]>> {

        return this._http.getAll<RCMasterData<CompanyGroup[]>>(this.getAllPayerProfilesURL).do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    private handleError(err: HttpErrorResponse) {
        console.error(err.message);
        return Observable.throw(err.message);
    }

}