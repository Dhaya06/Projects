import { Module } from '@nestjs/common';
import { LabelController } from './label.controller';
import { LabelService } from '../services/service/label.service';
import { labelProviders } from '../services/providers/label.providers';
import { DatabaseModule } from '../database/database.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    // DatabaseModule
    ServicesModule
  ],
  controllers: [LabelController],
  providers: [
    // LabelService, ...labelProviders
  ],
  exports:[
    // LabelService
  ]
})
export class LabelModule {}
