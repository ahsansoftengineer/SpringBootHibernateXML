package com.durgesh;

import java.util.List;

import javax.persistence.Query;
import com.durgesh.types.Rental;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class FPagination {
  public static void main(String[] args) {
    Session session = new Configuration()
      .configure("com/configuration/_PaginationConfiguration.cfg.xml")
      .buildSessionFactory()
      .openSession();

    Query query = session.createQuery("FROM Rental");
    query.setFirstResult(50); // index based
    query.setMaxResults(50);

    List<Rental> rentals = query.getResultList();

    for (Rental rental : rentals) {
      System.out.println(rental);
    }
    session.close();
  }
}
