import { Injectable } from '@angular/core';
import { CsiHttpService } from '../../../../csi-web-base/csi-http-handler/csi-http.service';
import { API_URL } from '../../_shared/API_URLS.const';

@Injectable()
export class CreateTaskService {

  constructor(private csiHttpService: CsiHttpService) { }

  SaveOrUpdateWorkList(data:any){
    if(data.id == null){
      return this.csiHttpService.post(API_URL.TASK_MANAGER.ROOT,data);
    }

    return this.csiHttpService.put(API_URL.TASK_MANAGER.ROOT,data);
  }

  GetWorkListbyId(id:number):any{
    return this.csiHttpService.getSingleObject(API_URL.TASK_MANAGER.ROOT,id);
  }

  GetWorkListbyName(name:string):any{
    return this.csiHttpService.getByText(API_URL.TASK_MANAGER.ROOT+"name",name);
  }


  GetFilterTypes():any{
    return [
      {name: "Facility", type: "select",id:1,
        values:[{filterId:1,name:"Suwaidi Hospital"},{filterId:2,name:"Dubai Hospital"}]},
      {name: "Insurance Group", type: "select",id:2,
        values:[{filterId:1,name:"Tawuniya"},{filterId:2,name:"BUPA"},{filterId:3,name:"Medgulf"}]},
      {name: "Company Name / ID", type: "select",id:3,
        values:[{filterId:1,name:"بوبا البنك البريطاني "},
        {filterId:2,name:"مجموعة الدكتور سليمان الحبيب الطبي - القصيم "},
        {filterId:3,name:"Medgulf"}]},
      {name: "Policy Type", type: "select",id:4,
        values:[{filterId:1,name:"Tawuniya"},{filterId:2,name:"BUPA"},{filterId:3,name:"Medgulf"}]},
      {name: "Date Range", type: "daterange",id:5,
        values:[{filterId:1,name:"Tawuniya"},{filterId:2,name:"BUPA"},{filterId:3,name:"Medgulf"}]},
      {name: "Encounter Type", type: "select",id:6,
        values:[{filterId:1,name:"Tawuniya"},{filterId:2,name:"BUPA"},{filterId:3,name:"Medgulf"}]},
      {name: "Department / Clinic", type: "select",id:7,
        values:[{filterId:1,name:"Tawuniya"},{filterId:2,name:"BUPA"},{filterId:3,name:"Medgulf"}]},
      {name: "Doctor", type: "select",id:8,
        values:[{filterId:1,name:"HAITHAM MOHAMMED MESSELHI"},
        {filterId:2,name:"JAMAL NAWAF ATTAWNEH"},
        {filterId:3,name:"DR. MUHANNAD GABIR"},
        {filterId:4,name:"GULZAR CHAGLA"},
        {filterId:5,name:"توفيق حمزة جعفر"}]}
      ];
  }

}
