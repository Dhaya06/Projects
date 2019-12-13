import { SelectBoxMultipleComponent } from './select-box-multiple.component';
import { Injectable } from '@angular/core';

@Injectable()
export class SelectBoxMultipleService {

  // Bind data into dynamic component 
  // This use for generate component in dynamic component binding
  GetDynamicComponent = function(content){
    return {
      inputs: {
        id: content.id,
        name: content.name,
        csiControllerName: content.name,
        csiFormGroup: content.csiFormGroup,
        disabled: content.disabled,
        classes: content.classes,
        value: content.value,
        options : content.options,
        validation_rules: content.validation_rules
      },
      outputs: {
        change: content.events && content.events.change ? content.events.change: null,
        open: content.events && content.events.open ? content.events.open : null,
        close: content.events && content.events.close ? content.events.close : null,
        focus: content.events && content.events.focus ? content.events.focus : null,
        blur: content.events && content.events.blur ? content.events.blur : null
      }
    };
  }
}
