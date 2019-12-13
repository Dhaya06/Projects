import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'ConvertToYesNo' })
export class ConvertToYesNo implements PipeTransform {
    transform(value: boolean): string {
        return value == true ? 'Yes' : 'No'
    }; 
}