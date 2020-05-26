package com.example.carRental.Controller;

import com.example.carRental.Const.RestControlerConst;
import com.example.carRental.DTO.ResponseDto;
import com.example.carRental.Service.RenterService;
import com.example.carRental.model.Car;
import com.example.carRental.model.ModelCar;
import com.example.carRental.model.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/renter")
public class RenterController {
  @Autowired
  private RenterService renterService;

  @GetMapping("all")
  public ResponseEntity<ResponseDto> allRenter() {
    List<Renter> renterList = renterService.getAll();
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT, renterList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @PostMapping("addRenter")
  public ResponseEntity<ResponseDto> addRenter(@RequestBody Renter renter) {

    if (renter.getName().isEmpty()|| renter.getSurname().isEmpty()){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    Renter renter1 = renterService.addRenter(renter);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT,renter1);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }

  @GetMapping("getById")
  public ResponseEntity<ResponseDto> getById(@RequestParam Long id) {

    if (id == null){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    Renter renter = renterService.findById(id);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT, renter);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
  @GetMapping("getByFio")
  public ResponseEntity<ResponseDto> getByFio(@RequestParam String fio) {

    if (fio.isEmpty()){
      ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.ERROR_STATUS, RestControlerConst.NULL_PARAMS, RestControlerConst.NULL_PARAMS_TEXT,null);
      return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    List<Renter> renterList = renterService.findByFioContainingIgnoreCase(fio);
    ResponseDto responseDto = ResponseDto.setResponse(RestControlerConst.SUCCESS_STATUS, RestControlerConst.SUCCESS, RestControlerConst.SUCCESS_TEXT, renterList);
    return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
  }
}
