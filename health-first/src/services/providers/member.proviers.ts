import { Connection, Repository } from 'typeorm';
import { Member } from '../../entities/member.entity';

export const memberProviders = [
  {
    provide: 'MemberRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Member),
    inject: ['DbConnectionToken'],
  },
];