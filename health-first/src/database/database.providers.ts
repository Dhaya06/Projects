import { createConnection } from 'typeorm';
import { Category } from '../entities/category.entity';
import { Member } from '../entities/member.entity';
import { Bmi } from '../entities/bmi.entity';
import { Label } from '../entities/label.entity';
import { MealNotePlanIntermediate } from '../entities/meal-note-plan-intermediate.entity';
import { MealNote } from '../entities/meal-note.entity';
import { MealPlan } from '../entities/meal-plan.entity';
import { ConfigService } from '../assets/config/config.service';

export const databaseProviders = [
  {
    provide: 'DbConnectionToken',
    useFactory: async () => await createConnection({
      type: 'mysql',
      host: ConfigService.DATABSE_HOST,
      port: ConfigService.DATABSE_PORT,
      username: ConfigService.DATABASE_USERNAME,
      password: ConfigService.DATABASE_PASSWORD,
      database: ConfigService.DATABSE_NAME,
      entities: [__dirname + '/../**/*.entity{.ts,.js}'],
      synchronize: false,
    }),
  },
];

//Category,Member,Bmi,Label,MealNotePlanIntermediate,
//MealNote,MealPlan

//entities: ['dist/entities/*.entity{.ts,.js}'],
//  __dirname + '/../**/*.entity{.ts,.js}',

/*
'dist/entities/bmi.entity{.ts,.js}',
      'dist/entities/category.entity{.ts,.js}',
      'dist/entities/label.entity{.ts,.js}',
      'dist/entities/meal-note-plan-intermediate.entity{.ts,.js}',
      'dist/entities/meal-note.entity{.ts,.js}',
      'dist/entities/meal-plan.entity{.ts,.js}',
      'dist/entities/member.entity{.ts,.js}'
*/