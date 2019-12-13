import { CsiSelectBoxMultipleInput, ComponentId } from './select-box-multiple.model';
import { Component, forwardRef, Renderer, ElementRef, OnInit, Input, Output, EventEmitter, Injector, HostListener, SimpleChanges, ChangeDetectorRef, ChangeDetectionStrategy } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor, FormGroup, FormControl, Validators } from '@angular/forms';
import { GetValidators } from '../../validator.map';
import { SelectBoxMultipleService } from './select-box-multiple.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-select-box-multiple',
  templateUrl: './select-box-multiple.component.html',
  styleUrls: [ './select-box-multiple.component.css' ],
})
@ComponentRegistry({
  componentId: ComponentId,
  service: SelectBoxMultipleService
})
export class SelectBoxMultipleComponent extends CsiBaseComponent implements OnInit, ControlValueAccessor {

   // Input variables
   @Input('csiName') _csiName: string = "";
   @Input('csiControllerName') _csiControllerName: string
   @Input('csiFormGroup') _csiFormGroup: FormGroup
   @Input('label') _label: string = "";
   @Input('classes') _classes: string = "";
   @Input('placeholder') _placeholder: string = "";
   @Input('disabled') _disabled: boolean = false;
   @Input('options') _options: any[] = [];
   @Input('value') _value: any = "";
   @Input('validation_rules') _validation_rules: any[] = [];
   @Input('id') _id: string = "";
   
  // Output variables
  @Output('onChange') _onSelect = new EventEmitter();
  @Output('onOpen') _onOpen = new EventEmitter();
  @Output('onClose') _onClose = new EventEmitter();
  @Output('onFocus') _onFocus = new EventEmitter();
  @Output('onBlur') _onBlur = new EventEmitter();
   
   control: FormControl = null;
   validators: any[] = [];
   validation_messages: any[] = [];
   eventEmitter = new EventEmitter<any>();
   
   // Get value
   get value() {
     return this._value;
   }
   
   // Set value
   set value(val) {
     this._value = val;
     this._onChange(val);
   }

   get options(){
      return this._options;
   }

   set options(options){
     this._options = options;
   }
   
   // On value changed
   _onChange: any = (c) => {
     
     // Set controller value when field value changes
     this.config.csiFormGroup.get(this.config.csiControllerName).setValue(c, {emitEvent: true})
   };
   
   // On Touched
   _onTouched: any = (d) => { 
     this.control.markAsTouched();
   };
   
   // Write value
   writeValue(value: any): void {
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
   
   // Initialize configuration object
   config: CsiSelectBoxMultipleInput = {
    componentId: ComponentId,
     id: null,
     name: null,
     type: "text",
     csiControllerName : null,
     csiFormGroup: null,
     disabled: false,
     classes: "",
     options : [],
     value: null,
     validation_rules: [],
     events: {
      change : new EventEmitter(),
      open : new EventEmitter(),
      close : new EventEmitter(),
      focus : new EventEmitter(),
      blur : new EventEmitter()
     }
   }
   
   constructor(private _elementRef:ElementRef, private _renderer:Renderer, private injector: Injector, private cdRef: ChangeDetectorRef ) {super();
 }
   
   // Element event listners
   // Host listners are triggers as 2 ways.
   // 1. Dynamic Elements - Trigger as function
   // 2. Static Elements - Trigger as Event Emmitter
   
   /// Detect on input changes
   ngOnChanges(changes: SimpleChanges) {
    console.log(changes._options);
     if(changes._options) this.config.options =  changes._options.currentValue;
     if(changes._value) this.config.value =  changes._value.currentValue;
     if(changes._id) this.config.id=  changes._id.currentValue;
     if(changes._name) this.config.name=  changes._name.currentValue;
     if(changes._csiControllerName) this.config.csiControllerName=  changes._csiControllerName.currentValue;
     if(changes._csiFormGroup) this.config.csiFormGroup =  changes._csiFormGroup.currentValue;
     if(changes._disabled) this.config.disabled =  changes._disabled.currentValue;
     if(changes._classes) this.config.classes =  changes._classes.currentValue;
     if(changes._validation_rules) this.config.validation_rules =  changes._validation_rules.currentValue;
     
   }
   
   ngOnInit() {
     
     // Get values from injectors - Inputs
     this.config.options =  this.injector.get('options', this._options);
     this.config.value =  this.injector.get('value', this._value);
     this.config.id = this.injector.get('id', this._id);
     this.config.name = this.injector.get('name', this._csiName);
     this.config.csiControllerName = this.injector.get('csiControllerName', this._csiControllerName);
     this.config.csiFormGroup =  this.injector.get('csiFormGroup', this._csiFormGroup);
     this.config.disabled =  this.injector.get('disabled', this._disabled);
     this.config.classes =  this.injector.get('classes', this._classes);
     this.config.validation_rules =  this.injector.get('validation_rules', this._validation_rules);
     
     // Get values from injectors - Outputs
     this.config.events.change = this.injector.get('change', this._onSelect);
     this.config.events.open = this.injector.get('open', this._onOpen);
     this.config.events.close = this.injector.get('close', this._onClose);
     this.config.events.focus = this.injector.get('focus', this._onFocus);
     this.config.events.blur = this.injector.get('blur', this._onBlur);
     
     
     // Get validators from map
     this.validators = GetValidators(this.config.validation_rules);
     
     // Create new form contrl
     this.control = new FormControl(this.config.value, Validators.compose(this.validators)); 
     
     // Add control to form group
     if(this.config.csiFormGroup){
       this.config.csiFormGroup.addControl(this.config.csiControllerName, this.control);
     }
     
     // Set default value to input field
    this.value = this.config.value;
    this.options = this.config.options;
   }
   
  // On field value search
  OnSelectionChange(val : any ) {  
    this.value = val;
  }

  open(){
    if(typeof this.config.events.open === 'function')
      this.config.events.open(null);
    else
      this.config.events.open.emit(null);
  }

  close(){
    if(typeof this.config.events.close === 'function')
      this.config.events.close(null);
    else
      this.config.events.close.emit(null);
  }

  focus(){
    if(typeof this.config.events.focus === 'function')
      this.config.events.focus(null);
    else
      this.config.events.focus.emit(null);
  }

  blur(){
    if(typeof this.config.events.blur === 'function')
      this.config.events.blur(null);
    else
      this.config.events.blur.emit(null);
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
