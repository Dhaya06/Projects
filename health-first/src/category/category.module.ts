import { Module } from '@nestjs/common';
import { CategoryController } from './category.controller';
import { CategoryService } from '../services/service/category.service';
import { categoryProviders } from '../services/providers/category.providers';
// import { DatabaseModule } from '../database/database.module';
import { ServicesModule } from '../services/services.module';

@Module({
  imports:[ServicesModule],
  controllers: [CategoryController],
  providers: [
    // CategoryService,...categoryProviders
  ],
  exports:[
    // CategoryService
  ]
})
export class CategoryModule {}
