package com.example.carRental.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "model_car")
@Data
public class ModelCar {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "model_name", nullable = false , unique = true)
  private String name;
}
