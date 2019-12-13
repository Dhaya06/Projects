import { Module } from '@nestjs/common';
import { MealNoteController } from './meal-note.controller';
import { MealNoteService } from '../services/service/meal-note.service';
import { DatabaseModule } from '../database/database.module';
import { mealNoteProviders } from '../services/providers/meal-note.providers';
import { SettingModule } from '../setting/setting.module';
import { MealNotePlanIntermediateService } from '../services/service/meal-note-plan-intermediate.service';
import { SettingService } from '../services/service/setting.service';
import { MemberService } from '../services/service/member.service';
import { MealNotePlanIntermediateModule } from '../meal-note-plan-intermediate/meal-note-plan-intermediate.module';
import { MemberModule } from '../member/member.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    // DatabaseModule
    ServicesModule
   ],
  controllers: [MealNoteController],
  providers: [
    // MealNoteService, ...mealNoteProviders, 
    // MealNotePlanIntermediateService,
    // MemberService
  ],
  exports:[
    // MealNoteService
  ]
})
export class MealNoteModule {}
