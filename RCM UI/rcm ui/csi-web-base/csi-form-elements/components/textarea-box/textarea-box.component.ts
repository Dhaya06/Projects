import { Component, OnInit, Input, ChangeDetectionStrategy, EventEmitter, Output, ElementRef, Renderer, Injector, ChangeDetectorRef, HostListener, SimpleChanges } from '@angular/core';
import { FormControl, NG_VALUE_ACCESSOR, FormGroup, Validators } from '@angular/forms';
import { CsiTextAreaInput, ComponentId } from './textarea-box.model';
import { GetValidators } from '../../validator.map';
import { TextareaBoxService } from './textarea-box.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-textarea',
  templateUrl: './textarea-box.component.html',
  styleUrls: ['./textarea-box.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: TextareaBoxComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
  
})
@ComponentRegistry({
  componentId: ComponentId,
  service: TextareaBoxService
})
export class TextareaBoxComponent extends CsiBaseComponent implements OnInit {
  
  // Input variables
  @Input() csiName: string = "";
  @Input() csiControllerName: string
  @Input() csiFormGroup: FormGroup
  @Input() label: string = "";
  @Input() classes: string = "";
  @Input() placeholder: string = "";
  @Input() disabled: boolean = false;
  @Input() value: string = "";
  @Input() validation_rules: any[] = [];
  @Input() id: string = "";
  @Input() cols: string = "";
  @Input() rows: string = "";
  
  // Output variables
  @Output() onBlur = new EventEmitter();
  @Output() onKeyPress = new EventEmitter();
  @Output() onKeyUp = new EventEmitter();
  
  control: FormControl = null;
  validators: any[] = [];
  validation_messages: any[] = [];
  eventEmitter = new EventEmitter<any>();


  constructor(private _elementRef:ElementRef, private _renderer:Renderer, private injector: Injector, private cdRef: ChangeDetectorRef) {super();
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
  
  // Initialize configuration object
  
  // Element event listners
  // Host listners are triggers as 2 ways.
  // 1. Dynamic Elements - Trigger as function
  // 2. Static Elements - Trigger as Event Emmitter
  
  
  /// Detect on input changes
  // ngOnChanges(changes: SimpleChanges) {
    
  //   if(changes._value) this.value =  changes._value.currentValue;
  //   if(changes._id) this.id=  changes._id.currentValue;
  //   if(changes._name) this.name=  changes._name.currentValue;
  //   if(changes._csiControllerName) this.csiControllerName=  changes._csiControllerName.currentValue;
  //   if(changes._label) this.label =  changes._label.currentValue;
  //   if(changes._csiFormGroup) this.csiFormGroup =  changes._csiFormGroup.currentValue;
  //   if(changes._disabled) this.disabled =  changes._disabled.currentValue;
  //   if(changes._placeholder) this.placeholder =  changes._placeholder.currentValue;
  //   if(changes._classes) this.classes =  changes._classes.currentValue;
  //   if(changes._validation_rules) this.validation_rules =  changes._validation_rules.currentValue;
  //   if(changes._rows) this.rows =  changes._rows.currentValue;
  //   if(changes._cols) this.validation_rules =  changes._cols.currentValue;
    
  // }
  
  
  ngOnInit() {
    
    // Get values from injectors - Inputs
    // this.value =  this.injector.get('value', this._value);
    // this.id = this.injector.get('id', this._id);
    // this.name = this.injector.get('name', this._csiName);
    // this.csiControllerName = this.injector.get('csiControllerName', this._csiControllerName);
    // this.label =  this.injector.get('label', this._label);
    // this.csiFormGroup =  this.injector.get('csiFormGroup', this._csiFormGroup);
    // this.disabled =  this.injector.get('disabled', this._disabled);
    // this.placeholder =  this.injector.get('placeholder', this._placeholder);
    // this.classes =  this.injector.get('classes', this._classes);
    // this.validation_rules =  this.injector.get('validation_rules', this._validation_rules);
    // this.cols = this.injector.get('cols', this._cols);
    // this.rows = this.injector.get('rows', this._rows);
    
    // // Get values from injectors - Outputs
    // this.events.blur = this.injector.get('blur', this._onBlur);
    // this.events.keypress = this.injector.get('keypress', this._onKeyPress);
    // this.events.keyup = this.injector.get('keyup', this._onKeyUp);
    
    
    // Get validators from map
    this.validators = GetValidators(this.validation_rules);
    
    // Create new form contrl
    this.control = new FormControl(this.value, Validators.compose(this.validators)); 
    
    // Add control to form group
    if(this.csiFormGroup){
      this.csiFormGroup.addControl(this.csiControllerName, this.control);
    }
    
    // Set default value to input field
    //this.value = this.value;
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
