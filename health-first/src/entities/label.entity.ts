import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';
import { MealNotePlanIntermediate } from './meal-note-plan-intermediate.entity';
import { TemplateMealNoteIntermediate } from './template-meal-note-intermediate.entity';

@Entity({name: "label_"})
export class Label {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
label_id_?:number;
@Column()
who_is_?:string;
@Column()
time_stamp_?:Date;
@Column()
label_name_ ? :string; 

@OneToMany(type => MealNotePlanIntermediate, mnpi => mnpi.label)
mealPlanNoteIntermediate:MealNotePlanIntermediate[];

@OneToMany(type => TemplateMealNoteIntermediate, tmnpi => tmnpi.label)
temMealsNotePlanIntermediate:TemplateMealNoteIntermediate[];
}


