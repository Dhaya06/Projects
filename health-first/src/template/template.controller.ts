import { Controller, Get, Res, HttpStatus, Param, Post, Body } from '@nestjs/common';
import { TemplateService } from '../services/service/template.service';
import { Template } from 'src/entities/template.entity';

@Controller('api/template')
export class TemplateController {


    constructor(private readonly templateService:TemplateService) {
        
    }
    @Get()
    async getAll(@Res() res) {
      const templates = await this.templateService.getAll();
      if(this.isEmpty(templates))
      res.status(HttpStatus.NOT_FOUND).json("Data Not Found");
      else
      res.status(HttpStatus.OK).send(templates);
    }

    @Get(':id')
    async findOne( @Param('id') id,  @Res() res ) {
      const template = await this.templateService.findOne(id) ;
      if(this.isEmpty(template))
      res.status(HttpStatus.NOT_FOUND).json("Data Not Found");
      else
       res.status(HttpStatus.CREATED).json(template);
    }

    @Get('cne/:name')
    async findOneWithCat( @Param('name') name,  @Res() res ) {
      const template = await this.templateService.checkNameExist(name) ;
      if(this.isEmpty(template))
      res.status(HttpStatus.OK).json(1);
      else
       res.status(HttpStatus.CREATED).json(2);
    }

    @Post()
    async create(@Body() template:Template, @Res() res) {
      const templates= await this.templateService.save(template);
      if (this.isEmpty( templates)) {
        res
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .send('INTERNAL SERVER ERROR 4545');
      } else  res.status(HttpStatus.CREATED).json(templates);
    }


    isEmpty(obj) {
        for (var key in obj) {
          if (obj.hasOwnProperty(key)) return false;
        }
        return true;
      }
}
