package com.durgesh;
import javax.persistence.*;
import com.durgesh.types.Teacher;
public class APersistence 
{
  public static void main(String[] args) {
    // System.out.println("Working");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
    
    System.out.println(getTeacher(em));
    System.out.println(saveTeacher(em));
  }
  private static Teacher getTeacher(EntityManager em){
    return em.find(Teacher.class, 101);
  }
  private static Teacher saveTeacher(EntityManager em){
    Teacher teacher1 = new Teacher(103, "Fatima", "Female", 100);
    em.getTransaction().begin();
    em.persist(teacher1);
    em.getTransaction().commit();
    return teacher1;
  }
}

