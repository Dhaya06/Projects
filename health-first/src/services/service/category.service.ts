import { Injectable, Inject } from '@nestjs/common';
import { Repository } from 'typeorm';
import { Category } from '../../entities/category.entity';
import { Member } from 'src/entities/member.entity';

@Injectable()
export class CategoryService {
    constructor( @Inject('CategoryRepositoryToken')
    private readonly categoryRepository: Repository<Category>) {}
  

    async getCategoryOfMember(category_id_:number): Promise<Category> {
        console.log("MemberID"+category_id_)
        const cat=await  this.categoryRepository.query("select * from category_ where category_id_="+category_id_);
        return cat as Category;
    }

    gg(mem:Member)
    {console.log(mem);
       
        const cat=  this.categoryRepository.query("select * from category_ where category_id_ = "+mem.category_id_);
        console.log(cat);
    }

    async getAll(): Promise<Category[]> {
        return  new  Promise(async res=>{
          var mem=await this.categoryRepository.find();
          res(mem);
        });
    
      }
    async save(category: Category): Promise<Category> {
        return  new  Promise(async res=>{
          var cat=await this.categoryRepository.save(category);
          res(cat);
        });
    
      }
    async getAllWithMember(): Promise<Category[]> {
        return  new  Promise(async res=>{
          var mem=await this.categoryRepository.createQueryBuilder("Category")
          .leftJoinAndSelect("Category.members", 'Member').getMany();
          res(mem);
        });
        // return await  this.memberRepository.createQueryBuilder("Member")
        // .leftJoinAndSelect("Member.category", 'Category').getMany();
    
        // return await  this.memberRepository.createQueryBuilder("Member")
        // .select(['Member.member_id_', 'Member.name_', 'Member.age_',
        // 'Member.address_', 'Member.category_id_'])
    
      }
}
