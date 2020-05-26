package com.example.carRental.model;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cars_history")
@Data
public class CarsHistory {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "car_id", nullable = false)
  private Car car;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private Renter renter;

  @Column(name = "date_from")
  private Date dateFrom;

  @Column(name = "date_to")
  private Date dateTo;

}

