package com.example.carRental.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cars")
@Data
public class Car {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "model_car_id", nullable = false)
  private ModelCar modelCar;

  @Column(name = "nomer", unique = true, nullable = false)
  private String nomer;
}
