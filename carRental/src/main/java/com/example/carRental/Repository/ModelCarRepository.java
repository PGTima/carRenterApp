package com.example.carRental.Repository;

import com.example.carRental.model.ModelCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelCarRepository extends JpaRepository<ModelCar,Long> {
}
