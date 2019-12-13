import { Injectable } from '@angular/core';
import { CheckBoxComponent } from './check-box.component';

@Injectable()
export class CheckBoxService {

  constructor() { }

  // Bind data into dynamic component 
  // This use for generate component in dynamic component binding
  GetDynamicComponent = function(content){
    return {
      inputs: {
        id: content.id,
        name: content.name,
        csiControllerName: content.name,
        csiFormGroup: content.csiFormGroup,
        label: content.label,
        disabled: content.disabled,
        classes: content.classes,
        value: content.value,
        checked : content.checked,
        validation_rules: content.validation_rules
      },
      outputs: {
        change: content.events && content.events.change ? content.events.change: null,
        click: content.events && content.events.click ? content.events.click : null
      }
    };
  }
}
