

# CsiRcm

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.5.4.

## csi-custom control configured

csi-toast 
`How to Use Toast`
``` 
show(){
    this.toastr.success("message","Title", {
      timeOut: 3000,
      progressBar: true,
      closeButton : true,

    });
  }

```
csi-aleart 
`How to Use Alert` 
``` 
open(){
    this.csiAlertService.warning("i am Alite Title Dark ","I am alive Body Dark", "Submit", "custom cancel ")
  }
```

csi-validation 
`How to Use Alert` 
``` 
this.userForm = new FormGroup({
      userEmail: new FormControl('', CommonValidator.email),
      phoneNumber : new FormControl('',CommonValidator.phone)
    });

```

csi-datagrid
`How to use`
```
1. Create a folder called "csi_modules" in root of the folder.
2. unzip and copy "csi-grid" folder to "csi-modules" folder.
3. run this command to add kendo libraries to your project.
npm install --save @progress/kendo-angular-grid @progress/kendo-angular-dropdowns @progress/kendo-angular-inputs @progress/kendo-angular-dateinputs @progress/kendo-data-query @progress/kendo-angular-intl @progress/kendo-angular-l10n @progress/kendo-drawing @progress/kendo-angular-excel-export @angular/animations @progress/kendo-theme-bootstrap
4. import "kendo-theme-bootstrap" to styles.scss
@import "~@progress/kendo-theme-bootstrap/scss/all";
5. import cs-grid module to your module and add to imports array.
import { CsiGridModule } from '../../csi_modules/csi-grid/csi-grid.module';
imports: [
    ...,
    CsiGridModule
],
6. In your html use this element to render grid
<csi-grid [data]="dataSet" [columns]="columns"></csi-grid>
7. Import import csi-grid.model to your component define dataSet and columns as follows,
///// Define colomns
import { CsiGridColumn } from '../../csi_modules/csi-grid/csi-grid.model';
  columns: CsiGridColumn[] = [
    {
      field : "id", // -> fields from database array
      title: "ID"     // -> Display name of the columns
    }, {
      field: "title",
      title: "TITLE"
    }, {
      field: "body",
      title: "BODY"
    }
    
  ];
  
  /// Define dataSet
  
   this.dataSet = posts; // data from your back-end service
```

csi-Input-Elemant
`How to use`
```
1.Text Box
		<csi-text-box
        [id] = "'profile_name'"
        [csiFormGroup] = "profileCreateFormGroup"
        [csiControllerName]="'profile_name'"
        [label]="'Profile Name'"
        [classes] = "'form-control'"
        [disabled] = "false"
        [placeholder] = "'Enter Profile Name'"
        ></csi-text-box>
		
2.Select Box 
		<csi-select-box
        [csiFormGroup] = "profileCreateFormGroup"
        [csiName] = "'payer_category'"
        [csiControllerName]="'payer_category'"
        [label]="'Payer Category'" 
        [disabled] = "false"
        [options] = "prayerListItems"
        [value] = "2"
        [classes] = "'form-control'"
        [validation_rules] = '[]'
        (onChange) = "selectBoxChange($event)"
        ></csi-select-box> 
		 
		///// SELECT BOX DATA //////////////////////////////  
		prayerListItems : CsiSelectOption[] = [
		{
		id: 1,
		name: "Insurance"
		}, {
		id: 2,
		name: "Government"
		}, {
		id: 3,
		name: "Regular"
		}
		]
		
3.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
