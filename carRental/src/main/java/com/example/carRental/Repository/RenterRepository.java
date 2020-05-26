package com.example.carRental.Repository;

import com.example.carRental.model.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenterRepository extends JpaRepository<Renter,Long> {
  List<Renter> findByFioContainingIgnoreCase(String fio);
}
