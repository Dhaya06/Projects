import { Component, OnInit, Input, Injector, SimpleChanges, ChangeDetectionStrategy } from '@angular/core';
import { CsiLabel, ComponentId } from './csi-label.model';
import { NG_VALUE_ACCESSOR } from '@angular/forms';
import { LabelService } from './label.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-label',
  templateUrl: './csi-label.component.html',
  styleUrls: ['./csi-label.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: CsiLabelComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  
})
@ComponentRegistry({
  componentId: ComponentId,
  service: LabelService
})
export class CsiLabelComponent  extends CsiBaseComponent {
  
  @Input() text: string = "";
  @Input() id: string = "";
  @Input() name: string = "";
  @Input() classes: string = "";
  
  constructor(private injector: Injector) {super();
  }

  // On Init
  ngOnInit() {
  }
  
  /// Detect on input changes
  ngOnChanges(changes: SimpleChanges) {
    
  }
}