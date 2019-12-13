import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable } from 'typeorm';
import { MealNote } from './meal-note.entity';
import { Label } from './label.entity';
import { MealPlan } from './meal-plan.entity';
import { Template } from './template.entity';

@Entity({name: "template_meal_note_intermediate_"})
export class TemplateMealNoteIntermediate {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
template_meal_note_intermediate_id_?:number;
@Column()
who_is_?:string;
@Column()
time_stamp_?:Date;

@Column()
meal_time_ ? :string; 
@Column()
template_id_?:number;
@Column()
label_id_?:number;
@Column()
category_id_?:number;
@Column()
bmi_id_?:number;
@Column()
meal_time_order_?:string;
@Column()
diet_category_text_value_?:string;
@Column()
meal_note_id_?:number;


@JoinColumn({name:"label_id_" })
@ManyToOne(type => Label, label=>label.temMealsNotePlanIntermediate)
label?:Label;
@JoinColumn({name:"meal_note_id_" })
@ManyToOne(type => MealNote, cat=>cat.temMealsNotePlanIntermediate)
mealNote?:MealNote;

@JoinColumn({name:"template_id_" })
@ManyToOne(type => Template, tem=>tem.temMealsNotePlanIntermediate)
template?:Template;



}


   

