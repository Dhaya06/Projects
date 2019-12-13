import { Connection, Repository } from 'typeorm';
import { Category } from '../../entities/category.entity';

export const categoryProviders = [
  {
    provide: 'CategoryRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Category),
    inject: ['DbConnectionToken'],
  },
];