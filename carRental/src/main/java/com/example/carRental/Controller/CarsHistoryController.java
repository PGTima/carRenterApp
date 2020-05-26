package com.example.carRental.Controller;

import com.example.carRental.Const.RestControlerConst;
import com.example.carRental.DTO.ResponseDto;
import com.example.carRental.Service.CarsHistoryService;
import com.example.carRental.model.CarsHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/historyCarsRented")
public class CarsHistoryController {
  @Autowired
  private CarsHistoryService carsHistoryService;

  @GetMapping("all")
  public ResponseEntity<ResponseDto> allHistoryCarsRented() {
    List<CarsHistory> carsHistoryList = carsHistoryService.getAll();
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carsHistoryList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
  @GetMapping("getTimeForRentetModelCar")
  public ResponseEntity<ResponseDto> getTimeForRentetModelCar() {
    List<String> modelDlit = carsHistoryService.getTimeForRentetModelCar();
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,modelDlit);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
  @PostMapping("addHistoryCarsRented")
  public ResponseEntity<ResponseDto> addHistoryCarsRented(@RequestBody CarsHistory carsHistory) {

    if (carsHistory.getDateTo() == null || carsHistory.getRenter() == null || carsHistory.getCar() == null){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    if (carsHistory.getDateFrom().compareTo(carsHistory.getDateTo()) == 0 || carsHistory.getDateFrom().compareTo(carsHistory.getDateTo()) > 0 ){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.DATE_TO_ERROR, RestControlerConst.DATE_TO_ERROR_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    CarsHistory carsHistory1 = carsHistoryService.addCarsHistory(carsHistory);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carsHistory1);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("getHistoryByRenter")
  public ResponseEntity<ResponseDto> getHistoryByRenter(@RequestParam Long id) {
    List<CarsHistory> carsHistoryList = carsHistoryService.findByRenterId(id);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carsHistoryList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("getHistoryByCarId")
  public ResponseEntity<ResponseDto> getHistoryByCarId(@RequestParam Long id) {
    List<CarsHistory> carsHistoryList = carsHistoryService.findByCarId(id);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carsHistoryList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
