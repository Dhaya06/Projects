import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.textarea;

export interface CsiTextAreaInput {
    componentId:string,

    id: string;
    name: string;
    type:string;
    cell?: string;
    csiControllerName?: string;
    csiFormGroup?:FormGroup;
    label?: string;
    classes?: string;
    placeholder?: string;
    disabled?: boolean;
    value?: any;
    validation_rules?: any[];
    maxLength?: number;
    minLength?: number;
    cols?: number;
    rows?: number;
    events?: CsiTextAreaInputEvents,
}

export interface CsiTextAreaInputEvents {
    blur?: any;
    keyup?: any;
    keypress?: any;
    keydown?: any;
}

export const EmptyCsiTextAreaInputModel:CsiTextAreaInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "textarea",
    placeholder: "",
    label : "",
    value : "",
    disabled : false,
}

export function getTextAreaComponenetFromEmptyModel(data: CsiTextAreaInput): CsiTextAreaInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        cols : data.cols ? data.cols : null,
        rows : data.rows ? data.rows : null,
        type : "textarea",
        placeholder: data.placeholder ? data.placeholder : null,
        label : data.label ? data.label : null,
        value : data.value ? data.value : null,
        disabled : data.disabled ? data.disabled : false,
        cell: data.cell,
        csiControllerName : data.name,
        csiFormGroup : data.csiFormGroup ? data.csiFormGroup : new FormGroup({}),
        classes : 'form-control',
        validation_rules : data.validation_rules ? data.validation_rules : [],
        maxLength : data.maxLength ? data.maxLength : null,
        minLength : data.minLength ? data.minLength : null,
    }
}