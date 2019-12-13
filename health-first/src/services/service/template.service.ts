import { Injectable, Inject, HttpException } from '@nestjs/common';
import { Template } from '../../entities/template.entity';
import { Repository } from 'typeorm';

@Injectable()
export class TemplateService {

    constructor(
        @Inject('TemplateRepositoryToken')
        private readonly templateRepository: Repository<Template>,
      ) {}
    
      async findOne(temID: number): Promise<any> {
        return  new  Promise(async res=>{
        var mem=await this.templateRepository.createQueryBuilder("Template")
        // .leftJoinAndSelect("Template.category", 'Category')
        .where("Template.template_id_ = :id",{id:temID}).
        getOne();
        res(mem);
      }).catch(err=>{
        console.log(err);
      });
      }
      async findByName(temName: string): Promise<any> {
        return  new  Promise(async res=>{
        var mem=await this.templateRepository.createQueryBuilder("Template")
        // .leftJoinAndSelect("Template.category", 'Category')
        .where("Template.template_name_ = :name",{namer:temName}).
        getOne();
        res(mem);
      }).catch(err=>{
        console.log(err);
      });
      }
     
      async getAll(): Promise<any> {
        return new Promise(resolve => {
          const mp = this.templateRepository.find();
          if (!mp) throw new HttpException('No Data found', 4545);
          else resolve(mp);
        }).catch(error => {
          console.log(error);
        });
      }

      async save(template: Template): Promise<any> {
        return  new  Promise(async res=>{
          var mem=await this.templateRepository.save(template);
          res(mem);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }

      async checkNameExist(temName:string): Promise<any> {
        return  new  Promise(async res=>{
          // this.mealPlanRepository.find({
          // order : {
          //   meal_plan_count_:"ASC",
          //   meal_plan_id_:"ASC"
          // },
          //    where: [
          //     { member_id_: "Timber", lastName: "Saw" },
          //     { firstName: "Stan", lastName: "Lee" }
          //   ]
          // })
          var temReceived=await this.templateRepository.createQueryBuilder("Template")
          // .leftJoinAndSelect("Template.category", 'Category')
          .where("Template.template_name_ = :name",{name:temName}).
          getOne();
          res(temReceived);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }

}
