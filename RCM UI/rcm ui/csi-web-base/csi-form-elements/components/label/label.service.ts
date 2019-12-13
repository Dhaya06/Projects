import { Injectable } from '@angular/core';
import { CsiLabelComponent } from './csi-label.component';

@Injectable()
export class LabelService {

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
        text: content.text
      },
      outputs: {}
    };
  }

}
