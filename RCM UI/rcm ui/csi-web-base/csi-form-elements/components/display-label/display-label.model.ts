import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.displayLabel;

export interface CsiDisplayLabel {
    componentId:string,

    id: string;
    name: string;
    type: string;
    key?: string;
    value?: string;
    cell?: string;
    classes?: string;
}

export const EmptyCsiDisplayLabelModel:CsiDisplayLabel = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "label",
    key: "",
    value: "",
    classes: ""
}

export function getDisplayLabelComponenetFromEmptyModel(data: CsiDisplayLabel): CsiDisplayLabel{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "label",
        key: data.key? data.key: "",
        value: data.value? data.value: "",
        classes : data.classes? data.classes: "csi-label",
        cell: data.cell? data.cell : ""
    }
}