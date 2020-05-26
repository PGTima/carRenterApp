package com.example.carRental.Controller;

import com.example.carRental.Const.RestControlerConst;
import com.example.carRental.DTO.ResponseDto;
import com.example.carRental.Service.CarsService;
import com.example.carRental.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarsController {

  @Autowired
  private CarsService carsService;

  @GetMapping("all")
  public ResponseEntity<ResponseDto> allCars() {
    List<Car> carsList = carsService.all();
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carsList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("findByNomer")
  public ResponseEntity<ResponseDto> findByNomer(@RequestParam String nomer) {

    if (nomer.isEmpty()){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    Car car = carsService.findByNomer(nomer);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,car);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("carByModelId")
  public ResponseEntity<ResponseDto> carByModelId(@RequestParam Long id) {

    if (id == null){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    List<Car> carList = carsService.carByModelId(id);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @PostMapping("addCar")
  public ResponseEntity<ResponseDto> addCar(@RequestBody Car car) {

    if (car.getModelCar() == null || car.getNomer().isEmpty() ){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    Car car1 = carsService.addCar(car);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT, car1);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("carByModelLike")
  public ResponseEntity<ResponseDto> carByModelLike(@RequestParam String nomer) {

    if (nomer.isEmpty()){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    List<Car> carList = carsService.findByNomerLike(nomer);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,carList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
