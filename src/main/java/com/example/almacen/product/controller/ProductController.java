package com.example.almacen.product.controller;

import com.example.almacen.product.controller.dto.ProductDto;
import com.example.almacen.product.domain.ProductService;
import com.example.almacen.product.mapper.ProductMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private ProductMapper productMapper;

  @GetMapping
  public List<ProductDto> findAll() {
    return productMapper.toRest(productService.findAll());
  }

}
