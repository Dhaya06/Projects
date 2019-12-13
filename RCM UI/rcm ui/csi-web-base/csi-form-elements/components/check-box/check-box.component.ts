import { CsiCheckBoxInput, ComponentId } from './check-box.model';
import { Component, forwardRef, Renderer, ElementRef, OnInit, Input, Output, EventEmitter, Injector, HostListener, SimpleChanges, ChangeDetectorRef, ChangeDetectionStrategy } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor, FormGroup, FormControl, Validators } from '@angular/forms';
import { GetValidators } from '../../validator.map';
import { CheckBoxService } from './check-box.service';
import { ComponentRegistry, CsiBaseComponent } from 'csi-base';

@Component({
  selector: 'csi-check-box',
  templateUrl: './check-box.component.html',
  styleUrls: ['./check-box.component.css'],
  providers: [
    {provide: NG_VALUE_ACCESSOR, useExisting: CheckBoxComponent, multi: true}
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
@ComponentRegistry({
  componentId: ComponentId,
  service: CheckBoxService
})
export class CheckBoxComponent  extends CsiBaseComponent implements OnInit ,ControlValueAccessor {
  // Input variables
  @Input('csiName') _csiName: string = "";
  @Input('csiControllerName') _csiControllerName: string
  @Input('csiFormGroup') _csiFormGroup: FormGroup
  @Input('label') _label: string = "";
  @Input('classes') _classes: string = "";
  @Input('placeholder') _placeholder: string = "";
  @Input('disabled') _disabled: boolean = false;
  @Input('value') _value: string = "";
  @Input('checked') _checked: boolean = false;
  @Input('validation_rules') _validation_rules: any[] = [];
  @Input('id') _id: string = "";

    // Output variables
  @Output('onChange') _onCheckedChange = new EventEmitter();
  @Output('onClick') _onClick = new EventEmitter();

  control: FormControl = null;
  validators: any[] = [];
  validation_messages: any[] = [];
  eventEmitter = new EventEmitter<any>();
  
  // Get value
  get checked() {
    return this._checked;
  }

  set checked(val) {
    this._checked = val;
    this._onChange(val);
  }

  // On checked changed
  _onChange: any = (c) => {
  
    // Set controller value when checked value changes
    this.config.csiFormGroup.get(this.config.csiControllerName).setValue(c, {emitEvent: true})
  };

  // On Touched
  _onTouched: any = (d) => { 
    this.control.markAsTouched();
  };
  
  writeValue(value: any): void {
    if(value !== undefined){
      this._checked = value;
    }
  }

  registerOnChange(fn: any): void {
    this._onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this._onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this._renderer.setElementProperty(this._elementRef.nativeElement, 'disabled', isDisabled);
  }
  
  // Initialize configuration object
  config: CsiCheckBoxInput = {
    componentId: ComponentId,
    id: null,
    name: null,
    type: "checkbox",
    label : "",
    csiControllerName : null,
    csiFormGroup: null,
    disabled: false,
    classes: "",
    value: "",
    checked : false,
    validation_rules: [],
    events: {
      change : new EventEmitter(),
      click : new EventEmitter()
    }
  }
  
  constructor(private _elementRef:ElementRef, private _renderer:Renderer, private injector: Injector, private cdRef: ChangeDetectorRef ) {super() }
  
  // Element event listners
  // Host listners are triggers as 2 ways.
  // 1. Dynamic Elements - Trigger as function
  // 2. Static Elements - Trigger as Event Emmitter
  
  // Host Listner - change
  @HostListener('change') onChange(){
    this._onTouched();
    if(this.config.events.change != null){
      if(typeof this.config.events.change === 'function'){
        this.config.events.change(event);
        return;
      }
      this.config.events.change.emit(event);
    }
  }
  
  // Host Listner - click
  @HostListener('click') onClick(){
    if(this.config.events.click != null){
      if(typeof this.config.events.click === 'function'){
        this.config.events.click(event);
        return;
      }
      this.config.events.click.emit(event);
    }
  }
  
  /// Detect on input changes
  ngOnChanges(changes: SimpleChanges) {
    if(changes._value) this.config.value =  changes._value.currentValue;
    if(changes._checked) this.config.checked =  changes._checked.currentValue;
    if(changes._id) this.config.id=  changes._id.currentValue;
    if(changes._name) this.config.name=  changes._name.currentValue;
    if(changes._csiControllerName) this.config.csiControllerName=  changes._csiControllerName.currentValue;
    if(changes._label) this.config.label =  changes._label.currentValue;
    if(changes._csiFormGroup) this.config.csiFormGroup =  changes._csiFormGroup.currentValue;
    if(changes._disabled) this.config.disabled =  changes._disabled.currentValue;
    if(changes._classes) this.config.classes =  changes._classes.currentValue;
    if(changes._validation_rules) this.config.validation_rules =  changes._validation_rules.currentValue;
    
  }
  
  ngOnInit() {
    // Get values from injectors - Inputs
    this.config.value =  this.injector.get('value', this._value);
    this.config.checked =  this.injector.get('checked', this._checked);
    this.config.id = this.injector.get('id', this._id);
    this.config.name = this.injector.get('name', this._csiName);
    this.config.csiControllerName = this.injector.get('csiControllerName', this._csiControllerName);
    this.config.label =  this.injector.get('label', this._label);
    this.config.csiFormGroup =  this.injector.get('csiFormGroup', this._csiFormGroup);
    this.config.disabled =  this.injector.get('disabled', this._disabled);
    this.config.classes =  this.injector.get('classes', this._classes);
    this.config.validation_rules =  this.injector.get('validation_rules', this._validation_rules);
    
    // Get values from injectors - Outputs
    this.config.events.change = this.injector.get('change', this._onCheckedChange);
    this.config.events.click = this.injector.get('click', this._onClick);
    
    
    // Get validators from map
    this.validators = GetValidators(this.config.validation_rules);
    
    // Create new form contrl
    this.control = new FormControl(this.config.value, Validators.compose(this.validators)); 
    
    // Add control to form group
    if(this.config.csiFormGroup){
      this.config.csiFormGroup.addControl(this.config.csiControllerName, this.control);
    }
    
    // Set default value to input field
    this.checked = this.config.checked;

  }
  
  // On field value search
  onSearchChange(val : any ) {  
    this.checked = val;
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
