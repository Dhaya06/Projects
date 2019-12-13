import { Module } from '@nestjs/common';
import { MealPlanController } from './meal-plan.controller';
import { MealPlanService } from '../services/service/meal-plan.service';
import { DatabaseModule } from '../database/database.module';
import { mealPlanProviders } from '../services/providers/meal-plan.providers';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    // DatabaseModule
    ServicesModule
  ],
  controllers: [MealPlanController],
  providers: [
    // MealPlanService, ...mealPlanProviders
  ]
})
export class MealPlanModule {}
