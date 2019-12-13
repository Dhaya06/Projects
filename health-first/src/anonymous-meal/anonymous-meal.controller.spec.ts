import { Test, TestingModule } from '@nestjs/testing';
import { AnonymousMealController } from './anonymous-meal.controller';

describe('AnonymousMeal Controller', () => {
  let module: TestingModule;
  
  beforeAll(async () => {
    module = await Test.createTestingModule({
      controllers: [AnonymousMealController],
    }).compile();
  });
  it('should be defined', () => {
    const controller: AnonymousMealController = module.get<AnonymousMealController>(AnonymousMealController);
    expect(controller).toBeDefined();
  });
});
