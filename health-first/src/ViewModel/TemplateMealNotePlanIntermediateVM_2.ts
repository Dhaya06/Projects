import { Injectable } from "@nestjs/common";
import { MealNotePlanIntermediate } from '../entities/meal-note-plan-intermediate.entity';
import { Label } from "../entities/label.entity";
import { MealNote } from "../entities/meal-note.entity";
import { MealPlan } from "../entities/meal-plan.entity";
import { Member } from "../entities/member.entity";
import { MealsNotePlanIntermediateVM_1 } from "./MealsNotePlanIntermediateVM_1";
import { Template } from '../entities/template.entity';
import { TemplateMealsNotePlanIntermediateVM_1 } from "./TemplateMealNotePlanIntermediateVM_1";

@Injectable()
export class TemplateMealsNotePlanIntermediateVM_2
    {
        tempalte?:Template;
        temMealsNotePlanIntermediateVM1?:TemplateMealsNotePlanIntermediateVM_1[];
    }
