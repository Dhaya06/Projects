import { Module } from '@nestjs/common';
import { MemberController } from './member.controller';
import { MemberService } from '../services/service/member.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Member } from '../entities/member.entity';
import { memberProviders } from '../services/providers/member.proviers';
import { DatabaseModule } from '../database/database.module';
import { CategoryModule } from '../category/category.module';
import { BmiModule } from '../bmi/bmi.module';
import { ServicesModule } from '../services/services.module';

// TypeOrmModule.forFeature([Member])
@Module({
  imports:[
    // DatabaseModule, CategoryModule, BmiModule
    ServicesModule
  ],
  controllers: [MemberController],
  // providers: [MemberService,...memberProviders],
  exports:[
    // MemberService
  ]
})
export class MemberModule {}
