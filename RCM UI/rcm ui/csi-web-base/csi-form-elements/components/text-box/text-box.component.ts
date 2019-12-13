import { Component, OnInit, Input, ElementRef, Renderer, Injector, ChangeDetectionStrategy, ChangeDetectorRef, Output, EventEmitter, HostListener, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, NG_VALUE_ACCESSOR, Validators, ControlValueAccessor } from '@angular/forms';
import { GetValidators } from '../../validator.map';
import { CsiTextInput, ComponentId } from './text-box.model';
import { TextBoxService } from './text-box.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-text-box',
  templateUrl: './text-box.component.html',
  styleUrls: ['./text-box.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: TextBoxComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush
})
@ComponentRegistry({
  componentId: ComponentId,
  service: TextBoxService,
})
export class TextBoxComponent extends CsiBaseComponent implements OnInit, ControlValueAccessor  {
  
  // Input variables
  @Input() csiName: string;
  @Input() csiControllerName: string
  @Input() csiFormGroup: FormGroup
  @Input() label: string;
  @Input() classes: string;
  @Input() placeholder: string;
  @Input() disabled: boolean = false;
  @Input() value: string = null;
  @Input() validation_rules: any[];
  @Input() id: string;
  
  // Output variables
  @Output() onBlur = new EventEmitter();
  @Output() onKeyPress = new EventEmitter();
  @Output() onKeyUp = new EventEmitter();
  
  control: FormControl = null;
  validators: any[] = [];
  validation_messages: any[] = [];
  eventEmitter = new EventEmitter<any>();
  
  constructor(private _elementRef:ElementRef, private _renderer:Renderer, private injector: Injector, private cdRef: ChangeDetectorRef ) {
    super();
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
  onSearchChange(val : string ) {  
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
      'required': 'Required',
      'minlength': `Minimum length ${validatorValue.requiredLength}`,
      'maxlength': `Maximum length ${validatorValue.requiredLength}`
    };
    
    return config[validatorName];
  }
  
}
