import { Controller } from '@nestjs/common';

@Controller('anonymous-meal')
export class AnonymousMealController {
//      constructor(private readonly mealPlanService: MealPlanService) {}

//   @Get()
//   async getAll(@Res() res) {
//     const mealPlan = await this.mealPlanService.getAll();
//     if (this.isEmpty(mealPlan)) {
//       res.status(HttpStatus.OK).send('No Data Found');
//     } else res.status(HttpStatus.OK).send(mealPlan);
//   }
//   @Get('test/:id')
//   async test(@Res() res, @Param('id') id) {
//     var mealPlan = new MealPlan();
//     mealPlan.member_id_ = id;
//     var checkExist = ((await this.mealPlanService.findExist(
//       mealPlan,
//     )) as unknown) as MealPlan;

//     if (this.isEmpty( checkExist)) res.status(HttpStatus.OK).send('No Found');
//     else res.status(HttpStatus.OK).send(checkExist);
//   }
//   @Get('test2/:time')
//   async test2(@Res() res, @Param('time') time) {
   
//     var first=time.split(":");
//     var second=first[1].split(" ");

//     var hour=first[0];
//     var minutes=second[0];
//     var ampm=second[1];

//     if(ampm=="pm")
//     {
//       if(Number(hour)==12)
//       hour=hour;
//       else
//       hour=Number(hour)+12;
//     }
//     else
//     {
//       if(Number(hour)==12)
//       hour="00";
//       else
//       hour=hour;
//     }


//     var newTime=hour+":"+minutes+":"+"00";


//      res.status(HttpStatus.OK).send(newTime);
//   }

  
//   @Get('GetWithMN/:memID')
//   async GetWithMN(@Res() res, @Param('memID') memID) {
   
//     const mealPlan = await this.mealPlanService.GetWithMN(memID);
//     if (this.isEmpty(mealPlan)) {
//       res.status(HttpStatus.OK).send('No Data Found');
//     } else res.status(HttpStatus.OK).send(mealPlan);
   
//   }

//   //get by member id
//   @Get('gbmid/:memID')
//   async gbmid(@Res() res, @Param('memID') memID) {
   
//     const mealPlan = await this.mealPlanService.GetWithMN(memID);
//     if (this.isEmpty(mealPlan)) {
//       res.status(HttpStatus.OK).send('No Data Found');
//     } else res.status(HttpStatus.OK).send(mealPlan);
   
//   }

//   //get by meal plan name
//   @Get('gbmpn/:mpName')
//   async gbmpn(@Res() res, @Param('mpName') mpName) {
   
//     const mealPlan = await this.mealPlanService.getByMealPlanName(mpName);
//     if (this.isEmpty(mealPlan)) {
//       res.status(HttpStatus.OK).send('No Data Exist');
//     } else res.status(HttpStatus.OK).send(mealPlan);
//     // res.status(HttpStatus.OK).send(mpName);
   
//   }
 

//   //get by member id and mp_id
//   @Get('gbidwd/:memID/:mpID')
//   async gbidwd(@Res() res, @Param('memID') memID,@Param('mpID') mpID) {
   
//     const mealPlan = await this.mealPlanService.gbidwd(memID, mpID);
//     if (this.isEmpty(mealPlan)) {
//       res.status(HttpStatus.OK).send('No Data Found');
//     } else res.status(HttpStatus.OK).send(mealPlan);
   
//   }

//   @Post()
//   async save(@Res() res, @Body() mealPlan: MealPlan) {
//     var checkExist = this.mealPlanService.findExist(mealPlan) as MealPlan;
//     if (this.isEmpty( checkExist)) mealPlan.meal_plan_count_ = 1;
//     else mealPlan.meal_plan_count_ = checkExist.meal_plan_count_ + 1;

//     mealPlan = await this.mealPlanService.save(mealPlan);
//     if (this.isEmpty( mealPlan)) {
//       res
//         .status(HttpStatus.INTERNAL_SERVER_ERROR)
//         .send('INTERNAL SERVER ERROR 4545');
//     } else res.status(HttpStatus.CREATED).send(mealPlan);
//   }

//   isEmpty(obj) {
//     for (var key in obj) {
//       if (obj.hasOwnProperty(key)) return false;
//     }
//     return true;
//   }
}
