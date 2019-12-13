import { Module } from '@nestjs/common';
import { TemplateMealNoteIntermediateController } from './template-meal-note-intermediate.controller';
import { TemplateMealNoteIntermediateService } from '../services/service/template-meal-note-intermediate.service';
import { temMealNoteIntermediateProviders } from '../services/providers/template-meal-note-intermediate.providers';
import { DatabaseModule } from '../database/database.module';
import { ViewModelModule } from '../ViewModel/view.mode.module';
import { LabelModule } from '../label/label.module';
import { MealNoteModule } from '../meal-note/meal-note.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    ServicesModule
    // DatabaseModule,
    // ViewModelModule,
    // LabelModule,
    //  MealNoteModule
    ],
  controllers: [TemplateMealNoteIntermediateController],
  providers: [
    // TemplateMealNoteIntermediateService, ...temMealNoteIntermediateProviders
  ]
})
export class TemplateMealNoteIntermediateModule {}
