import { Component, OnInit, Output, EventEmitter, HostListener, Input, Injector, ChangeDetectionStrategy, ChangeDetectorRef, SimpleChanges } from '@angular/core';
import { CsiButton, ComponentId } from './button.model';
import { NG_VALUE_ACCESSOR, FormGroup } from '@angular/forms';
import { ButtonService } from './button.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: ButtonComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,

})
@ComponentRegistry({
  componentId: ComponentId,
  service: ButtonService
})
export class ButtonComponent extends CsiBaseComponent {
  
  // Input Variables
  @Input() id: string = "";
  @Input() name: string = "";
  @Input() type: string = "";
  @Input() text: string = "";
  @Input() classes: string = "";
  @Input() disabled: boolean = false;
  @Input() isSubmit: boolean = false;
  
  // Output variables
  @Output() click = new EventEmitter(); 
  @Output() dblclick = new EventEmitter(); 
  
  constructor(private injector: Injector, private cdRef: ChangeDetectorRef) {
    super();
  }

  ngOnInit() {
    
  }
}
