package com.durgesh;

import java.io.FileInputStream;
import java.util.Date;

import com.durgesh.types.Alien;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
// Image Column is not working
public class DAnnotations {
  private static FileInputStream image;

  public static void main(String[] args) {
      // saveAlien(new Alien(1, "Hansa Parek", "Female", 20, new Date(), null, 50));
      System.out.println(getAlien(352));
  }

  // Get Method Doesn't Required Transaction
  public static Alien getAlien(int id) {
    return new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession()
      .get(Alien.class, id);
  }

  // Here Transaction Required because Insert Update Query
  public static void saveAlien(Alien alien) {
    // try {
    //   image = new FileInputStream("src/main/java/image/image2.png");
    //   byte[] data = new byte[image.available()];
    //   image.read(data);
    //   alien.image = data;
    //   image.close();
    // } 
    // catch (Exception e) {
    //     System.out.println(e.getMessage());
    // }

    Session session = new Configuration()
      .configure()
      .buildSessionFactory()
      .openSession();
    Transaction tr = session.beginTransaction();
    session.save(alien);
    tr.commit();
    session.close();
    System.out.println("Done the old stuff");
  }
}
