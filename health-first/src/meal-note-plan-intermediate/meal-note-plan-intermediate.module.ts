import { Module } from '@nestjs/common';
import { MealNotePlanIntermediateController } from './meal-note-plan-intermediate.controller';
import { MealNotePlanIntermediateService } from '../services/service/meal-note-plan-intermediate.service';
import { mealNotePlanInterProviders } from '../services/providers/meal-note-plan-inter.providers';
import { DatabaseModule } from '../database/database.module';
import { ViewModelModule } from '../ViewModel/view.mode.module';
import { LabelService } from '../services/service/label.service';
import { MealNoteService } from '../services/service/meal-note.service';
import { LabelModule } from '../label/label.module';
import { MealNoteModule } from '../meal-note/meal-note.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    // DatabaseModule,
    ViewModelModule,
    ServicesModule
    //  LabelModule,
      // MealNoteModule
    ],
  controllers: [MealNotePlanIntermediateController],
  providers: [
    // MealNotePlanIntermediateService,
    // ...mealNotePlanInterProviders
  ],
    exports:[
      // MealNotePlanIntermediateService
    ]

})
export class MealNotePlanIntermediateModule {}
