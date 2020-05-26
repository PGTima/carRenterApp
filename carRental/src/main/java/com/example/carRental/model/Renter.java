package com.example.carRental.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "renter")
@Data
public class Renter {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "patronymic")
  private String patronymic;

  @Column(name = "fio")
  private String fio;

}
