import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
export const ComponentId = FormElementRegistry.radio;

export interface CsiRadioButtonInput {
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
    events?: CsiRadioButtonInputEvents,
}

export interface CsiRadioButtonInputEvents {
    change?: any;
    click?: any;
}

export const EmptyCsiRadioButtonInputModel:CsiRadioButtonInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "radio",
    label : "",
    value : "",
    checked : false,
    disabled : false,
}

export function getRadioButtonComponenetFromEmptyModel(data: CsiRadioButtonInput): CsiRadioButtonInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "radio",
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