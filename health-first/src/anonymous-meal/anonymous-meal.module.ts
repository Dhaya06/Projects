import { Module } from '@nestjs/common';
import { AnonymousMealController } from './anonymous-meal.controller';

@Module({
  controllers: [AnonymousMealController]
})
export class AnonymousMealModule {}
