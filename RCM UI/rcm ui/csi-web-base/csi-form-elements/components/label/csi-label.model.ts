import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.label;

export interface CsiLabel {
    componentId:string,

    id: string;
    name: string;
    type: string;
    text?: string;
    cell?: string;
    classes?: string;
}

export const EmptyCsiLabelModel:CsiLabel = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "label",
    text: "",
    classes: ""
}

export function getLabelComponenetFromEmptyModel(data: CsiLabel): CsiLabel{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "label",
        text: data.text? data.text: "",
        classes : data.classes? data.classes: "csi-label",
        cell: data.cell? data.cell : ""
    }
}