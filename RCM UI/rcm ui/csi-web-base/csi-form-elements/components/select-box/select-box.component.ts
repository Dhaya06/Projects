import { Component, forwardRef, Renderer, ElementRef, OnInit, Input, Output, EventEmitter, Injector, HostListener, SimpleChanges, ChangeDetectorRef, ChangeDetectionStrategy } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor, FormGroup, FormControl, Validators } from '@angular/forms';
import { GetValidators } from '../../validator.map';
import { CsiSelectBoxInput, ComponentId } from './select-box.model';
import { SelectBoxService } from './select-box.service';
import { CsiBaseComponent, ComponentRegistry } from 'csi-base';
import { CsiSelectOption } from '../../models/csi-select.model';

@Component({
  selector: 'csi-select-box',
  templateUrl: './select-box.component.html',
  styleUrls: ['./select-box.component.css'],
})
@ComponentRegistry({
  componentId: ComponentId,
  service: SelectBoxService
})
export class SelectBoxComponent extends CsiBaseComponent implements OnInit, ControlValueAccessor {
  
  // Input variables
  @Input() csiName: string = "";
  @Input() csiControllerName: string
  @Input() csiFormGroup: FormGroup
  @Input() label: string = "";
  @Input() classes: string = "";
  @Input() placeholder: string = "";
  @Input() disabled: boolean = false;
  @Input() options: any[] = [];
  @Input() value: any = "";
  @Input() id: string = "";
  @Input() validation_rules: any[] = [];
  
  // Output variables
  @Output() onSelect = new EventEmitter();
  @Output() onBlur = new EventEmitter();
  
  control: FormControl = null;
  validators: any[] = [];
  validation_messages: any[] = [];
  eventEmitter = new EventEmitter<any>();
  
  constructor(private _elementRef:ElementRef, private _renderer:Renderer, private injector: Injector, private cdRef: ChangeDetectorRef ) {super();
  }
  
  // Get value
  get _value() {
    return this.value;
  }
  
  // Set value
  set _value(val) {
    this.value = val;
    this._onChange(val);
  }
  
  // On value changed
  _onChange: any = (c) => {
    
    // Set controller value when field value changes
    this.csiFormGroup.get(this.csiControllerName).setValue(c, {emitEvent: true})
  };
  
  // On Touched
  _onTouched: any = (d) => { 
    this.control.markAsTouched();
  };
  
  // Write value
  writeValue(value: string): void {
    if(value !== undefined){
      this._value = value;
    }
  }
  
  // Register on chagne event
  registerOnChange(fn: any): void {
    this._onChange = fn;
  }
  
  // Register on touch event
  registerOnTouched(fn: any): void {
    this._onTouched = fn;
  }
  
  // Register on disable event
  setDisabledState?(isDisabled: boolean): void {
    this._renderer.setElementProperty(this._elementRef.nativeElement, 'disabled', isDisabled);
  }
  
  // ON BLUR EMIT
  onBlurEmit(){
    this._onTouched();
    if(this.onBlur != null){
      this.onBlur.emit(event);
    }
  }
  
  // Element event listners
  // Host listners are triggers as 2 ways.
  // 1. Dynamic Elements - Trigger as function
  // 2. Static Elements - Trigger as Event Emmitter
  
  /// Detect on input changes
  ngOnChanges(changes: SimpleChanges) {
    
  }
  
  ngOnInit() {
    
    // Get validators from map
    this.validators = GetValidators(this.validation_rules);
    
    // Create new form contrl
    this.control = new FormControl(this.value, Validators.compose(this.validators)); 
    
    // Add control to form group
    if(this.csiFormGroup){
      this.csiFormGroup.addControl(this.csiControllerName, this.control);
    }
  }
  
  // On field value search
  onSearchChange(val : any ) {  
    this._value = val;
  }
  
  // Set error messages
  errorMessage():any{
    let errorMessages = null;
    for (let propertyName in this.control.errors) {
      if (this.control.errors.hasOwnProperty(propertyName) && this.control.touched) {
        errorMessages = this.getValidatorErrorMessage(propertyName, this.control.errors[propertyName]);
      }
    }
    return errorMessages;
  }
  
  // Get validation error messages
  getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
    
    let config = {
      'required': 'Required'
    };
    
    return config[validatorName];
  }
}
