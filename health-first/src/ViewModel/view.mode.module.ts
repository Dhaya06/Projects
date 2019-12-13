import { Module } from '@nestjs/common';
import { MealsNotePlanIntermediateVM_2 } from './MealsNotePlanIntermediateVM_2';
import { MealsNotePlanIntermediateVM_1 } from './MealsNotePlanIntermediateVM_1';
import { TemplateMealsNotePlanIntermediateVM_2 } from './TemplateMealNotePlanIntermediateVM_2';
import { TemplateMealsNotePlanIntermediateVM_1 } from './TemplateMealNotePlanIntermediateVM_1';


// TypeOrmModule.forFeature([Member])
@Module({
  providers: [MealsNotePlanIntermediateVM_2,
    MealsNotePlanIntermediateVM_1,
    TemplateMealsNotePlanIntermediateVM_1,
    TemplateMealsNotePlanIntermediateVM_2],
  exports:[MealsNotePlanIntermediateVM_2,
    MealsNotePlanIntermediateVM_1,
    TemplateMealsNotePlanIntermediateVM_1,
    TemplateMealsNotePlanIntermediateVM_2]
})
export class ViewModelModule {}
