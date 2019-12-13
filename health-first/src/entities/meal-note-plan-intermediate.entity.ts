import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable } from 'typeorm';
import { MealNote } from './meal-note.entity';
import { Label } from './label.entity';
import { MealPlan } from './meal-plan.entity';

@Entity({name: "meal_note_plan_intermediate_"})
export class MealNotePlanIntermediate {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
meal_note_plan_intermediate_id_?:number;
@Column()
who_is_?:string;
@Column()
time_stamp_?:Date;
@Column()
meal_time_ ? :string; 
@Column()
meal_plan_id_?:number;
@Column()
label_id_?:number;
@Column()
category_id_?:number;
@Column()
bmi_id_?:number;
@Column()
meal_time_order_?:string;
@Column()
member_bmi_value_?:number;
@Column()
meal_note_id_?:number;
@JoinColumn({name:"label_id_" })
@ManyToOne(type => Label, label=>label.mealPlanNoteIntermediate)
label?:Label;
@JoinColumn({name:"meal_note_id_" })
@ManyToOne(type => MealNote, cat=>cat.mealPlanNoteIntermediate)
mealNote?:MealNote;

@JoinColumn({name:"meal_plan_id_" })
@ManyToOne(type => MealPlan, cat=>cat.mealsNotePlanIntermediate)
mealPlan?:MealPlan;



}


   

