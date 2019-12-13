import { Validators } from "@angular/forms";

// Define validation mapper
const ValidatorMapper = {
    'required' : Validators.required,
    'minlength' : Validators.minLength,
    'maxlength' : Validators.maxLength
}

// Switch validator
const switchValidatorMethod = function(rule){
    let rule_key = rule["rule"];
    if(rule_key === 'required'){
        return ValidatorMapper[rule_key];
    }
    if(rule_key === 'minlength'){
        return ValidatorMapper[rule_key](rule["length"]);
    }
    if(rule_key === 'maxlength'){
        return ValidatorMapper[rule_key](rule["length"]);
    }
} 

// Get Validators
export const GetValidators = function(rules: any[] = []){
    let ru = [];
    rules.forEach(rule => {
        ru.push(switchValidatorMethod(rule));
    });
    return ru;
}