import { Injectable, Inject, HttpException } from '@nestjs/common';
import { Label } from '../../entities/label.entity';
import { Repository } from 'typeorm';

@Injectable()
export class LabelService {
  constructor(
    @Inject('LabelRepositoryToken')
    private readonly labelRepository: Repository<Label>,
  ) {}

  async getAll(): Promise<any> {
    return new Promise(async resolve => {
      const label = await this.labelRepository.find();
      if (!label) throw new HttpException('Label data note found', 444);
      else resolve(label);
    }).catch(error => {
      console.log(error);
    });
  }

  async checkAdd(label: Label): Promise<any> {
    return new Promise(async resolve => {
      var labelRetrieved:Label;
      labelRetrieved= await this.labelRepository
        .createQueryBuilder('Label')
        .where('Label.label_name_ = :name', { name: label.label_name_ })
        .getOne();
      if(labelRetrieved==null)
      {
       const newLabel= this.labelRepository.save(label);
       resolve(newLabel);
      }
      else
      resolve(labelRetrieved);
    }).catch(error => {
      throw new HttpException('System Error', 444);
      console.log(error);
    });
  }

  //   async findAll(): Promise<Member[]> {

  //     return await this.memberRepository.query('select * from member_');
  //   }
  //   async getMemberWithCategory(): Promise<Member[]> {
  //     return  new  Promise(async res=>{
  //       var mem=await this.memberRepository.createQueryBuilder("Member")
  //       .leftJoinAndSelect("Member.category", 'Category').getMany();
  //       res(mem);
  //     });

  //   }

  //   async save(member: Member): Promise<Member> {
  //     return  new  Promise(async res=>{
  //       var mem=await this.memberRepository.save(member);
  //       res(mem);
  //     });

  //   }

  //   async findOneOld(memID: number): Promise<Member> {
  //     const cat=await this.memberRepository.query('select * from member_ where member_id_ = ' + memID) ;
  //     return cat;

  //   }
  //    async findOne(memID: number): Promise<Member> {
  //     return  new  Promise(async res=>{
  //     var mem=await this.memberRepository.createQueryBuilder("Member")
  //     .leftJoinAndSelect("Member.category", 'Category')
  //     .where("Member.member_id_ = :id",{id:memID}).
  //     getOne();
  //     res(mem);
  //   });
  //   }
}
