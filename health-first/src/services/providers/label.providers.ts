import { Connection, Repository } from 'typeorm';
import { Label } from '../../entities/label.entity';
export const labelProviders = [
  {
    provide: 'LabelRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Label),
    inject: ['DbConnectionToken'],
  },
];