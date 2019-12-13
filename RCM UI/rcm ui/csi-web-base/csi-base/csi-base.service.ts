import { Injectable } from '@angular/core';

const ComponentRegistry :any[] = [];

@Injectable()
export class CsiBaseService {

  constructor(){}

  // Get Registered Component by id
  GetComponent(id: string){
    return ComponentRegistry[id] ? ComponentRegistry[id] : null;
  }

  // Get Registered Components
  GetRegisteredComponents(){
    return ComponentRegistry;
  }

  /// REGISTER COMPONENTS
  RegisterComponent(components){
    components.forEach(comp => {
      if(comp.__annotations__ && comp.__annotations__[0] && comp.__annotations__[0].componentId ){
        if(ComponentRegistry[comp.__annotations__[0].componentId]){
          throw new Error("COMPONENT ID DUPLICATED : " + comp.__annotations__[0].componentId);
        }else{
          let obj = {};
          obj["component"] = comp;
          if(comp.__annotations__[0].service){
            obj["service"] = comp.__annotations__[0].service;
          }
          ComponentRegistry[comp.__annotations__[0].componentId] = obj;
        }
      }
    });

  }
}
