import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'csi-base',
  template: ''
})
export class CsiBaseComponent implements OnInit {
  constructor(){
  }

  ngOnInit() {
  }
}

export interface CsiComponent extends Component {
  componentId: string, 
  service?: any
}

//// SET CSI COMPONENT DECORATOR
export function CsiComponent(extendedConfig: CsiComponent) {
  return function (target: Function) {
      const ANNOTATIONS = '__annotations__';
      const PARAMETERS = '__paramaters__';
      const PROP_METADATA = '__prop__metadata__';

      const annotations = target[ANNOTATIONS] || [];
      const parameters = target[PARAMETERS] || [];
      const propMetadata = target[PROP_METADATA] || [];

      if (annotations.length > 0) {
          const parentAnnotations = Object.assign({}, annotations[0]);

          Object.keys(parentAnnotations).forEach(key => {
              if (parentAnnotations.hasOwnProperty(key)) {
                  if (!extendedConfig.hasOwnProperty(key)) {
                      extendedConfig[key] = parentAnnotations[key];
                      annotations[0][key] = '';
                  } else {
                      if (extendedConfig[key] === parentAnnotations[key]){
                           annotations[0][key] = '';
                      }
                  }
              }
          });
      }

      return Component(extendedConfig)(target);
  };
}
