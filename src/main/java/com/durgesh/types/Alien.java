package com.durgesh.types;

import java.util.Date;

import javax.persistence.*;

@Entity // use to mark any class as Entity
@Table // use to Change the table Details
public class Alien { 
  @Id // use to mark column as id(primary key)
  @GeneratedValue // auto Generate internal sequence we don't have to set it manually.
  private int id;

  @Column(unique = false, insertable = true, updatable = true, nullable = true,
          length = 255, precision = 0, scale = 0)
  private String name;
  
  private String gender;
  private int assesment;

  @Temporal(TemporalType.DATE) // Date Format save in database
  private Date dob;

  @Lob
  public byte[] image;

  @Transient      // don't create column in database table
  private int age;
  
  public Alien (){}
  public Alien(int id, String name, String gender, 
               int assesment, Date dob, byte[] image, int age) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.assesment = assesment;
    this.dob = dob;
    this.image = image;
    this.age = age;
  }
  @Override
  public String toString(){
   return "Teacher : { " + id + " : " + name + " : " + gender + " : " + assesment + dob  + " : " + age + " }";
  }
}
