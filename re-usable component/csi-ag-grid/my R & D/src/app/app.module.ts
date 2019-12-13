import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AgGridModule} from "ag-grid-angular/main";
import {AppComponent} from "./app.component";
import {MyGridApplicationComponent} from "./my-grid-application/my-grid-application.component";
import {RedComponentComponent} from "./red-component/red-component.component";
import { CsiGridModule } from "./csi-grid/csi-grid.module";
import { ConsumerComponent } from './consumer/consumer.component';
import { DetailCellRenderer  } from './detail-cell-render-agent/detail-cell-render-agent.component';
import { GridService } from "./csi-grid/grid-service";
import { EditorRendererComponent } from './editor-renderer/editor-renderer.component';
import { DateTimePickerModule} from 'ngx-datetime-picker';
import { EditorDateTimeComponent } from './editor-date-time/editor-date-time.component';
import { DatetimePopupModule } from 'ngx-bootstrap-datetime-popup';
import { IsEditCheckComponent } from './is-edit-check/is-edit-check.component';
import { ConditionEditComponent } from './condition-edit/condition-edit.component';
import { GridSampleComponent } from './grid-sample/grid-sample.component';
import { FormsModule } from '@angular/forms';
// import { TreeDataComponent } from './tree-data/tree-data.component';
@NgModule({
    declarations: [
        AppComponent,
        ConsumerComponent,
        EditorRendererComponent,
        EditorDateTimeComponent,
        IsEditCheckComponent,
        ConditionEditComponent,
        GridSampleComponent
        
    ],
    imports: [
        BrowserModule,
        AgGridModule.withComponents(
            [RedComponentComponent,
                EditorRendererComponent,
                EditorDateTimeComponent,
            IsEditCheckComponent]
        ),
        CsiGridModule,
        DateTimePickerModule,
        DatetimePopupModule,
        FormsModule
    ],
    providers: [GridService],
    bootstrap: [AppComponent],
    entryComponents:[EditorRendererComponent]
})
export class AppModule {
}
