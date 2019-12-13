import { Connection, Repository } from 'typeorm';
import {Template } from '../../entities/template.entity';

export const templateProviders = [
  {
    provide: 'TemplateRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(Template),
    inject: ['DbConnectionToken'],
  },
];