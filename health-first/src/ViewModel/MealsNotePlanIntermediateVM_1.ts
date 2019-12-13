import { Injectable } from "@nestjs/common";
import { MealNotePlanIntermediate } from '../entities/meal-note-plan-intermediate.entity';
import { Label } from "../entities/label.entity";
import { MealNote } from "../entities/meal-note.entity";
import { MealPlan } from "../entities/meal-plan.entity";

@Injectable()
export class   MealsNotePlanIntermediateVM_1
    {

        mealsNotePlanIntermediate?: MealNotePlanIntermediate;
         label?: Label;
          mealNote?:MealNote;
         id?:number;
         time?:Date;
         mealPlan?:MealPlan;
    }
