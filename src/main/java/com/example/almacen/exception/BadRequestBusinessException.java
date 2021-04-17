package com.example.almacen.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestBusinessException extends RuntimeException {

  public BadRequestBusinessException(String message) {
    super(message);
  }

}
