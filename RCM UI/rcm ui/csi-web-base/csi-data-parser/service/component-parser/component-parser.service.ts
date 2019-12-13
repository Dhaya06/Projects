import { Injectable } from '@angular/core';
import { CsiBaseService } from 'csi-base';

@Injectable()
export class ComponentParserService {
  
  data: any = null;
  
  constructor(private csiBaseService: CsiBaseService) { }

  // Get dynamic component
  GetComponent(content){
    let registeredComponent = this.csiBaseService.GetComponent(content.componentId);
    if(registeredComponent != null && registeredComponent.service && new registeredComponent.service().GetDynamicComponent){
      return {
        component: registeredComponent.component,
        iot : new registeredComponent.service().GetDynamicComponent(content)
      }
    }else{
      return null;
    }
  }
}