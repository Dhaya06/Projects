import { Injectable, Inject, HttpException } from '@nestjs/common';
import { Repository } from 'typeorm';
import { TemplateMealNoteIntermediate } from '../../entities/template-meal-note-intermediate.entity';

@Injectable()
export class TemplateMealNoteIntermediateService {
    constructor(
        @Inject('TemMealNoteIntermediateRepositoryToken')
        private readonly tmniRepository: Repository<TemplateMealNoteIntermediate>,
      ) {}

    async getAll(): Promise<any> {
        return new Promise(async resolve => {
          const label = await this.tmniRepository
            .createQueryBuilder('TemplateMealNoteIntermediate')
            .leftJoinAndSelect('TemplateMealNoteIntermediate.label', 'Label')
            .leftJoinAndSelect('TemplateMealNoteIntermediate.mealNote', 'MealNote')
            //    .where("Member.member_id_ = :id",{id:memID}).
            .addOrderBy("TemplateMealNoteIntermediate.meal_time_order_", "ASC")
            .getMany();
          if (!label) throw new HttpException('Template Intermediate Date not found', 444);
          else resolve(label);
        }).catch(error => {
          console.log(error);
        });
      }
    
      async getOne(tmnpiID: number): Promise<any> {
        return new Promise(async resolve => {
          const label = await this.tmniRepository.findOne({
            template_meal_note_intermediate_id_: tmnpiID
          });
          if (!label) throw new HttpException('Data note found', 444);
          else resolve(label);
        }).catch(error => {
          console.log(error);
        });
      }
    
      async getByTemplateID(templateID: number): Promise<any> {
        return new Promise(async resolve => {
          const mnpi = await this.tmniRepository
            .createQueryBuilder('TemplateMealNoteIntermediate')
            .leftJoinAndSelect('TemplateMealNoteIntermediate.label', 'Label')
            .leftJoinAndSelect('TemplateMealNoteIntermediate.mealNote', 'MealNote')
            .where('TemplateMealNoteIntermediate.template_id_ = :id', { id: templateID })
            .addOrderBy("TemplateMealNoteIntermediate.meal_time_order_", "ASC")
            //   .andWhere('"footprintId" = :footprintId', { footprintId: input.footprintId })
            .getMany();
          if (!mnpi) throw new HttpException('Data note found', 444);
          else resolve(mnpi);
        }).catch(error => {
          console.log(error);
        });
      }
    
      digitalize(time: any) {
        var first = time.split(':');
        var second = first[1].split(' ');
    
        var hour = first[0];
        var minutes = second[0];
        var ampm = second[1];
    
        if (ampm == 'pm') {
          if (Number(hour) == 12) hour = hour;
          else hour = Number(hour) + 12;
        } else {
          if (Number(hour) == 12) hour = '00';
          else hour = hour;
        }
    
        var newTime = hour + ':' + minutes + ':' + '00';
        return newTime;
      }
    
      async save(tmni: TemplateMealNoteIntermediate): Promise<any> {
        var time = tmni.meal_time_;
        var result = this.digitalize(tmni.meal_time_);
        tmni.meal_time_order_=result;
        return new Promise(async res => {
          var mem = await this.tmniRepository.save(tmni);
          res(mem);
        }).catch(error => {
          console.log(error);
        });
      }


}
