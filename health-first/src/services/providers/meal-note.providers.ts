import { Connection, Repository } from 'typeorm';
import { MealNote } from '../../entities/meal-note.entity';
export const mealNoteProviders = [
  {
    provide: 'MealNoteRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(MealNote),
    inject: ['DbConnectionToken'],
  },
];