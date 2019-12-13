import { Controller, Get, Res, HttpStatus, Post, Body, Query, Param, Put, Delete } from '@nestjs/common';
import { AppService } from './app.service';

export class SampleClass{
  id:number;
  name:string;
}

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get("test")
  getHello() {
   return "hello World";
  }

  @Get("2")
  findAll(@Res() res) {
    var result=[{id:'1', message:"pn"},{id:'2', message:"454"}];
    //  res.status(HttpStatus.OK).json(result);
    res.status(HttpStatus.CREATED).send(result);
  }

  @Post()
  create(@Body() createCatDto:SampleClass) {
    return 'This action adds a new cat';
  }

  @Get()
  findAll2(@Query() query) {
    return `This action returns all csdfdsats (limit: ${query.limit} items)`;
  }

  @Get(':id')
  findOne(@Param('id') id) {
    return `This action returns a #${id} cat`;
  }

  @Put(':id')
  update(@Param('id') id, @Body() updateCatDto) {
    return `This action updates a #${id} cat`;
  }

  @Delete(':id')
  remove(@Param('id') id) {
    return `This action removes a #${id} cat`;
  }
}
