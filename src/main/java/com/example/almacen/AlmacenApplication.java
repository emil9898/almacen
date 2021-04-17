package com.example.almacen;

import com.example.almacen.product.domain.Product;
import com.example.almacen.product.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AlmacenApplication {

  @Autowired
  ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(AlmacenApplication.class, args);
  }

  @Bean
  public void loadProduct() {
    Product product = new Product(1, "telefono", (double) 100000);
    productRepository.save(product);
    Product product2 = new Product(2, "TV", (double) 70000);
    productRepository.save(product2);
    Product product3 = new Product(3, "coca-cala", (double) 10000);
    productRepository.save(product3);

  }


}
