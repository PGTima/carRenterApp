package com.example.carRental.Controller;

import com.example.carRental.Const.RestControlerConst;
import com.example.carRental.DTO.ResponseDto;
import com.example.carRental.Service.ModelCarService;
import com.example.carRental.model.CarsHistory;
import com.example.carRental.model.ModelCar;
import com.example.carRental.model.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/modelcar")
public class ModelCarController {
  @Autowired
  private ModelCarService modelCarService;

  @GetMapping("all")
  public ResponseEntity<ResponseDto> allModelCar() {
    List<ModelCar> modelCarList = modelCarService.getAll();
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT, modelCarList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @PostMapping("addModelCar")
  public ResponseEntity<ResponseDto> addModelCar(@RequestBody ModelCar modelCar) {

    if (modelCar.getName().isEmpty()){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    ModelCar modelCar1 = modelCarService.addModelCar(modelCar);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,modelCar1);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
