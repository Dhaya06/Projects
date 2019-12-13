import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Import form elements
import { TextBoxComponent } from './components/text-box/text-box.component';
import { SelectBoxComponent } from './components/select-box/select-box.component';
import { SelectBoxMultipleComponent } from './components/select-box-multiple/select-box-multiple.component';
import { PasswordBoxComponent } from './components/password-box/password-box.component';
import { TextareaBoxComponent } from './components/textarea-box/textarea-box.component';
import { CheckBoxComponent } from './components/check-box/check-box.component';
import { RadioButtonComponent } from './components/radio-button/radio-button.component';
import { TextBoxService } from './components/text-box/text-box.service';
import { PasswordBoxService } from './components/password-box/password-box.service';
import { TextareaBoxService } from './components/textarea-box/textarea-box.service';
import { ButtonComponent } from './components/button/button.component';
import { ButtonService } from './components/button/button.service';
import { CsiLabelComponent } from './components/label/csi-label.component';
import { LabelService } from './components/label/label.service';
import { DisplayLabelComponent } from './components/display-label/display-label.component';
import { DisplayLabelService } from './components/display-label/display-label.service';
import { BsDropdownModule } from 'ngx-bootstrap';
import { ButtonDropdownComponent } from './components/button-dropdown/button-dropdown.component';
import { RadioButtonService } from './components/radio-button/radio-button.service';
import { CheckBoxService } from './components/check-box/check-box.service';
import { SelectBoxService } from './components/select-box/select-box.service';
import { SelectBoxMultipleService } from './components/select-box-multiple/select-box-multiple.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DropDownsModule } from '@progress/kendo-angular-dropdowns';
import { CsiBaseModule } from 'csi-base';

let Components: any[] = [
  TextBoxComponent, 
  SelectBoxComponent,
  SelectBoxMultipleComponent,
  PasswordBoxComponent, 
  TextareaBoxComponent, 
  CheckBoxComponent, 
  RadioButtonComponent,
  ButtonComponent, 
  CsiLabelComponent,
  DisplayLabelComponent,
  ButtonDropdownComponent
];

@NgModule({
  imports: [
    CommonModule,
    BsDropdownModule.forRoot(),
    DropDownsModule,
  ],
  declarations: Components,
  exports: Components,
  entryComponents: Components,
  providers:[]
})
export class FormElementsModule extends CsiBaseModule {
  constructor(){
    super();
  }
 }

// Input element service mapper
export const InputElementServiceMapper = {
  text : new TextBoxService(),
  password: new PasswordBoxService(),
  textarea: new TextareaBoxService(),
  button: new ButtonService(),
  label: new LabelService(),
  displayLabel: new DisplayLabelService(),
  checkbox : new CheckBoxService(),
  radio : new RadioButtonService(),
  select : new SelectBoxService(),
  select_multiple : new SelectBoxMultipleService()
}