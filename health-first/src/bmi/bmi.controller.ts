import { Controller,Get,Res, HttpStatus, } from '@nestjs/common';
import { BmiService } from '../services/service/bmi.service';

@Controller('api/bmi')
export class BmiController {
/**
 *
 */
constructor(private bmiService:BmiService) {
}

@Get()
async getAll( @Res() res)
{
    const labels=await this.bmiService.getAll();
    res.status(HttpStatus.OK).send(labels);
}
}
