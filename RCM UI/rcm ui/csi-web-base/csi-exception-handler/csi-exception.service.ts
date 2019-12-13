import { Injectable } from '@angular/core';
import * as StackTrace from 'stacktrace-js';
import { CsiHttpService } from '../csi-http-handler/csi-http.service';
@Injectable()
export class CsiBaseErrorHandlerService {

  constructor(private csiHttp:CsiHttpService) { }
  
      handleError(error) {
          //locale message to be configured "const message = localizedError(params)"
          const message = error.message ? error.message : error.toString();
          const url = error.logUrl;
  
          // get the stack trace, lets grab the last 10 stacks only
          StackTrace.fromError(error).then(stackframes => {
              const stackString = stackframes.splice(0, 20).map(function (sf) { return sf.toString(); }).join('\n');
              // log the error to log slash server
              this.log({ message, url, stack: error.stackString,code: error.code});
          });
          throw error;
      }
  
      //add log to log slash
      private log(erorObj){
          this.csiHttp.add(erorObj.logUrl,erorObj);
      }
  
      // locale message implementation
      private localizedError(){
          // To be implemented
      }

}
