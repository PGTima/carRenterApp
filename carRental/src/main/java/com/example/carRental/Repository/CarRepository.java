package com.example.carRental.Repository;

import com.example.carRental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  Car findByNomer(String nomer);
  List<Car> findByModelCarId(Long id);
  List<Car> findByNomerContainingIgnoreCase(String nomer);
}
