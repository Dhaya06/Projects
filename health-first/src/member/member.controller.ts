import {
  Controller,
  Get,
  Res,
  Param,
  HttpStatus,
  Req,
  UseFilters,
  Post,
  Body,
} from '@nestjs/common';
import { MemberService } from '../services/service/member.service';
import { Member } from '../entities/member.entity';
import { Category } from '../entities/category.entity';
import { CategoryService } from '../services/service/category.service';
import { IsNull } from 'typeorm';
import { isNullOrUndefined } from 'util';
// import { FlubErrorHandler } from 'nestjs-flub';
// import { FlubErrorHandler } from 'nestjs-flub/src/flub-error-handler';
import { BmiService } from '../services/service/bmi.service';
import { Bmi } from '../entities/bmi.entity';
@Controller('api/member')
// @UseFilters(new FlubErrorHandler())
export class MemberController {
  constructor(
    private readonly memService: MemberService,
    private readonly catService: CategoryService,
    private readonly bmiService: BmiService,
  ) {}

  @Get()
  async getAll(@Res() res) {
    const members = await this.memService.getMemberWithCategory();
    res.status(HttpStatus.OK).send(members);
  }

  @Get('getAllWithCat')
  async findAll() {
     const member = await this.memService.findAll();
    var count = 0;
    for (let element of member) {
      var index = member.indexOf(element);
      var cat = (await this.catService.getCategoryOfMember(
        element.category_id_,
      )) as Category;
      member[index].category = cat as Category;
    }
    return member;
  }

  @Get('getAllWithCat2')
  async findAll2() {
     const member = await this.memService.getMemberWithCategory();
        return member;
  }
  @Get('tt')
  async testName(@Res() res) {
   
    let mems:Member ={
      first_name_:'dd',
      last_name_:'asd'
    };
    const mem= await this.memService.findExist(mems) as Member;
   if(mem==undefined){
    res.status(444).json("no");
   }else{
    res.status(HttpStatus.FOUND).json(mem);
   }
   
  }

  @Get(':id')
  async findOne( @Param('id') id,  @Res() res ) {
    const member = await this.memService.findOne(id) ;
    if(this.isEmpty(member))
    res.status(HttpStatus.NOT_FOUND).json("Member Not Found");
    else
     res.status(HttpStatus.CREATED).json(member);
  }
  @Get('gwc/:id')
  async findOneWithCat( @Param('id') id,  @Res() res ) {
    const member = await this.memService.findOne(id) ;
    if(this.isEmpty(member))
    res.status(HttpStatus.NOT_FOUND).json("Member Not Found");
    else
     res.status(HttpStatus.CREATED).json(member);
  }
 
 
  @Get('testBmi/:bmi')
  async testBmi( @Param('bmi') bmi,  @Res() res ) {
    var bmi_= Math.round(bmi * 10) /10 ;
    const bmiList= await this.bmiService.getAll() as unknown as Bmi[];
  
    var a={bmi_id_:0,bmi_valueRange:"",bmiText:""};
      bmiList.forEach(element => {
      var minMax=element.bmi_value_range_.split("-");
      if(Number(minMax[0])<=bmi_ &&  Number(minMax[1])>=bmi_)
      {
        a.bmi_id_=element.bmi_id_;
        a.bmi_valueRange=element.bmi_value_range_;
        a.bmiText=element.bmi_text_value_;
      }
    });
     res.status(HttpStatus.OK).json(a);
  }



  @Post()
  async create(@Body() member:Member, @Res() res) {
    //get the bmi id of this member
   var bmi_=Math.round(member.bmi_ * 10) /10 ; 
   
    const bmiList= await this.bmiService.getAll() as unknown as Bmi[];
    bmiList.forEach(element => {
      var minMax=element.bmi_value_range_.split("-");
      debugger
      if(Number(minMax[0])<=bmi_ &&  Number(minMax[1])>=bmi_)
      {
        member.bmi_id_=element.bmi_id_;
      }
    });
    console.log(member);
    member = await this.memService.save(member);
    res.status(HttpStatus.CREATED).json(member);
  }

  @Post('searchName')
  async checkExist(@Body() member:Member, @Res() res) {
  console.log(member);
    const mem= await this.memService.findExist(member) as Member;
    if(mem==undefined){
      res.status(HttpStatus.CREATED).json("no");
     }else{
      res.status(HttpStatus.OK).json(mem);
     }
  }



  isEmpty(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }


  // @Get()
  //  get(@Res() res)
  // {
  //     // res.status(HttpStatus.OK).json(memer);
  //     //  var memer= this.memService.testORM();
  //     // res.status(HttpStatus.CREATED).json(memer);
  //     return "fun you";
  // }
}
