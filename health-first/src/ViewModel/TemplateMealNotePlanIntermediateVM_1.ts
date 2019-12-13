import { Injectable } from "@nestjs/common";
import { Label } from "../entities/label.entity";
import { MealNote } from "../entities/meal-note.entity";
import { MealPlan } from "../entities/meal-plan.entity";
import { TemplateMealNoteIntermediate } from '../entities/template-meal-note-intermediate.entity';
import { Template } from '../entities/template.entity';

@Injectable()
export class  TemplateMealsNotePlanIntermediateVM_1
    {

        temMealsNotePlanIntermediate?: TemplateMealNoteIntermediate;
         label?: Label;
          mealNote?:MealNote;
         id?:number;
         time?:Date;
         template?:Template;
    }