
import { Entity, Column, PrimaryGeneratedColumn, PrimaryColumn, OneToMany, JoinColumn } from 'typeorm';
import { Member } from './member.entity';
// import { Member } from 'dist/src/member/member.model.entity';

@Entity({name: "category_"})
export class Category {
    @PrimaryGeneratedColumn()
    category_id_?:number;
    @Column()  
    name_?: string;
    @Column()  
    who_is_?:string;
    @Column()  
    time_stamp_?:Date;
    
    @OneToMany(type => Member, mem => mem.category)
    @JoinColumn()
  
    members?:Member[];
  }