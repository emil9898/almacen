package com.example.almacen.product.mapper;

import com.example.almacen.product.controller.dto.ProductDto;
import com.example.almacen.product.domain.Product;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {


  Product toEntity(ProductDto productDto);


  ProductDto toRest(Product product);


  List<Product> toEntity(List<ProductDto> productDto);


  List<ProductDto> toRest(List<Product> product);
}
