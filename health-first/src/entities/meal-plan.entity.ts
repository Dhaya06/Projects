import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';
import { Member } from './member.entity';
import { Category } from './category.entity';
import { MealNotePlanIntermediate } from './meal-note-plan-intermediate.entity';

@Entity({name: "meals_plan_"})
export class MealPlan {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
meal_plan_id_?:number;
@Column()
who_is_?:string;
@Column()
meal_plan_name_?:string;
@Column()
time_stamp_?:Date;
@Column()
member_name_ ? :string;
@Column()
member_id_?:number;
@Column()
category_id_?:number;
@Column()
bmi_id_?:number;
@Column()
member_bmi_value_?:number;
@Column()
member_bmi_text_value_?:string;
@Column()
meal_plan_count_?:number;

@OneToMany(type => MealNotePlanIntermediate, mem=>mem.mealPlan)
mealsNotePlanIntermediate?:MealNotePlanIntermediate[];

category?:Category;

@ManyToOne(type => Member, mem=>mem.mealPlans)
   @JoinTable()
  @JoinColumn({name:"member_id_"})
 member?:Member;

}



// public virtual Member member { get; set; }
// public virtual Category category { get; set; }
// public virtual ICollection<MealsNotePlanIntermediate> mealsNotePlanIntermediate { get; set; }


