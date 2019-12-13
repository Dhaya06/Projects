import { Injectable } from '@angular/core';
import { CsiHttpService } from '../../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../../_shared/API_URLS.const';
import {URLSearchParams} from '@angular/http'

@Injectable()
export class TaskListService {

  constructor(private csiHttpService: CsiHttpService) { }

  /// GET TASK LIST
  GetTaskList():any{
    return this.csiHttpService.getAll(API_URL.TASK_MANAGER.ROOT);
  }

  SearchTaskList(data:URLSearchParams):any{
    return this.csiHttpService.search(API_URL.TASK_MANAGER.SEARCH,data);
  }

  Delete(id:number){
    return this.csiHttpService.delete(API_URL.TASK_MANAGER.ROOT,id);
  }
}
