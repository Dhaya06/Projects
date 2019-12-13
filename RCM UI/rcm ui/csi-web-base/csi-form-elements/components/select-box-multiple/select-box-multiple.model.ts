import { FormControl, FormGroup } from "@angular/forms";
import { FormElementRegistry } from "../../form-element-id.registry";
import { CsiSelectOption } from "../../models/csi-select.model";
export const ComponentId = FormElementRegistry.select_multiple;

export interface CsiSelectBoxMultipleInput {
    componentId:string,

    id: string;
    name: string;
    type:string;
    csiControllerName?: string;
    csiFormGroup?:FormGroup;
    classes?: string;
    disabled?: boolean;
    options : CsiSelectOption[];
    value?: any;
    validation_rules?: any[];
    events?: CsiSelectBoxMultipleInputEvents,
}

export interface CsiSelectBoxMultipleInputEvents {
    change?: any;
    open? : any;
    close? : any;
    focus? : any;
    blur?: any;
}

export const EmptyCsiMultiSelectInputModel:CsiSelectBoxMultipleInput = {
    componentId:ComponentId,
    id : "",
    name : "",
    type : "select_multiple",
    options : [],
    value : null,
    disabled : false,
}

export function getMultiSelectComponenetFromEmptyModel(data: CsiSelectBoxMultipleInput): CsiSelectBoxMultipleInput{
    return {
        componentId:ComponentId,
        id : data.name,
        name : data.name,
        type : "select_multiple",
        options : data.options ? data.options : [],
        value : data.value ? data.value : null,
        disabled : data.disabled ? data.disabled : false,
        csiControllerName : data.name,
        csiFormGroup : data.csiFormGroup ? data.csiFormGroup : new FormGroup({}),
        classes : '',
        validation_rules : data.validation_rules ? data.validation_rules : [],
    }
}