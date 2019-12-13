import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
import { CsiSelectOption } from "../../models/csi-select.model";
export const ComponentId = FormElementRegistry.select;

export interface CsiSelectBoxInput {
    componentId:string,
    id: string;
    name: string;
    type:string;
    csiControllerName?: string;
    csiFormGroup?:FormGroup;
    label?: string;
    classes?: string;
    disabled?: boolean;
    options : CsiSelectOption[];
    value?: any;
    validation_rules?: any[];
    events?: CsiSelectBoxInputEvents,
}

export interface CsiSelectBoxInputEvents {
    change?: any;
    blur?: any;
}

export const EmptyCsiSelectBoxInputModel:CsiSelectBoxInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "select",
    label : "",
    options : new Array<CsiSelectOption>(),
    value : null,
    disabled : false,
}

export function getSelectBoxComponenetFromEmptyModel(data: CsiSelectBoxInput): CsiSelectBoxInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "select",
        label : data.label ? data.label : null,
        options : data.options ? data.options : new Array<CsiSelectOption>(),
        value : data.value ? data.value : null,
        disabled : data.disabled ? data.disabled : false,
        csiControllerName : data.name,
        csiFormGroup : data.csiFormGroup ? data.csiFormGroup : new FormGroup({}),
        classes : 'form-control',
        validation_rules : data.validation_rules ? data.validation_rules : [],
    }
}