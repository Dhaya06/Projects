import { Module } from '@nestjs/common';
import { SettingController } from './setting.controller';
// import { SettingService } from '../services/setting.service';
// import { settingProviders } from '../services/providers/setting.providers';
import { DatabaseModule } from '../database/database.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[
    // DatabaseModule
    ServicesModule
  ],
  controllers: [SettingController],
  // providers: [SettingService, ...settingProviders],
  exports:[]
})
export class SettingModule {}
