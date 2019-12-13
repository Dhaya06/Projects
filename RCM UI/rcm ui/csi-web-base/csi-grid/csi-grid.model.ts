import { TemplateRef } from "@angular/core";
import { FormGroup } from "@angular/forms";

export interface CsiGridOptions {
    filterable?: any, // true, false, menu
    groupable?: boolean,
    pageable?: boolean,
    pageSize?: number,
    sortable?: boolean,
    scrollable?: boolean,
    skip?: number,
    selectable?: {enable: boolean, selectedRows?:number[], width?: number},
    editable?: {enable: boolean, formGroup: any, onUpdate?: Function},
    rowDisabled?: Function//{key: any, condition: any, value: any}
    rowDetailsTemplate?: any
}

export interface CsiGridColumn {
    field : string,
    title?: string,
    width?: number,
    filterable?: boolean,
    sortable?: boolean,
    filter?: string, // date, numeric, boolean
    editor?: string, // date, numeric, boolean
    format?: string, // {0:c}, {0:d}
    media?: any // (min-width: 680px), (min-width: 450px)
    template?: any,
    editTemplate?: any,
}