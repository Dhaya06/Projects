import { Injectable } from '@angular/core';
import { ButtonDropdownComponent } from './button-dropdown.component';

@Injectable()
export class ButtonDropdownService {

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
        text: content.text,
        items: content.items
      },
      outputs: {
        itemClicked: content.events && content.events.itemClicked ? content.events.itemClicked: null,
      }
    };
  }
}
