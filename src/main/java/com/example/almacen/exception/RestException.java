package com.example.almacen.exception;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestException extends ErrorException {

  private List errors;

  private HttpStatus status;

  public RestException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public RestException(String message, List errors, HttpStatus status) {
    super(message);
    this.errors = errors;
    this.status = status;
  }
}
