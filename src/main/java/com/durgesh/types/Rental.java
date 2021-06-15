package com.durgesh.types;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Rental {
  @Id
  private int rental_id;
  private Date rental_date;
  private int inventory_id;
  private int customer_id;
  private Date return_date;
  private int staff_id;
  private Date last_update;
  
  public Rental (){}


  public Rental(int rental_id, Date rental_date, int inventory_id, int customer_id, Date return_date, int staff_id,
      Date last_update) {
    this.rental_id = rental_id;
    this.rental_date = rental_date;
    this.inventory_id = inventory_id;
    this.customer_id = customer_id;
    this.return_date = return_date;
    this.staff_id = staff_id;
    this.last_update = last_update;
  }

  @Override
  public String toString() {
    return "Rental : { " + rental_id + " : " + rental_date + " : " + inventory_id + " : " + customer_id + " : " + return_date + " : " + staff_id + " : " + last_update + " }";
  }
}
