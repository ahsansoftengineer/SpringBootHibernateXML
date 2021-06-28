package com.durgesh;

import com.durgesh.types.Alien;
import org.hibernate.cfg.Configuration;

public class BCustomConfiguration {
  public static void main(String[] args) {
    // Default path is java folder other wise explicitly provide the path and file of your configuration file.
    Alien teacher = new Configuration()
      .configure("com/configuration/_CustomNameHibernate.cfg.xml")
      // .addAnnotatedClass(Teacher.class)
      .buildSessionFactory()
      .openSession()
      .get(Alien.class, 1);
    System.out.println(teacher);
    // session.getTransaction().commit();
  }
}
