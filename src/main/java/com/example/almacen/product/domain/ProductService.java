package com.example.almacen.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  List<Product> findAll();

  Optional<Product> findById(Integer id);

  List<Product> findByIds(List<Integer> id);

}
