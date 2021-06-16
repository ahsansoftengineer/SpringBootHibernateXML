package com.durgesh;

import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import com.durgesh.types.*;
import org.hibernate.*;

public class IXMLMapping {
  public static void main(String[] args) {
    Session session = new Configuration()
      .configure("com/configuration/_XMLMappingHibernate.cfg.xml")
      .buildSessionFactory()
      .openSession();
    Transaction transaction = session.beginTransaction();

    AddPerson(session);

    transaction.commit();
    session.close();

  }
  public static void AddPerson(Session session){
    Person person1 = new Person(1, "Ahsan", Gender.Male.toString());
    Person person2 = new Person(2, "Asim", Gender.Male.toString());
    Person person3 = new Person(3, "Ayesha", Gender.Female.toString());
    Person person4 = new Person(4, "Fatima", Gender.Female.toString());
    Person person5 = new Person(5, "Shabo", Gender.Other.toString());
    session.save(person1);
    session.save(person2);
    session.save(person3);
    session.save(person4);
    session.save(person5);
  }
  public static void getPerson(Session session){
    Query query = session.createQuery("DELETE FROM Student WHERE id = :d");
    query.setParameter("d", 5);
    System.out.println(query.executeUpdate()); 
  }
}
