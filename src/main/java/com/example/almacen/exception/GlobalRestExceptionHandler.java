package com.example.almacen.exception;

import com.example.almacen.util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalRestExceptionHandler {

  @ExceptionHandler(ErrorException.class)
  public ResponseEntity<ApiError> resolveErrorException(HttpServletRequest request,
      HttpServletResponse response, ErrorException e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ApiError.builder().code(e.getCode()).message(e.getMessage()).build());
  }

  @ExceptionHandler(RestException.class)
  public ResponseEntity<ApiError> resolveRestException(HttpServletRequest request,
      HttpServletResponse response, RestException e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.status(e.getStatus()).body(
        ApiError.builder().code(e.getCode()).message(e.getMessage()).errors(e.getErrors()).build());
  }

  @ExceptionHandler(BadRequestBusinessException.class)
  public ResponseEntity<ApiError> academicCoreBadRequestBusinessException(
      HttpServletRequest request,
      HttpServletResponse response, BadRequestBusinessException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ApiError.builder().code(Constants.CODE_EXCEPTION_BADREQUEST)
            .type(Constants.MESSAGE_EXCEPTION_BUSINESS_VALIDATION).message(e.getMessage())
            .build());
  }


}