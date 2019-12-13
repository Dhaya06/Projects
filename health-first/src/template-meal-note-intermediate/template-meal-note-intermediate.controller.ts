import {
  Controller,
  Get,
  Res,
  HttpStatus,
  Param,
  Post,
  Body
} from "@nestjs/common";
import { TemplateMealNoteIntermediateService } from "../services/service/template-meal-note-intermediate.service";
import { TemplateMealNoteIntermediate } from "../entities/template-meal-note-intermediate.entity";
import { TemplateMealsNotePlanIntermediateVM_2 } from "../ViewModel/TemplateMealNotePlanIntermediateVM_2";
import { LabelService } from "../services/service/label.service";
import { MealNoteService } from "../services/service/meal-note.service";
import { Label } from "../entities/label.entity";
import { MealNote } from "../entities/meal-note.entity";

@Controller("api/temmealnoteintermediate")
export class TemplateMealNoteIntermediateController {
  /**
   *
   */
  constructor(
    private readonly tmnpService: TemplateMealNoteIntermediateService,
    private readonly labelService: LabelService,
    private readonly mealNoteService: MealNoteService
  ) {}
  @Get()
  async getAll(@Res() res) {
    const members = await this.tmnpService.getAll();
    res.status(HttpStatus.OK).send(members);
  }

  @Get(":id")
  async findOne(@Param("id") id, @Res() res) {
    const member = await this.tmnpService.getOne(id);
    if (this.isEmpty(member))
      res.status(HttpStatus.NOT_FOUND).json("Member Not Found");
    else res.status(HttpStatus.CREATED).json(member);
  }

  @Get("gbtid/:id")
  async findOneWithCat(@Param("id") temid, @Res() res) {
    const member = await this.tmnpService.getByTemplateID(temid);
    if (this.isEmpty(member)) res.status(444).json("Data Not Found");
    else res.status(HttpStatus.CREATED).json(member);
  }

  //get by template id by sending templates ID array
  @Post("gbtmid")
  async gbtmid(@Body() object: any, @Res() res) {
    var results: any[] = [];
    
    for (let index = 0; index < object.length; index++) {
      const element = object[index];
      let temData = await this.tmnpService.getByTemplateID(
              element
            );
            results.push(temData);
    } 
    if (this.isEmpty(results)) res.status(444).json("Data Not Found");
    else 
    res.status(HttpStatus.OK).json(results);
  }

  @Post("BulkAdd")
  async create(
    @Body() object: TemplateMealsNotePlanIntermediateVM_2,
    @Res() res
  ) {
    //  console.log(object);
    object.temMealsNotePlanIntermediateVM1.forEach(async element => {
      const updatedLabel = ((await this.labelService.checkAdd(
        element.label
      )) as unknown) as Label;
      const updatedMealNote = ((await this.mealNoteService.checkAdd(
        element.mealNote
      )) as unknown) as MealNote;
      var tmnpi = new TemplateMealNoteIntermediate();

      tmnpi.template_id_ = object.tempalte.template_id_;
      tmnpi.category_id_ = object.tempalte.category_id_;
      tmnpi.label_id_ = updatedLabel.label_id_;
      tmnpi.meal_note_id_ = updatedMealNote.meal_note_id_;
      tmnpi.meal_time_ = element.time.toString();
      tmnpi.category_id_ = object.tempalte.category_id_;
      tmnpi.bmi_id_ = object.tempalte.bmi_id_;
      tmnpi.diet_category_text_value_ =
        object.tempalte.diet_category_text_value_;
      // tmnpi.who_is_ = applicationContext.GetLoggedUser();
      tmnpi.who_is_ = "jhon";
      await this.tmnpService.save(tmnpi);
    });
    // mnpi = await this.mnpiService.save(mnpi) as MealNotePlanIntermediate;
    res.status(HttpStatus.CREATED).json(object.tempalte);
  }

  isEmpty(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }
}
