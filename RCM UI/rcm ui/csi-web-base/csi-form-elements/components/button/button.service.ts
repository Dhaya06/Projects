import { Injectable } from '@angular/core';
import { ButtonComponent } from './button.component';

@Injectable()
export class ButtonService {

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
        type: content.type,
        isSubmit: content.isSubmit,
        text: content.text
      },
      outputs: {
        click: content.events && content.events.click ? content.events.click: null,
        dblclick: content.events && content.events.dblclick ? content.events.dblclick : null
      }
    };
  }

}
