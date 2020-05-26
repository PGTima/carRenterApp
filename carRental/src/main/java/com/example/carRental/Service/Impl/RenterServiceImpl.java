package com.example.carRental.Service.Impl;

import com.example.carRental.Repository.RenterRepository;
import com.example.carRental.Service.RenterService;
import com.example.carRental.model.Renter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RenterServiceImpl implements RenterService {

  @Autowired
  RenterRepository renterRepository;

  @Override
  public List<Renter> getAll() {
    List<Renter> renterList = renterRepository.findAll();
    log.info("Find list size {} rentor for cars", renterList.size());
    return renterList;
  }

  @Override
  public Renter findById(Long id) {
    Renter renter = renterRepository.findById(id).orElse(null);
    log.info("findById renter {}  for cars", renter);
    return renter;
  }

  @Override
  public Renter addRenter(Renter renter) {
    renter.setFio(renter.getSurname() + " " + renter.getName() + " " + renter.getPatronymic());
    Renter renter1 = renterRepository.save(renter);
    log.info("addRenter renter: {} , succesfully", renter1);
    return renter1;
  }

  @Override
  public void detetedRenter(Long id) {
    renterRepository.deleteById(id);
    log.info("detetedRenter renter by id: {} , succesfully deleted", id);
  }

  @Override
  public List<Renter> findByFioContainingIgnoreCase(String fio) {
    List<Renter> renterList = renterRepository.findByFioContainingIgnoreCase(fio);
    log.info("findByFioContainingIgnoreCase renterList size {} ", renterList.size());
    return renterList;
  }

}
