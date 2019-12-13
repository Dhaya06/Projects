import { Injectable, Inject, HttpException } from '@nestjs/common';
import { MealNotePlanIntermediate } from '../../entities/meal-note-plan-intermediate.entity';
import { Repository } from 'typeorm';
import { Setting } from '../../entities/settings.entity';
import { Member } from '../../entities/member.entity';

@Injectable()
export class MealNotePlanIntermediateService {
  constructor(
    @Inject('MealNotePlanIntermediateRepositoryToken')
    private readonly mnpiRepository: Repository<MealNotePlanIntermediate>,
  ) {}

  async getAll(): Promise<any> {
    return new Promise(async resolve => {
      const label = await this.mnpiRepository
        .createQueryBuilder('MealNotePlanIntermediate')
        .leftJoinAndSelect('MealNotePlanIntermediate.label', 'Label')
        .leftJoinAndSelect('MealNotePlanIntermediate.mealNote', 'MealNote')
        //    .where("Member.member_id_ = :id",{id:memID}).
        .addOrderBy("MealNotePlanIntermediate.meal_time_order_", "ASC")
        .getMany();
      if (!label) throw new HttpException('Label data note found', 404);
      else resolve(label);
    }).catch(error => {
      console.log(error);
    });
  }

  async getOne(mnpiID: number): Promise<any> {
    return new Promise(async resolve => {
      const label = await this.mnpiRepository.findOne({
        meal_note_plan_intermediate_id_: mnpiID,
      });
      if (!label) throw new HttpException('Data note found', 404);
      else resolve(label);
    }).catch(error => {
      console.log(error);
    });
  }

  async getByMealPlanID(mpID: number): Promise<any> {
    return new Promise(async resolve => {
      const mnpi = await this.mnpiRepository
        .createQueryBuilder('MealNotePlanIntermediate')
        .leftJoinAndSelect('MealNotePlanIntermediate.label', 'Label')
        .leftJoinAndSelect('MealNotePlanIntermediate.mealNote', 'MealNote')
        .where('MealNotePlanIntermediate.meal_plan_id_ = :id', { id: mpID })
        .addOrderBy("MealNotePlanIntermediate.meal_time_order_", "ASC")
        //   .andWhere('"footprintId" = :footprintId', { footprintId: input.footprintId })
        .getMany();
      if (!mnpi) throw new HttpException('Data note found', 404);
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

  async save(mealNotePlanIntermediate: MealNotePlanIntermediate): Promise<any> {
    var time = mealNotePlanIntermediate.meal_time_;
    var result = this.digitalize(mealNotePlanIntermediate.meal_time_);
    mealNotePlanIntermediate.meal_time_order_=result;
    return new Promise(async res => {
      var mem = await this.mnpiRepository.save(mealNotePlanIntermediate);
      res(mem);
    }).catch(error => {
      console.log(error);
    });
  }

  async getByFilterForMN(setting:Setting, member: Member): Promise<any> {
    return new Promise(async resolve => {
       let query= await this.mnpiRepository
        .createQueryBuilder('MealNotePlanIntermediate')
        // .select(`DISTINCT ON (meal_note_plan_intermediate_.meal_plan_id_) 
        // meal_note_plan_intermediate_.meal_plan_id_ as meal_plan_id_`);
        .select('DISTINCT meal_note_id_', 'meal_note_id_')
        if(setting.searc_by_diet_cat_==1) 
        query.where('category_id_ = :cid', { cid: member.category_id_ });
        if(setting.search_by_bmi_==1) 
        query.where('bmi_id_ = :bid', { bid: member.bmi_id_ });
        // if(setting.search_by_label_==1) 
        // query.where('MealNotePlanIntermediate.label_id_ = :bid', { bid: labelID});
        query.addOrderBy("meal_note_id_", "DESC")
        //   .andWhere('"footprintId" = :footprintId', { footprintId: input.footprintId })
        const mnpi=await query.getRawMany();
   
        if (!mnpi) throw new HttpException('Data note found', 444);
      else resolve(mnpi);
    }).catch(error => {
      console.log(error);
    });
  }

  async getByFilterForMN2(setting:Setting, member: Member): Promise<any> {
    return new Promise(async resolve => {
       let query= await this.mnpiRepository
        .createQueryBuilder('MealNotePlanIntermediate')
        // .select(`DISTINCT ON (meal_note_plan_intermediate_.meal_plan_id_) 
        // meal_note_plan_intermediate_.meal_plan_id_ as meal_plan_id_`);
        
        .select('DISTINCT meal_note_id_', 'meal_note_id_')
        
        if(setting.searc_by_diet_cat_==1) 
        query.where('meal_note_plan_intermediate_.category_id_ = :cid', { cid: member.category_id_ });
        if(setting.search_by_bmi_==1) 
        query.where('meal_note_plan_intermediate_.bmi_id_ = :bid', { bid: member.bmi_id_ });
        // if(setting.search_by_label_==1) 
        // query.where('MealNotePlanIntermediate.label_id_ = :bid', { bid: labelID});
        query.addOrderBy("meal_note_plan_intermediate_.meal_time_order_", "ASC")
        //   .andWhere('"footprintId" = :footprintId', { footprintId: input.footprintId })
        const mnpi=await query.getRawMany();
        console.log(mnpi);
        if (!mnpi) throw new HttpException('Data note found', 444);
      else resolve(mnpi);
    }).catch(error => {
      console.log(error);
    });
  }



  async Query()
  {
    const applications = await this.mnpiRepository.createQueryBuilder("applications")
    .select('DISTINCT applications.id', 'id')
    .addSelect('applications.loan_number', 'loanNumber')
    .addSelect('applicant.id', 'applicantId')
    .addSelect('ass.status', 'signature_status')
    .leftJoin('applications.applicationApplicants', 'applicant')
    .leftJoin('applications.applicationSignatureStatus', 'ass')
    .where("applications.deleted_at = null")
    .orderBy("applications.id", "DESC")
    .limit(4)
    .getRawMany();
  }
}
