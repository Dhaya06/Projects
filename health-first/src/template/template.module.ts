import { Module } from '@nestjs/common';
import { TemplateController } from './template.controller';
import { TemplateService } from '../services/service/template.service';
import { templateProviders } from '../services/providers/template.providers';
import { DatabaseModule } from '../database/database.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[ServicesModule],
  controllers: [TemplateController],
  // providers: [TemplateService, ...templateProviders]
})
export class TemplateModule {}
