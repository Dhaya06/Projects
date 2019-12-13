import { Injectable } from '@angular/core';
import { CsiHttpService } from '../../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../../_shared/API_URLS.const';

@Injectable()
export class SearchTaskService {

  constructor(private csiHttpService: CsiHttpService) { }

  GetAllWorkList():any{
    return this.csiHttpService.getAll(API_URL.TASK_MANAGER.ROOT);
  }

}
