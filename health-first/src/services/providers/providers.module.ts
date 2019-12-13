import { Module } from '@nestjs/common';
import { settingProviders } from './setting.providers';

@Module({

  providers: [ ...settingProviders],
  // exports:[...settingProviders]
})
export class ProvidersModule {}
