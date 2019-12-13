import { Injectable, Inject, HttpException } from '@nestjs/common';
import { MealPlan } from '../../entities/meal-plan.entity';
import { Repository } from 'typeorm';

@Injectable()
export class MealPlanService {

    
    constructor(
        @Inject('MealPlanRepositoryToken')
        private readonly mealPlanRepository: Repository<MealPlan>,
      ) {}
    
      async getAll(): Promise<any> {
        return new Promise(resolve => {
          const mp = this.mealPlanRepository.find();
          if (!mp) throw new HttpException('No Data found', 4545);
          else resolve(mp);
        }).catch(error => {
          console.log(error);
        });
      }
      async save(mealPlan: MealPlan): Promise<any> {
        return  new  Promise(async res=>{
          var mem=await this.mealPlanRepository.save(mealPlan);
          res(mem);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });;
    
      }

      async findExist(mealPlan: MealPlan): Promise<any> {
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


          
          // const mealPlans=this.mealPlanRepository.createQueryBuilder("MealPlan")
          // .where("MealPlan.member_id_ = :id",{id:mealPlan.member_id_}).
          // getMany();

         const mealPlanRetreived= await this.mealPlanRepository.query(`select * from meals_plan_  
          WHERE meals_plan_.meal_plan_count_ = ( SELECT MAX(meal_plan_count_) FROM meals_plan_ 
          where member_id_=`+mealPlan.member_id_ +` ) AND member_id_=`+mealPlan.member_id_ +` ;`) 
        
          res(mealPlanRetreived);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }

      async GetWithMN(memID:number): Promise<any> {
        return  new  Promise(async res=>{  
        var mem=  await this.mealPlanRepository.createQueryBuilder("MealPlan")
        .leftJoinAndSelect("MealPlan.mealsNotePlanIntermediate", 'MealNotePlanIntermediate')
        .leftJoinAndSelect("MealNotePlanIntermediate.label", 'Label')
        .leftJoinAndSelect("MealNotePlanIntermediate.mealNote", 'MealNote')
        .where("MealPlan.member_id_ = :id",{id:memID})
        .addOrderBy("MealNotePlanIntermediate.meal_time_order_", "ASC")
        .getMany();
        res(mem);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }
      async gbidwd(memID:number, mpID:number): Promise<any> {
        return  new  Promise(async res=>{
        
         var mem=  await this.mealPlanRepository.createQueryBuilder("MealPlan")
        .leftJoinAndSelect("MealPlan.mealsNotePlanIntermediate", 'MealNotePlanIntermediate')
        .leftJoinAndSelect("MealNotePlanIntermediate.label", 'Label')
        .leftJoinAndSelect("MealNotePlanIntermediate.mealNote", 'MealNote')
        .where("MealPlan.member_id_ = :id AND MealPlan.meal_plan_id_ = :qmpID",{id:memID,qmpID:mpID })
        .addOrderBy("MealNotePlanIntermediate.meal_time_order_", "ASC")
        .getMany();

        res(mem);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }
      async getByMealPlanName(mpName:string): Promise<any> {
        return  new  Promise(async res=>{
        
         var mem=  await this.mealPlanRepository.createQueryBuilder("MealPlan")
        .leftJoinAndSelect("MealPlan.mealsNotePlanIntermediate", 'MealNotePlanIntermediate')
        .leftJoinAndSelect("MealNotePlanIntermediate.label", 'Label')
        .leftJoinAndSelect("MealNotePlanIntermediate.mealNote", 'MealNote')
        .where("MealPlan.meal_plan_name_ = :name ",{name:mpName })
        .addOrderBy("MealNotePlanIntermediate.meal_time_order_", "ASC")
        .getMany();

        res(mem);
        }).catch(error => {
          throw new HttpException('Server Error in Service', 4545);
          console.log(error);
        });
    
      }

      
}
