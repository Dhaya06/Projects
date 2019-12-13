import { Connection, Repository } from 'typeorm';
import { Bmi } from '../../entities/bmi.entity';

export const bmiProviders = [
  {
    provide: 'BmiRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Bmi),
    inject: ['DbConnectionToken'],
  },
];