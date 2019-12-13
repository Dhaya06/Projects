import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';
import { MealNotePlanIntermediate } from './meal-note-plan-intermediate.entity';
import { TemplateMealNoteIntermediate } from './template-meal-note-intermediate.entity';

@Entity({name: "meals_note_"})
export class MealNote {
@PrimaryGeneratedColumn()
// @PrimaryColumn()
meal_note_id_?:number;
@Column()
who_is_?:string;
@Column()
time_stamp_?:Date;
@Column()
m_note ? :string;  
@OneToMany(type => MealNotePlanIntermediate, mnpi => mnpi.mealNote)
mealPlanNoteIntermediate:MealNotePlanIntermediate[];
@OneToMany(type => TemplateMealNoteIntermediate, tmnpi => tmnpi.mealNote)
temMealsNotePlanIntermediate:TemplateMealNoteIntermediate[];
}


