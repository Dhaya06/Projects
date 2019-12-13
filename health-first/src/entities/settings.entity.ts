import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToOne, JoinColumn, ManyToOne, JoinTable, OneToMany } from 'typeorm';

@Entity({name: "settings_"})
export class Setting {
@PrimaryGeneratedColumn()
settings_id_?:number;
@Column()
search_by_label_?:number;
@Column()
search_by_bmi_?:number;
@Column()
searc_by_diet_cat_ ? :number; 

}


