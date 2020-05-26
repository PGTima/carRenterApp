package com.example.carRental.Repository;

import com.example.carRental.model.CarsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarsHistoryRepository extends JpaRepository<CarsHistory,Long> {
  @Query(
    value = "select distinct mc.model_name,\n" +
      "        sum(date_part('day',(r.date_to -  r.date_from )))over (partition by c.model_car_id) as result \n" +
      "from cars_history r,\n" +
      "     cars c,\n" +
      "     model_car mc\n" +
      "\t where c.id = r.car_id\n" +
      "\t and   mc.id = c.model_car_id",
    nativeQuery = true)
  List<String> getTimeForRentetModelCar();
  List<CarsHistory> findByRenterId(Long id);
  List<CarsHistory> findByCarId(Long id);
  List<CarsHistory> findByDateFrom(Date dateFrom);
  List<CarsHistory> findByDateTo(Date dateTo);

}
