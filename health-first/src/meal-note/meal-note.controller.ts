import { Controller, HttpStatus, Get, Res, Post, Body } from "@nestjs/common";
import { MealNoteService } from "../services/service/meal-note.service";
import { Setting } from "../entities/settings.entity";
import { Member } from '../entities/member.entity';
import { SettingService } from "../services/service/setting.service";
import { MemberService } from '../services/service/member.service';
import { MealNotePlanIntermediate } from '../entities/meal-note-plan-intermediate.entity';
import { MealNotePlanIntermediateService } from "../services/service/meal-note-plan-intermediate.service";

@Controller("api/mealsnote")
export class MealNoteController {
  constructor(private readonly mealNoteService: MealNoteService,
    private readonly settinService:SettingService,
    private readonly memService:MemberService,
    private readonly mnpiService:MealNotePlanIntermediateService
    ) {}

  @Get()
  async getAll(@Res() res) {
    const category = await this.mealNoteService.getAll();
    res.status(HttpStatus.OK).send(category);
  }

  @Post("gbf")
  async getByFilters(@Res() res, @Body() mem:Member ) {
    var setting=await this.settinService.getByID(1);
    //  var result=await this.mealNoteService.getByFillters(member,setting);
    
    var intermediates=await this.mnpiService
    .getByFilterForMN(setting,mem) as MealNotePlanIntermediate[];

    const mp=await this.mealNoteService.rangeSelectByID(intermediates);
      
    res.status(HttpStatus.OK).send(mp);
  }
  
  @Get("test2")
  async test2(@Res() res ) {
    
    var setting=await this.settinService.getByID(1);
    var member=await this.memService.findOne(5);
    //  var result=await this.mealNoteService.getByFillters(member,setting);
    
    var intermediates=await this.mnpiService
    .getByFilterForMN(setting,member) as MealNotePlanIntermediate[];
    const mp=await this.mealNoteService.rangeSelectByID(intermediates);
    res.status(HttpStatus.OK).send(mp);
    // res.status(HttpStatus.OK).send(intermediates);
  

  }
}
