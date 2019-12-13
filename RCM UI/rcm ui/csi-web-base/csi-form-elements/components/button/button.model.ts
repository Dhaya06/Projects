import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";

export const ComponentId = FormElementRegistry.button;

export interface CsiButton {
    componentId:string,
    id: string;
    name: string;
    type:string;
    cell?: string;
    text?: string;
    classes?: string;
    disabled?: boolean;
    isSubmit?: boolean
    events?: CsiButtonEvents
}

export interface CsiButtonEvents {
    click?: any;
    dblclick?: any;
}

export const EmptyCsiButtonModel:CsiButton = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "button",
    disabled : false,
    isSubmit: false,
    text: "BUTTON"
}

export function getButtonComponenetFromEmptyModel(data: CsiButton): CsiButton{
    return {
        componentId: ComponentId,
        id : data.name,
        name : data.name,
        type : "button",
        cell: data.cell,
        text: data.text ? data.text : "",
        classes : data.classes ? data.classes : "btn",
        disabled : data.disabled ? data.disabled : false,
        isSubmit: data.isSubmit ? data.isSubmit : false
    }
}