import { Injectable } from '@angular/core';
import { DisplayLabelComponent } from './display-label.component';

@Injectable()
export class DisplayLabelService {

  constructor() { }

  // Bind data into dynamic component 
  // This use for generate component in dynamic component binding
  GetDynamicComponent = function(content){
    return {
      inputs: {
        id: content.id,
        name: content.name,
        disabled: content.disabled,
        classes: content.classes,
        key: content.key,
        value: content.value
      },
      outputs: {}
    };
  }
}
