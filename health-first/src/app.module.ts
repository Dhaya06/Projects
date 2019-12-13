import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { MemberModule } from './member/member.module';
// import { TypeOrmModule } from '@nestjs/typeorm';
import { Connection } from 'typeorm';
// import { DatabaseModule } from './database/database.module';
import { CategoryModule } from './category/category.module';
import { LabelModule } from './label/label.module';
import { MealNoteModule } from './meal-note/meal-note.module';
import { MealPlanModule } from './meal-plan/meal-plan.module';
import { MealNotePlanIntermediateModule } from './meal-note-plan-intermediate/meal-note-plan-intermediate.module';
import { BmiModule } from './bmi/bmi.module';
import { TemplateModule } from './template/template.module';
import { TemplateMealNoteIntermediateModule } from './template-meal-note-intermediate/template-meal-note-intermediate.module';
import { SettingModule } from './setting/setting.module';
import { ServicesModule } from './services/services.module';
import { AnonymousMealModule } from './anonymous-meal/anonymous-meal.module';


  // {
  //     type: 'mysql',
  //     host: 'localhost',
  //     port: 3306,
  //     username: 'root',
  //     password: '',
  //     database: 'test',
  //     entities: [__dirname + '/**/*.entity{.ts,.js}'],
  //     synchronize: true,
  //   }
//   TypeOrmModule.forRoot(),
@Module({
  imports: [
    MemberModule,
    CategoryModule,
    LabelModule,
    MealNoteModule,
    MealPlanModule,
    MealNotePlanIntermediateModule,
    BmiModule,
    TemplateModule,
    TemplateMealNoteIntermediateModule,
    SettingModule,
    ServicesModule,
    AnonymousMealModule
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {

  constructor() {
  }
}
