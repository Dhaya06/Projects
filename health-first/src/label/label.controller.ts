import { Controller, Get, Res, HttpStatus, Param } from '@nestjs/common';
import { LabelService } from '../services/service/label.service';
import { Label } from '../entities/label.entity';

@Controller('api/label')
export class LabelController {
constructor(private readonly labelService:LabelService)
{}

@Get()
async getAll( @Res() res)
{
    const labels=await this.labelService.getAll();
    res.status(HttpStatus.OK).send(labels);
}

@Get("checkAdd/:labelName")
async checkAdd( @Res() res,@Param("labelName") labelName )
{
    var label=new Label();
    label.label_name_=labelName;
    const labels=await this.labelService.checkAdd(label);
    res.status(HttpStatus.OK).send(labels);
}




 

}
