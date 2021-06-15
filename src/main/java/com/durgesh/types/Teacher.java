package com.durgesh.types;

import javax.persistence.*;

@Entity // use to mark any class as Entity
public class Teacher { 
  @Id // use to mark column as id(primary key)
  private int id;
  private String name;
  private String gender;
  private int assesment;
  
  public Teacher (){}
  public Teacher(int id, String name, String gender, int assesment) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.assesment = assesment;
  }
  @Override
  public String toString(){
   return "Teacher : { " + id + " : " + name + " : " + gender + " : " + assesment + " }";
  }

}
