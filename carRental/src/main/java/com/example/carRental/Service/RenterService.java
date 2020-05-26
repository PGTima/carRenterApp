package com.example.carRental.Service;

import com.example.carRental.model.Renter;

import java.util.List;

public interface RenterService {
  List<Renter> getAll();
  Renter findById(Long id);
  Renter addRenter(Renter renter);
  void detetedRenter(Long id);
  List<Renter> findByFioContainingIgnoreCase(String fio);
}
