package com.example.carRental.Service.Impl;

import com.example.carRental.Repository.CarRepository;
import com.example.carRental.Service.CarsService;
import com.example.carRental.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarsServiceImpl implements CarsService {

  @Autowired
  CarRepository carRepository;

  @Override
  public Car addCar(Car car) {
    Car car1 = carRepository.save(car);
    log.info("addCar get car: {}", car1);
    return car1;
  }

  @Override
  public void deleteById(Long id) {
    carRepository.deleteById(id);
    log.info("deleteById car with id: {}", id);
  }

  @Override
  public List<Car> carByModelId(Long id) {
    List<Car> carList = carRepository.findByModelCarId(id);
    log.info("carByModelId car with  model_id: {}", id);
    return carList;
  }

  @Override
  public Car findByNomer(String nomer) {
    Car car = carRepository.findByNomer(nomer);
    log.info("findByNomer car with nomer : {}", nomer);
    return car;
  }

  @Override
  public Car findById(Long id) {
    Car car = carRepository.findById(id).orElse(null);
    log.info("findById car with id : {}", id);
    return car;
  }

  @Override
  public List<Car> all() {
    List<Car> carList = carRepository.findAll();
    log.info("all carList with size : {}", carList.size());
    return carList;
  }

  @Override
  public List<Car> findByNomerLike(String nomer) {
    List<Car> carList = carRepository.findByNomerContainingIgnoreCase(nomer);
    log.info("findByNomerLike carList with size : {}", carList.size());
    return carList;
  }
}
