import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.checkbox;

export interface CsiCheckBoxInput {
    componentId:string,

    id: string;
    name: string;
    type:string;
    csiControllerName?: string;
    csiFormGroup?:FormGroup;
    label?: string;
    classes?: string;
    disabled?: boolean;
    value?: any;
    checked? : boolean,
    validation_rules?: any[];
    events?: CsiCheckBoxInputEvents,
}

export interface CsiCheckBoxInputEvents {
    change?: any;
    click?: any;
}

export const EmptyCsiCheckBoxModel:CsiCheckBoxInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "checkbox",
    label : "",
    value : "",
    checked : false,
    disabled : false,
}

export function getCheckBoxComponenetFromEmptyModel(data: CsiCheckBoxInput): CsiCheckBoxInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "checkbox",
        label : data.label ? data.label : null,
        value : data.value ? data.value : null,
        checked : data.checked ? data.checked : null,
        disabled : data.disabled ? data.disabled : false,
        csiControllerName : data.name,
        csiFormGroup : data.csiFormGroup ? data.csiFormGroup : new FormGroup({}),
        classes : '',
        validation_rules : data.validation_rules ? data.validation_rules : []
    }
}