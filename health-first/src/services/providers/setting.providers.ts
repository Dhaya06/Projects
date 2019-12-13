import { Connection, Repository } from 'typeorm';
import { Setting } from '../../entities/settings.entity';
export const settingProviders = [
  {
    provide: 'SettingRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Setting),
    inject: ['DbConnectionToken'],
  },
];