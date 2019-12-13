import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';
import { Category } from './category.entity';
import { MealPlan } from './meal-plan.entity';
import { Bmi } from './bmi.entity';
// import { Category } from 'src/category/category.entity';

@Entity({name: "member_"})
export class Member {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
 member_id_ ?: number;   
 @Column()  
 last_name_?:string;         
 @Column()  
 first_name_?:string;         
 @Column()
  age_?:number;     
  @Column()
 weight_?:number;     
 @Column()
 height_?:number;     
 @Column() 
 address_?:string;    
 @Column()
  hmu_?:string;
  @Column()
  wmu_?:string;
  @Column()
  contact_?:string;
  @Column()
  email_?:string;
  @Column()
  nic_?:string;
  @Column()
  bmi_ ?:number;
  @Column()
  bmi_text_ ?:string;
  @Column()
  //@RelationId((member: Member) => member.category) 
  category_id_ ?:number;
  @Column()
  gender_ ?:string;
  @Column()
  bmi_id_ ?:number;
  @ManyToOne(type => Category, cat=>cat.members)
   @JoinTable()
  @JoinColumn({name:"category_id_" })
  category?:Category

  @ManyToOne(type => Bmi, b=>b.members)
   @JoinTable()
  @JoinColumn({name:"bmi_id_" })
  bmi?:Bmi

    //  virtual ICollection<MealsPlan> mealPlan { get; set; }
  @OneToMany(type =>MealPlan, mn=>mn.member)
  mealPlans?:MealPlan[];

}


