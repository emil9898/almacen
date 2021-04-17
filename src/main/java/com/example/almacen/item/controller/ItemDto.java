package com.example.almacen.item.controller;

import com.example.almacen.product.controller.dto.ProductDto;
import lombok.Data;

@Data
public class ItemDto {

  private Integer id;
  private ProductDto productDto;
  private Integer amount;
  private Double value;
}
