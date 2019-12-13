
import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToMany, JoinColumn } from 'typeorm';
import { Member } from './member.entity';
// import { Member } from 'dist/src/member/member.model.entity';

@Entity({name: "bmi_"})
export class Bmi {
    @PrimaryGeneratedColumn()
    bmi_id_?:number;
    @Column()  
    bmi_text_value_?: string;
    @Column()  
    who_is_?:string;
    @Column()  
    time_stamp_?:Date;
    
    @Column()  
    bmi_value_range_?:string;
    
    @OneToMany(type => Member, mem => mem.bmi)
    @JoinColumn()
    members?:Member[];
  }