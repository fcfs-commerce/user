package com.sparta.userservice.global.exception.handler;

import com.sparta.userservice.global.dto.ApiResponse;
import com.sparta.userservice.global.exception.CustomException;
import com.sparta.userservice.global.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ApiResponse> handleException(CustomException e) {
    log.info("예외 발생 : {}, {}, {}", e, e.getStatus(), e.getMessage());
    ApiResponse apiResponse = ApiResponseUtil.createExceptionResponse(e.getStatus(), e.getMessage());
    return ResponseEntity.status(e.getStatus()).body(apiResponse);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse> handleException( MethodArgumentNotValidException e,
      HttpServletRequest request) {
    log.info("유효성 검증 실패");
    HttpStatus status = HttpStatus.BAD_REQUEST;
    String errorMessage = fieldErrorMessage(e);
    ApiResponse apiResponse = ApiResponseUtil.createExceptionResponse(status, errorMessage);
    return ResponseEntity.status(status).body(apiResponse);
  }

  private String fieldErrorMessage(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    StringBuilder errorMessage = new StringBuilder();
    for (FieldError fieldError : fieldErrors) {
      errorMessage.append("{")
          .append(fieldError.getField())
          .append(" : ")
          .append(fieldError.getDefaultMessage())
          .append("}, ");
    }
    return errorMessage.toString();
  }

}
