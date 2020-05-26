package com.example.carRental.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
  private Integer status;
  private String statusCode;
  private String statusText;
  private Object data;

  public static ResponseDto setResponse(Integer status, String statusCode, String statusText, Object data) {
    ResponseDto res = new ResponseDto();
    res.setStatus(status);
    res.setStatusCode(statusCode);
    res.setStatusText(statusText);
    res.setData(data);

    return res;
  }

}
