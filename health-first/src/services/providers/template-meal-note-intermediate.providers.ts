import { Connection, Repository } from 'typeorm';
import { Member } from '../../entities/member.entity';
import { TemplateMealNoteIntermediate } from '../../entities/template-meal-note-intermediate.entity';

export const temMealNoteIntermediateProviders = [
  {
    provide: 'TemMealNoteIntermediateRepositoryToken',
    useFactory: (connection: Connection) => connection.getRepository(TemplateMealNoteIntermediate),
    inject: ['DbConnectionToken'],
  },
];