import { Connection, Repository } from 'typeorm';
import { MealPlan } from '../../entities/meal-plan.entity';
export const mealPlanProviders = [
  {
    provide: 'MealPlanRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(MealPlan),
    inject: ['DbConnectionToken'],
  },
];