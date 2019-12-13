import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.password;

export interface CsiPasswordInput {
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
    events?: CsiPasswordInputEvents,
}

export interface CsiPasswordInputEvents {
    blur?: any;
    keyup?: any;
    keypress?: any;
    keydown?: any;
}

export const EmptyCsiPasswordInputModel:CsiPasswordInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "password",
    placeholder: "",
    label : "",
    value : "",
    disabled : false,
}

export function getPasswordComponenetFromEmptyModel(data: CsiPasswordInput): CsiPasswordInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "password",
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