import { Injectable } from "@angular/core";
import { RCMasterData } from '../_shared/rcm-master-data';
import { RCMasterDataRequest } from '../_shared/rcm-master-data-request';

import { PayerProfile } from './payer-profile';
import { HttpErrorResponse } from '@angular/common/http';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { CsiHttpService } from '../../../csi-web-base/csi-http-handler/csi-http.service'
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import { API_URL } from '../_shared/API_URLS.const';
import { RCMasterDataResponse } from "../_shared/rcm-master-data-response";


@Injectable()
export class PayerProfileService {

    private getAllPayerProfilesURL = API_URL.PAYER_PROFILE.GETALL;
    private createPayerProfilesURL = API_URL.PAYER_PROFILE.CREATE;
    private getPayerProfileById  = API_URL.PAYER_PROFILE.GETBYID;
    private UpdatePayerProfile = API_URL.PAYER_PROFILE.UPDATE;
    private DeletePayerProfile = API_URL.PAYER_PROFILE.DELETE;



    private payerProfileRequest : RCMasterDataRequest<PayerProfile>;

    constructor(private _http: CsiHttpService,private http:Http ) { }

    getPayerProfiles(): Observable<RCMasterData<PayerProfile[]>> {

        return this._http.getAll<RCMasterData<PayerProfile[]>>(this.getAllPayerProfilesURL).do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    getProduct(id: number): Observable<PayerProfile> {
        if (id === null) {
       // return Observable.of(this.initializeProduct());
        // return Observable.create((observer: any) => {
        //     observer.next(this.initializeProduct());
        //     observer.complete();
        // });
        };
        const url = this.getPayerProfileById+id;
        return this._http.getAll(url)
            .map(this.extractData)
            .do(data => console.log('getPayerProfile: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    saveProduct(payerprofile: PayerProfile): Observable<PayerProfile> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        console.log('payer profile save() service' + payerprofile._id);
        if (payerprofile._id === undefined) {
            return this.createProduct(payerprofile, options);
       }else{
        return this.updateProduct(payerprofile,options);
       }
    }

    private createProduct(payerprofile: PayerProfile, options: RequestOptions): Observable<PayerProfile> {
        payerprofile._id = undefined;
        var x = 10;
        var y = 100;
        payerprofile.profile_id= (Math.floor(Math.random() * ((y-x)+1) + x)).toString();
        this.payerProfileRequest = new RCMasterDataRequest<PayerProfile>('CompanyProfile',payerprofile);
        return this._http.post(this.createPayerProfilesURL,  this.payerProfileRequest)
            .map(this.extractData)
            .do(data => console.log('create payer profile: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    private updateProduct(payerprofile: PayerProfile,options: RequestOptions): Observable<PayerProfile> {
        this.payerProfileRequest = new RCMasterDataRequest<PayerProfile>('CompanyProfile',payerprofile);
        return this._http.put(this.UpdatePayerProfile,  this.payerProfileRequest)
            .map(() => payerprofile)
            .do(data => console.log('update payer profile: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    deleteProduct(id: string): Observable<Response> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.delete(this.DeletePayerProfile+id)
            .do(data => console.log('delete payer profile: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    private extractData(response: RCMasterDataResponse<PayerProfile>) {
        let body = response.body;
        return body|| {};
    }

    private handleError(err: HttpErrorResponse) {
        console.error(err.message);
        return Observable.throw(err.message);
    }


}
