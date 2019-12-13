import { FormGroup } from "@angular/forms";

export class CsiPageLayout {
    Type: string;
    ComponentId: string;
    Layout      : any[];
    CellContent : CellContent
}

export class CellContent {
    id : string;
    component: any;
    rows: number
    cols: number;
    x: number;
    y: number;
}