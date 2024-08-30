package com.sparta.userservice.global.exception.handler.dto;

import com.sparta.userservice.global.exception.CustomException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionResponse {

  private HttpStatus status;
  private String message;

  public static ExceptionResponse from(CustomException e) {
    return ExceptionResponse.builder()
        .status(e.getStatus())
        .message(e.getMessage())
        .build();
  }

  public static ExceptionResponse of(HttpStatus status, String errorMessage) {
    return ExceptionResponse.builder()
        .status(status)
        .message(errorMessage)
        .build();
  }
}
