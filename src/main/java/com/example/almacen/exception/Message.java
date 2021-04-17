package com.example.almacen.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

  @JsonProperty("code")
  private String code;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp = LocalDateTime.now();

  public Message(String code, String type, String message) {
    this.code = code;
    this.type = type;
    this.message = message;
  }

}
