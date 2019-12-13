import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.buttonDropdown;

export interface CsiButtonDropdown {
    componentId:string,
    id: string;
    name: string;
    type:string;
    cell?: string;
    text?: string;
    classes?: string;
    disabled?: boolean;
    items?: any[],
    events?: CsiButtonDropdownEvents,
}

export interface CsiButtonDropdownEvents {
    itemClicked?: any;
}

export const EmptyCsiButtonDropdownModel:CsiButtonDropdown = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "buttonDropdown",
    disabled : false,
    text: "DROPDOWN",
    items: []
}

export function getButtonDropdownComponenetFromEmptyModel(data: CsiButtonDropdown): CsiButtonDropdown{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "button",
        cell: data.cell,
        text: data.text ? data.text : "",
        classes : data.classes ? data.classes : "btn",
        disabled : data.disabled ? data.disabled : false,
        items: data.items ? data.items: []
    }
}