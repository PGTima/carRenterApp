package com.example.carRental.Service.Impl;

import com.example.carRental.Repository.ModelCarRepository;
import com.example.carRental.Service.ModelCarService;
import com.example.carRental.model.ModelCar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ModelCarServiceImpl implements ModelCarService {
  @Autowired
  ModelCarRepository modelCarRepository;
  @Override
  public ModelCar addModelCar(ModelCar modelCar) {
    ModelCar modelCar1 = modelCarRepository.save(modelCar);
    log.info("addModelCar add modelCar: {} ", modelCar1);
    return modelCar1;
  }

  @Override
  public List<ModelCar> getAll() {
    List<ModelCar> modelCarList = modelCarRepository.findAll();
    log.info("getAll list modelCar size: {} ", modelCarList.size());
    return modelCarList;
  }
}
