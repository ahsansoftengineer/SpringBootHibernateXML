package com.durgesh;

import java.util.Arrays;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.*;

public class GNativeQuerySQLObject {
  public static void main(String[] args) {
    Session session = new Configuration()
      .configure("com/configuration/_PaginationConfiguration.cfg.xml")
      .buildSessionFactory()
      .openSession();

    // NativeQuerySQL(session);
    NativeQueryStoredProcedure(session);
    session.close();
  }

  // Native Query deepToString Example
  private static void NativeQuerySQL(Session session){
    // NativeQuery query = session.createNativeQuery("SELECT * FROM rental", Rental.class);
    NativeQuery query = session.createNativeQuery("SELECT * FROM rental");
    query.setFirstResult(50); // index based
    query.setMaxResults(50);

    List<Object[]> rentals = query.list();

    for (Object[] rental : rentals) {
      // System.out.println(rental[0] + " : " + rental[1]);
      System.out.println(Arrays.deepToString(rental));
    }
  }

  // Native Query Stored Procedure
  private static void NativeQueryStoredProcedure(Session session) {
    // NativeQuery query = session.createNativeQuery("SELECT * FROM rental",
    // Rental.class);
    StoredProcedureQuery sp = session.createNamedStoredProcedureQuery("film_in_stock");
    sp.setParameter("p_film_id", 1);
    sp.setParameter("p_store_id", 1);
    sp.setParameter("p_film_id", 1);
    // Maybe its output parameter
    // sp.registerStoredProcedureParameter(arg0, arg1, arg2)
    // sp.setFirstResult(50); // index based
    // sp.setMaxResults(50);

    List<Object[]> rentals = sp.getResultList();

    for (Object[] rental : rentals) {
      // System.out.println(rental[0] + " : " + rental[1]);
      System.out.println(Arrays.deepToString(rental));
    }
  }
}
