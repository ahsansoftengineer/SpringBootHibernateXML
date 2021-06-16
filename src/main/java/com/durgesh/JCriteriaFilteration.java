package com.durgesh;

import java.util.List;

import com.durgesh.types.Laptop;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class JCriteriaFilteration {
  public static void main(String[] args) {
    Session session = new Configuration().configure().buildSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    getLaptops(session);
    transaction.commit();
    session.close();
  }

  // This Code is not working
  public static void getLaptops(Session session) {
    // Criteria c = session.createCriteria(Laptop.class);
    // c.add(Restriction.eq("student.name", "Laptop"));
    // List<Laptop> laptops = c.list();
    // for(Laptop laptop: laptops){
    // System.out.println(laptop);
    // }
  }
}
