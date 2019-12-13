import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CsiDynamicComponentComponent } from './components/csi-dynamic-component/csi-dynamic-component.component';
import { ComponentParserService } from './service/component-parser/component-parser.service';
import { DynamicModule } from './lib/dynamic.module';
import 'rxjs/add/operator/takeUntil';
import { CsiBaseService, CsiBaseModule } from 'csi-base';

@NgModule({
  imports: [
    CommonModule,
    DynamicModule.withComponents([])
  ],
  declarations: [CsiDynamicComponentComponent],
  exports:[CsiDynamicComponentComponent],
  providers: [ComponentParserService, CsiBaseService]
})
export class CsiDataParserModule extends CsiBaseModule {
  constructor(){
    super();
  }
}