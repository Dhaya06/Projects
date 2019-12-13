import { Controller, Get, Res, HttpStatus, Post, Body } from '@nestjs/common';
import { CategoryService } from '../services/service/category.service';
import { Category } from '../entities/category.entity';

@Controller('api/category')
export class CategoryController {
    constructor(
        private readonly catService: CategoryService,
      ) {}
    
    
    @Get('getAllCatWithMemer')
    async getAllCatWithMemer(@Res() res) {
        const category = await this.catService.getAll();
        res.status(HttpStatus.FOUND).send(category);
     }

     @Post()
   async create(@Body() category:Category, @Res() res) {
        category = await this.catService.save(category);
        res.status(HttpStatus.CREATED).send(category);
        // return 'This action adds a new cat';
    }

     @Get('getAll')
     async getAll(@Res() res) {
         const category = await this.catService.getAll();
         res.status(HttpStatus.OK).json(category);
    }

}
