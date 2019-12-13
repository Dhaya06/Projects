import { Component, OnInit, Input, Injector, ChangeDetectionStrategy, SimpleChanges } from '@angular/core';
import { NG_VALUE_ACCESSOR } from '@angular/forms';
import { CsiDisplayLabel, ComponentId } from './display-label.model';
import { DisplayLabelService } from './display-label.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-display-label',
  templateUrl: './display-label.component.html',
  styleUrls: ['./display-label.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: DisplayLabelComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
@ComponentRegistry({
  componentId: ComponentId,
  service: DisplayLabelService
})
export class DisplayLabelComponent extends CsiBaseComponent {

  @Input() key: string = "";
  @Input() value: string = "";
  @Input() id: string = "";
  @Input() name: string = "";
  @Input() classes: string = "";

  constructor(private injector: Injector) {super();
 }

  // Initialize configuration object
  // config: CsiDisplayLabel = {
  //   componentId: ComponentId,
  //   id: null,
  //   name: null,
  //   type: "label",
  //   classes: "",
  //   key: "",
  //   value: ""
  // }

  // On Init
  ngOnInit() {

    // this.config.id = this.injector.get('id', this._id);
    // this.config.name = this.injector.get('name', this._name);
    // this.config.classes = this.injector.get('classes', this._classes);
    // this.config.key = this.injector.get('key', this._key);
    // this.config.value = this.injector.get('value', this._value);

  }

  /// Detect on input changes
  ngOnChanges(changes: SimpleChanges) {
    
    // if(changes._id) this.config.id=  changes._id.currentValue;
    // if(changes._name) this.config.name=  changes._name.currentValue;
    // if(changes._classes) this.config.classes=  changes._classes.currentValue;
    // if(changes._key) this.config.key=  changes._key.currentValue;
    // if(changes._value) this.config.value=  changes._value.currentValue;
    
  }

}
