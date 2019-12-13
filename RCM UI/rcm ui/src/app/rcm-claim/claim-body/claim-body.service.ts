import { Injectable } from '@angular/core';
import { CsiHttpService } from '../../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../../_shared/API_URLS.const';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ClaimBodyService {

  constructor(private csiHttpService: CsiHttpService, private http: HttpClient) { }

  /// GET TASK LIST
  GetTaskList(): any {
    return this.csiHttpService.getAll(API_URL.PROCEDURE.GETALL);
  }

  GetPosts(): Observable<any> {
    return this.http.get('https://jsonplaceholder.typicode.com/photos');
  }

  GetAlbums(){
    return this.http.get('https://jsonplaceholder.typicode.com/albums');
    
  }

}
