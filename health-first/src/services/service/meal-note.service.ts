import { Injectable, Inject, HttpException } from '@nestjs/common';
import { Repository } from 'typeorm';
import { MealNote } from '../../entities/meal-note.entity';
import { Setting } from '../../entities/settings.entity';
import { Member } from '../../entities/member.entity';
import { MealNotePlanIntermediateService } from './meal-note-plan-intermediate.service';
import { MealNotePlanIntermediate } from '../../entities/meal-note-plan-intermediate.entity';
import { MemberService } from './member.service';

@Injectable()
export class MealNoteService {
  constructor(
    @Inject('MealNoteRepositoryToken')
    private readonly mealNoteRepository: Repository<MealNote>,
    // private readonly mnpiService:MealNotePlanIntermediateService
  ) {}

  async getAll(): Promise<any> {
    return new Promise(resolve => {
      const mp = this.mealNoteRepository.find();
      if (!mp) throw new HttpException('No Data found', 502);
      else resolve(mp);
    }).catch(error => {
      console.log(error);
    });
  }
  async rangeSelectByID(mnIDs:any[]): Promise<any> {
    return new Promise( async resolve => {
      
      let query = await this.mealNoteRepository.createQueryBuilder('MealNote');
      query.select(`meal_note_id_ as 'meal_note_id_',
      m_note as 'm_note'`);
      query.addSelect(`who_is_ as 'who_is_'`);
      query.addSelect(`time_stamp_ as 'time_stamp_'`);
      query.andWhereInIds(mnIDs);
  
      // for (let index = 0; index < mnIDs.length; index++) {
      //   const element = mnIDs[index];
      //   console.log(element);
      //   if(index==0)
      //   query.where("meal_note_id_ = :id", {id:element.meal_note_id_});
      //   else
      //   query.orWhere("meal_note_id_ = :id", {id:element.meal_note_id_});
      // }
      const mp=await query.getRawMany() as MealNote[];
      
      if (!mp) throw new HttpException('No Data found', 502);
      else resolve(mp);
    }).catch(error => {
      console.log(error);
    });
  }
  async getByFilltersDefinition(settings:Setting): Promise<any> {
    return new Promise(resolve => {
     let query = this.mealNoteRepository.createQueryBuilder('MealNote');
      if(settings.searc_by_diet_cat_==1) 
      query.where(`MealNote.m_note LIKE :q`, {q:"some Text"});
      if(1!=1)
      query.andWhere(`some more where clause here`);
      const mp =query.getMany();
      if (!mp) throw new HttpException('No Data found', 502);
      else resolve(mp);
    }).catch(error => {
      console.log(error);
    });
  }
  // async getByFillters(member:Member,settings:Setting): Promise<any> {
  //   var intermediates=await this.mnpiService.getByFilterForMN(settings,member) as MealNotePlanIntermediate[];
  //   // for (let index = 0; index < intermediates.length; index++) {
  //   //   const element = intermediates[index];
  //   //   console.log(element);
         
  //   // }
  //   return new Promise(resolve => {
  //     resolve(intermediates);
  //   }).catch(error => {
  //     console.log(error);
  //   });
  // }



  async checkAdd(mealNote: MealNote): Promise<any> {
    return new Promise(async resolve => {
      var mealNoteRetrieved:MealNote;
      mealNoteRetrieved= await this.mealNoteRepository
        .createQueryBuilder('MealNote')
        .where('MealNote.m_note = :name', { name: mealNote.m_note })
        .getOne();
      if(mealNoteRetrieved==null)
      {
       const newMealNote= this.mealNoteRepository.save(mealNote);
       resolve(newMealNote);
      }
      else
      resolve(mealNoteRetrieved);
    }).catch(error => {
      throw new HttpException('System Error', 404);
      console.log(error);
    });
  }
}
