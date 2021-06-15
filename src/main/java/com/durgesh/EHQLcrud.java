package com.durgesh;
import javax.persistence.Query;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class EHQLcrud {
  public static void main(String[] args) {
    Session session =  new Configuration()
    .configure()
    .buildSessionFactory()
    .openSession();

    Transaction transaction =  session.beginTransaction();

    // Query query = session.createQuery("UPDATE Alien SET name = 'Furqan' WHERE id = :d");
    // query.setParameter("d", 352);
    // System.out.println(query.executeUpdate());

    Query query2 = session.createQuery("DELETE FROM Alien WHERE id = :d");
    query2.setParameter("d", 352);
    System.out.println(query2.executeUpdate());
    
    transaction.commit();
    session.close();
  }
}
