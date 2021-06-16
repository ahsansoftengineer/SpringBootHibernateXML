package com.durgesh;


import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.durgesh.types.Laptop;
import com.durgesh.types.Student;

import org.hibernate.*;

public class HCascadingSave2Entities {
  public static void main(String[] args) {
    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();
   

    Transaction transaction = session.beginTransaction();

    // session.save(AddStudentCascade());
    deleteStudent(session);

    transaction.commit();
    session.close();

  }
  public static Student AddStudentCascade(){
    Laptop laptop1 = new Laptop(10, "HP");
    Laptop laptop2 = new Laptop(11, "Dell");
    Laptop laptop3 = new Laptop(12, "Lenovo");
    Laptop laptop4 = new Laptop(13, "Toshiba");
    List<Laptop> laptops = new ArrayList<Laptop>();
    laptops.add(laptop1);
    laptops.add(laptop2);
    laptops.add(laptop3);
    laptops.add(laptop4);
    Student student = new Student(6, "Tanzela");
    laptop1.student = student;
    laptop2.student = student;
    laptop3.student = student;
    laptop4.student = student;
    student.laptop.addAll(laptops);
    return student;
  }
  public static void deleteStudent(Session session){
    Query query = session.createQuery("DELETE FROM Student WHERE id = :d");
    query.setParameter("d", 5);
    System.out.println(query.executeUpdate()); 
  }
}
