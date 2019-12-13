import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiGridComponent } from './csi-grid.component';
import { GridModule } from '@progress/kendo-angular-grid';

@NgModule({
  imports: [
    CommonModule, GridModule
  ],
  declarations: [CsiGridComponent],
  exports: [CsiGridComponent]
})
export class CsiGridModule { }
