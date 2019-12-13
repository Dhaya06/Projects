import { Component, OnInit, Input, Output, EventEmitter, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { CellContent } from '../csi-page-layout/models/csi-page-layout.modal';

@Component({
  selector: 'csi-form',
  templateUrl: './csi-form.component.html',
  styleUrls: ['./csi-form.component.css']
})
export class CsiFormComponent implements OnInit {

  @Input("csiFormGroup") _csiFormGroup: FormGroup = null;
  @Input("csiFormFields") _csiFormFields: any[] = [];
  @Input("csiFormLayout") _layout: any[] = [];
  @Input("csiFieldEvents") _csiFieldEvents = {};
  @Input("csiComponentId") _componentId: string;
  @Output("csiSubmit") _csiSubmit = new EventEmitter();

  cell_content:CellContent;
  

  constructor(private formBuilder: FormBuilder, private sanitizer:DomSanitizer, private cdRef: ChangeDetectorRef) { 
  }

  // Emit Form submit
  submitForm(){
    this._csiSubmit.emit(this._csiFormGroup.value);
  }
  
  /// Method not implemented
  methodNotImplemented(){
    console.log("Method not implemented!");
  }

  ngOnInit() {
    this.cell_content = {
      Type : "form",
      Components: this._csiFormFields
    }
    this.cdRef.detectChanges();
  }

  ngAfterContentInit() {
  }

}