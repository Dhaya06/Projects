import { Connection, Repository } from 'typeorm';
import { MealNotePlanIntermediate } from '../../entities/meal-note-plan-intermediate.entity';
export const mealNotePlanInterProviders = [
  {
    provide: 'MealNotePlanIntermediateRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(MealNotePlanIntermediate),
    inject: ['DbConnectionToken'],
  },
];