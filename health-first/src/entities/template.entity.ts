import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';
import { Category } from './category.entity';
import { MealPlan } from './meal-plan.entity';
import { Bmi } from './bmi.entity';
import { TemplateMealNoteIntermediate } from './template-meal-note-intermediate.entity';
// import { Category } from 'src/category/category.entity';

@Entity({name: "template_"})
export class Template {
@PrimaryGeneratedColumn()
template_id_ : number;    
  @Column()
  who_is_?:string;
  @Column()
  time_stamp_?:Date;
  @Column()
  template_name_?:string;
  @Column()
  category_id_?:number;
  @Column()
  bmi_id_?:number;
  @Column()
  bmi_category_text_value_?:string;
  @Column()
  diet_category_text_value_?:string;

  @OneToMany(type => TemplateMealNoteIntermediate, mem=>mem.template)
  temMealsNotePlanIntermediate:TemplateMealNoteIntermediate[];
}

