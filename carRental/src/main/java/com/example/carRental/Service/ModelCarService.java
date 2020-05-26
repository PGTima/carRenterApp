package com.example.carRental.Service;

import com.example.carRental.model.ModelCar;

import java.util.List;

public interface ModelCarService {
  ModelCar addModelCar(ModelCar modelCar);
  List<ModelCar> getAll();
}
