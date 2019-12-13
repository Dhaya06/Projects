import { Module } from "@nestjs/common";
// import {  DatabaseModule} from "da";
import { DatabaseModule } from "../database/database.module";
import { SettingService } from "./service/setting.service";
import { settingProviders } from "./providers/setting.providers";
import { TemplateService } from "./service/template.service";
import { templateProviders } from "./providers/template.providers";
import { MemberService } from "./service/member.service";
import { memberProviders } from "./providers/member.proviers";
import { MealPlanService } from "./service/meal-plan.service";
import { mealPlanProviders } from "./providers/meal-plan.providers";
import { MealNotePlanIntermediateService } from "./service/meal-note-plan-intermediate.service";
import { mealNotePlanInterProviders } from "./providers/meal-note-plan-inter.providers";
// import { ProvidersModule } from './providers/providers.module';/''
import { ViewModelModule } from '../ViewModel/view.mode.module';
import { MealNoteService } from "./service/meal-note.service";
import { mealNoteProviders } from "./providers/meal-note.providers";
import { LabelService } from "./service/label.service";
import { labelProviders } from "./providers/label.providers";
import { CategoryService } from "./service/category.service";
import { categoryProviders } from "./providers/category.providers";
import { BmiService } from "./service/bmi.service";
import { bmiProviders } from "./providers/bmi.providers";
import { TemplateMealNoteIntermediateService } from "./service/template-meal-note-intermediate.service";
import { temMealNoteIntermediateProviders } from "./providers/template-meal-note-intermediate.providers";
@Module({
  imports: [DatabaseModule,ViewModelModule],
  providers: [
    SettingService,
    ...settingProviders,
    TemplateService,
    ...templateProviders,
    MemberService,
    ...memberProviders,
    MealPlanService,
    ...mealPlanProviders,
    MealNotePlanIntermediateService,
    ...mealNotePlanInterProviders,
    MealNoteService, 
    ...mealNoteProviders,
    LabelService, 
    ...labelProviders,
    CategoryService,
    ...categoryProviders,
    BmiService, 
    ...bmiProviders,
    TemplateMealNoteIntermediateService,
    ...temMealNoteIntermediateProviders
  ],
  exports: [SettingService, 
    TemplateService, 
    MemberService, 
    MealPlanService,
    MealNotePlanIntermediateService,
    MealNoteService,
    LabelService,
    CategoryService,
    BmiService,
    TemplateMealNoteIntermediateService
  ]
})
export class ServicesModule {}
