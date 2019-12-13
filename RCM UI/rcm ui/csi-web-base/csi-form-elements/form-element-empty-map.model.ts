import { EmptyCsiTextInputModel, getTextComponenetFromEmptyModel } from "./components/text-box/text-box.model";
import { EmptyCsiPasswordInputModel, getPasswordComponenetFromEmptyModel } from "./components/password-box/password-box.model";
import { EmptyCsiTextAreaInputModel, getTextAreaComponenetFromEmptyModel } from "./components/textarea-box/textarea-box.model";
import { getButtonComponenetFromEmptyModel, EmptyCsiButtonModel } from "./components/button/button.model";
import { EmptyCsiLabelModel, getLabelComponenetFromEmptyModel } from "./components/label/csi-label.model";
import { EmptyCsiDisplayLabelModel, getDisplayLabelComponenetFromEmptyModel } from "./components/display-label/display-label.model";
import { EmptyCsiButtonDropdownModel, getButtonDropdownComponenetFromEmptyModel } from "./components/button-dropdown/button-dropdown.model";
import { EmptyCsiCheckBoxModel, getCheckBoxComponenetFromEmptyModel } from "./components/check-box/check-box.model";
import { EmptyCsiRadioButtonInputModel, getRadioButtonComponenetFromEmptyModel } from "./components/radio-button/radio-button.model";
import { EmptyCsiSelectBoxInputModel, getSelectBoxComponenetFromEmptyModel } from "./components/select-box/select-box.model";
import { EmptyCsiMultiSelectInputModel, getMultiSelectComponenetFromEmptyModel } from "./components/select-box-multiple/select-box-multiple.model";

// Get empty form model
export const EmptyFormModelMap = {
    text : EmptyCsiTextInputModel,
    password: EmptyCsiPasswordInputModel,
    textarea: EmptyCsiTextAreaInputModel,
    button: EmptyCsiButtonModel,
    label : EmptyCsiLabelModel,
    displayLabel: EmptyCsiDisplayLabelModel,
    buttonDropdown: EmptyCsiButtonDropdownModel,
    checkbox : EmptyCsiCheckBoxModel,
    radio : EmptyCsiRadioButtonInputModel,
    select : EmptyCsiSelectBoxInputModel,
    select_multiple : EmptyCsiMultiSelectInputModel
}

// assign 
export const AssignElementDataMap = {
    text : getTextComponenetFromEmptyModel,
    password : getPasswordComponenetFromEmptyModel,
    textarea: getTextAreaComponenetFromEmptyModel,
    button: getButtonComponenetFromEmptyModel,
    label : getLabelComponenetFromEmptyModel,
    displayLabel: getDisplayLabelComponenetFromEmptyModel,
    buttonDropdown: getButtonDropdownComponenetFromEmptyModel,
    checkbox : getCheckBoxComponenetFromEmptyModel,
    radio : getRadioButtonComponenetFromEmptyModel,
    select : getSelectBoxComponenetFromEmptyModel,
    select_multiple : getMultiSelectComponenetFromEmptyModel
}