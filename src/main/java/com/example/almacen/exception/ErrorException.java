package com.example.almacen.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorException extends RuntimeException {

  public static final String DEFAULT_ERROR_CODE = "ERROR";

  private String code;

  public ErrorException(String message) {
    this(message, DEFAULT_ERROR_CODE);
  }

  public ErrorException(String message, String code) {
    super(message);
    this.code = code;
  }

  public ErrorException(String message, Throwable cause) {
    this(message, cause, DEFAULT_ERROR_CODE);
  }

  public ErrorException(String message, Throwable cause, String code) {
    super(message, cause);
    this.code = code;
  }

}
