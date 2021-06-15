package com.durgesh;

import com.durgesh.types.Teacher;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CClassConfigurationInConfig {
  public static void main(String[] args) {


    System.out.println(getTeacher(103));
    // saveTeacher(new Teacher(104, "Mobin", "Male", 80));
  }
  // Get Method Doesn't Required Transaction 
  public static Teacher getTeacher(int id){
    // Default path is java folder other wise explicitly provide the path and file of your configuration file.
    return new Configuration()
      .configure("com/durgesh/_CustomNameHibernate.cfg.xml")
      .buildSessionFactory()
      .openSession()
      .get(Teacher.class, id);
  }
  // Here Transaction Required because Insert Update Query
  public static void saveTeacher(Teacher teacher){
    Session session = new Configuration()
    .configure("com/durgesh/_CustomNameHibernate.cfg.xml")
    // .addAnnotatedClass(Teacher.class) // provided in hibernate.cfg file
    .buildSessionFactory()
    .openSession();
    Transaction tr = session.beginTransaction();
    session.save(teacher);
    tr.commit();
    session.close();
    
  }
}
