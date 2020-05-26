package com.example.carRental.Service;

import com.example.carRental.model.CarsHistory;

import java.util.Date;
import java.util.List;

public interface CarsHistoryService {
  List<CarsHistory> getAll();
  CarsHistory addCarsHistory(CarsHistory carsHistory);
  List<CarsHistory> findByRenterId(Long id);
  List<CarsHistory> findByCarId(Long id);
  List<CarsHistory> findByDateFrom(Date dateFrom);
  List<CarsHistory> findByDateTo(Date dateTo);
  List<String> getTimeForRentetModelCar();
}
