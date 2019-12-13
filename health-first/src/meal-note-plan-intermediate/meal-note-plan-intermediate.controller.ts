import {
  Controller,
  Get,
  Res,
  HttpStatus,
  Param,
  Post,
  Body,
} from '@nestjs/common';
import { MealNotePlanIntermediateService } from '../services/service/meal-note-plan-intermediate.service';
import { MealNotePlanIntermediate } from '../entities/meal-note-plan-intermediate.entity';
import { MealsNotePlanIntermediateVM_2 } from '../ViewModel/MealsNotePlanIntermediateVM_2';
import { LabelService } from '../services/service/label.service';
import { MealNoteService } from '../services/service/meal-note.service';
import { Label } from '../entities/label.entity';
import { MealNote } from '../entities/meal-note.entity';

@Controller('api/MealsNotePlanIntermediate')
export class MealNotePlanIntermediateController {
  constructor(
    private readonly mnpiService: MealNotePlanIntermediateService,
    private readonly labelService: LabelService,
    private readonly mealNoteService: MealNoteService,
  ) {}

  @Get()
  async getAll(@Res() res) {
    const mnpi = await this.mnpiService.getAll();
    res.status(HttpStatus.OK).send(mnpi);
  }
  @Get('gbmpid/:mpID')
  async getByMPId(@Res() res, @Param('mpID') mpID) {
    const mnpi = await this.mnpiService.getByMealPlanID(mpID);
    res.status(HttpStatus.OK).send(mnpi);
  }

  @Post()
  async create(@Body() mnpi: MealNotePlanIntermediate, @Res() res) {
    mnpi = (await this.mnpiService.save(mnpi)) as MealNotePlanIntermediate;
    res.status(HttpStatus.CREATED).json(mnpi);
  }

  @Post('BulkAdd')
  async BulkAdd(@Body() object: MealsNotePlanIntermediateVM_2, @Res() res) {
    object.mealsNotePlanIntermediate.forEach(async element => {
      const updatedLabel =await this.labelService.checkAdd(element.label) as unknown as Label;
      const updatedMealNote =await this.mealNoteService.checkAdd(element.mealNote) as unknown as MealNote;
      var mealNotePlanIntermediate = new MealNotePlanIntermediate();

      mealNotePlanIntermediate.meal_plan_id_ = object.mealPlan.meal_plan_id_;
      mealNotePlanIntermediate.category_id_ = object.mealPlan.category_id_;
      mealNotePlanIntermediate.label_id_ = updatedLabel.label_id_;
      mealNotePlanIntermediate.meal_note_id_ = updatedMealNote.meal_note_id_;
      mealNotePlanIntermediate.meal_time_ = element.time.toString();
      mealNotePlanIntermediate.member_bmi_value_ = object.member.bmi_;
      mealNotePlanIntermediate.bmi_id_ = object.member.bmi_id_;
      // mealNotePlanIntermediate.who_is_ = applicationContext.GetLoggedUser();
      mealNotePlanIntermediate.who_is_ = "jhon";
     await this.mnpiService.save(mealNotePlanIntermediate);
    });
    // mnpi = await this.mnpiService.save(mnpi) as MealNotePlanIntermediate;
    res.status(HttpStatus.CREATED).json(object.mealPlan);
  }


  isEmpty(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }
}
