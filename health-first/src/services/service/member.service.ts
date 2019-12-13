import { Injectable, HttpException, Inject } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Member } from '../../entities/member.entity';
import { Observable } from 'rxjs';
import { Category } from '../../entities/category.entity';

@Injectable()
export class MemberService {
  members: any[] = [
    { id: 2, name: 'sampoath' },
    { id: 2, name: 'sampoath' },
    { id: 2, name: 'sampoath' },
    { id: 2, name: 'sampoath' },
    { id: 2, name: 'sampoath' },
  ];

  // constructor( @InjectRepository(Member)
  // private readonly memberRepository: Repository<Member>) {}
  constructor(
    @Inject('MemberRepositoryToken')
    private readonly memberRepository: Repository<Member>,
  ) {}

  getMember(memberID: number): Promise<any> {
    return new Promise(resolve => {
      const member = this.members.find(mem => mem.id == memberID);
      if (!member) throw new HttpException('Member data note found', 404);
      else resolve(member);
    }).catch(error => {
      console.log(error);
    });
  }
  getAllMember(): Promise<any> {
    return new Promise(resolve => {
      if (this.members) throw new HttpException('Member data note found', 404);
      else resolve(this.members);
    }).catch(error => {
      console.log(error);
    });
  }

  testORM(): Promise<any> {
    return new Promise(resolve => {
      var mem = this.memberRepository.find();
      resolve(mem);
    }).catch(error => {
      console.log(error);
    });
  }

  // returnString(): Promise<Member[]>{
  //   return new Promise(resolve => {
  //     var mem = this.memberRepository.find({});
  //     resolve(mem);
  //   });
  // }
  returnString() {
    var mem = this.memberRepository.find({});
    return mem;
  }

  async findAll(): Promise<Member[]> {
    // return  new  Promise(async res=>{
    //   var mem=await this.memberRepository.find(obj=>obj.in)
    //   res(mem);
    // });
    // return await  this.memberRepository.find();
    // return await  this.memberRepository.createQueryBuilder("Member")
    // .leftJoinAndSelect("Member.category", 'Category').getMany();
    // return await  this.memberRepository.createQueryBuilder("Category")
    // .leftJoinAndSelect("Category.member", 'Member').getMany();
    // return await  this.memberRepository.createQueryBuilder("Member")
    // .select(['Member.member_id_', 'Member.name_', 'Member.age_',
    // 'Member.address_', 'Member.category_id_'])
    return await this.memberRepository.query('select * from member_');
  }
  async getMemberWithCategory(): Promise<Member[]> {
    return  new  Promise(async res=>{
      var mem=await this.memberRepository.createQueryBuilder("Member")
      .leftJoinAndSelect("Member.category", 'Category').getMany();
      res(mem);
    });
    // return await  this.memberRepository.createQueryBuilder("Member")
    // .leftJoinAndSelect("Member.category", 'Category').getMany();

    // return await  this.memberRepository.createQueryBuilder("Member")
    // .select(['Member.member_id_', 'Member.name_', 'Member.age_',
    // 'Member.address_', 'Member.category_id_'])

  }

  async save(member: Member): Promise<Member> {
    return  new  Promise(async res=>{
      var mem=await this.memberRepository.save(member);
      res(mem);
    });

  }

  async findOneOld(memID: number): Promise<Member> {
    const cat=await this.memberRepository.query('select * from member_ where member_id_ = ' + memID) ;
    return cat;
     
  }
   async findOne(memID: number): Promise<any> {
    return  new  Promise(async res=>{
    var mem=await this.memberRepository.createQueryBuilder("Member")
    .leftJoinAndSelect("Member.category", 'Category')
    .where("Member.member_id_ = :id",{id:memID}).
    getOne();
    res(mem);
  }).catch(err=>{
    console.log(err);
  });
  }


  async findExist(mem: Member): Promise<any> {
    return new Promise(async resolve => {
      var memberRetreived:Member;
      memberRetreived= await this.memberRepository
        .createQueryBuilder('Member')
        .where('first_name_ = :fname', { fname : mem.first_name_ })
        .andWhere("last_name_ = :lname", {lname : mem.last_name_})
        .getOne();
        console.log(memberRetreived);
       resolve(memberRetreived);
    }).catch(error => {
      throw new HttpException('System Error', 444);
      console.log(error);
    });
  }


}
