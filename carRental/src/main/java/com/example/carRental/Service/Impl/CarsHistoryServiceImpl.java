package com.example.carRental.Service.Impl;

import com.example.carRental.Repository.CarsHistoryRepository;
import com.example.carRental.Service.CarsHistoryService;
import com.example.carRental.model.CarsHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CarsHistoryServiceImpl implements CarsHistoryService {

  @Autowired
  private CarsHistoryRepository carsHistoryRepository;

  @Override
  public List<CarsHistory> getAll() {
    List<CarsHistory> carsHistoryList = carsHistoryRepository.findAll();
    log.info("Find list size {} rent cars", carsHistoryList.size());
    return carsHistoryList;
  }

  @Override
  public CarsHistory addCarsHistory(CarsHistory carsHistory) {
    carsHistory.setDateFrom(new Date());
    if (carsHistory.getDateFrom().compareTo(carsHistory.getDateTo()) == 0 || carsHistory.getDateFrom().compareTo(carsHistory.getDateTo()) > 0 ){
      log.error("Find carsHistory  dateFrom>=dateTo, {} ,{}", carsHistory.getDateFrom(),carsHistory.getDateTo());
    }
    CarsHistory carsHistory1 = carsHistoryRepository.save(carsHistory);
    log.info("addCarsHistory CarsHistory add: {}", carsHistory1);
    return carsHistory1;
  }

  @Override
  public List<CarsHistory> findByRenterId(Long id) {
    List<CarsHistory> carsHistoryList = carsHistoryRepository.findByRenterId(id);
    log.info("findByRenterId rentor with id: {}; size List: {}", id,carsHistoryList.size());
    return carsHistoryList;
  }

  @Override
  public List<CarsHistory> findByCarId(Long id) {
    List<CarsHistory> carsHistoryList = carsHistoryRepository.findByCarId(id);
    log.info("findByCarId car with id: {}; size List: {}", id, carsHistoryList.size());
    return carsHistoryList;
  }

  @Override
  public List<CarsHistory> findByDateFrom(Date dateFrom) {
    List<CarsHistory> carsHistoryList = carsHistoryRepository.findByDateFrom(dateFrom);
    log.info("findByDateFrom DateFrom with date: {}; size List: {}", dateFrom, carsHistoryList.size());
    return carsHistoryList;
  }

  @Override
  public List<CarsHistory> findByDateTo(Date dateTo) {
    List<CarsHistory> carsHistoryList = carsHistoryRepository.findByDateTo(dateTo);
    log.info("findByDateTo dateTo with date: {}; size List: {}", dateTo, carsHistoryList.size());
    return carsHistoryList;
  }

  @Override
  public List<String> getTimeForRentetModelCar() {
    List<String> modelDlit = carsHistoryRepository.getTimeForRentetModelCar();
    return modelDlit;
  }

}
