package com.example.almacen.product.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(Integer id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> findByIds(List<Integer> id) {
    return productRepository.findAllById(id);
  }
}
