import { Injectable } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Injectable()
export class CsiFormBuilderService {

  formGroup: FormGroup;
  
    constructor(private formBuilder: FormBuilder) { 
      this.formGroup = new FormGroup({});
    }

  // Generate new Form Group
  GetFormGroup(){
    return this.formGroup;
  }

  // Generate form fields
  // [formGroup] - Form group
  // [fields] - Fields aray
  GetFormFields(formGroup: FormGroup, fields: any[]){
    fields.forEach((field, key) => {
      field["FormGroup"] = formGroup;
    });
    return fields;
  }

}