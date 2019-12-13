import { Pipe,PipeTransform } from '@angular/core'

@Pipe({
    name: 'convertToDays'
})
export class ConvertToDays implements PipeTransform{
    transform(value: number): string{
        return value+' days';
    }

}