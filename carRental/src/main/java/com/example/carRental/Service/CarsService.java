package com.example.carRental.Service;

import com.example.carRental.model.Car;

import java.util.List;

public interface CarsService {
  Car addCar(Car car);
  void deleteById(Long id);
  List<Car> carByModelId(Long id);
  Car findByNomer(String nomer);
  Car findById(Long id);
  List<Car> all();
  List<Car> findByNomerLike(String nomer);
}
