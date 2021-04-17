package com.example.almacen.invoice.controller.dto;

import com.example.almacen.client.controller.dto.ClientDto;
import com.example.almacen.item.controller.ItemDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class InvoiceDto {

  private Integer id;
  private String code;
  private ClientDto client;
  private String direction;
  private Double value;
  private Double tax;
  private Double shippingValue;
  private List<ItemDto> items;
  private LocalDateTime creationDate;
  private String status;

}
