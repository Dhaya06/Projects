import { Injectable } from '@angular/core';
import {URLSearchParams} from '@angular/http'
import { CsiHttpService } from '../../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../../_shared/API_URLS.const';

@Injectable()
export class SearchClaimService {

  constructor(private csiHttpService: CsiHttpService) { }

  Search(data:URLSearchParams):any{
    return this.csiHttpService.search(API_URL.CLAIM.SEARCH,data);
  }

}
