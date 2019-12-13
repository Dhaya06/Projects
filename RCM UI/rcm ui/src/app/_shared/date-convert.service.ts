import { Injectable } from '@angular/core';

@Injectable()
export class DateConvertService {

  constructor() { }

  convertDateToString(date:Date,separator:string){

    let year = date.getFullYear();
    let month:any = date.getMonth() + 1;
    let day:any = date.getDate();
      if(month < 10){
        month ='0'+month;
    } 
    if(day<10){
      day='0'+day;
    } 

    return year + separator + month + separator + day;
  }

  convertStringToDate(date:string){
    return new Date(date);
  }


}
