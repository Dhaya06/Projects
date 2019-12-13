import { Injectable, Inject } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Bmi } from '../../entities/bmi.entity';

@Injectable()
export class BmiService {

    constructor( @Inject('BmiRepositoryToken')
    private readonly bmiRepository: Repository<Bmi>) {}


    async getAll(): Promise<Bmi[]> {
        return  new  Promise(async res=>{
          var mem=await this.bmiRepository.find();
          res(mem);
        });
    
      }
}
