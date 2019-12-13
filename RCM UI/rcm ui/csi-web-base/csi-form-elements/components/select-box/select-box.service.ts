import { Injectable } from '@angular/core';
import { SelectBoxComponent } from './select-box.component';

@Injectable()
export class SelectBoxService {

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
        options : content.options,
        validation_rules: content.validation_rules
      },
      outputs: {
        change: content.events && content.events.change ? content.events.change: null,
        blur: content.events && content.events.blur ? content.events.blur: null,
      }
    };
  }
}
