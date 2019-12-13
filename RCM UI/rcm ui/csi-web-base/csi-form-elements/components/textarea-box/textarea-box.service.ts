import { Injectable } from '@angular/core';
import { TextareaBoxComponent } from './textarea-box.component';

@Injectable()
export class TextareaBoxService {

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
        placeholder: content.placeholder,
        classes: content.classes,
        value: content.value,
        validation_rules: content.validation_rules,
        cols: content.cols,
        rows: content.rows
      },
      outputs: {
        blur: content.events && content.events.blur ? content.events.blur: null,
        keypress: content.events && content.events.keypress ? content.events.keypress : null,
        keyup: content.events && content.events.keyup ? content.events.keyup : null,
        onKeyDown: content.events && content.events.onKeyDown ? content.events.onKeyDown : null
      }
    };
  }
}
