import { Module } from '@nestjs/common';
import { BmiController } from './bmi.controller';
import { BmiService } from '../services/service/bmi.service';
import { bmiProviders } from '../services/providers/bmi.providers';
import { DatabaseModule } from '../database/database.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[ServicesModule],
  controllers: [BmiController],
  providers: [
    // BmiService, ...bmiProviders
  ],
  exports:[
    // BmiService
  ]
})
export class BmiModule {}
