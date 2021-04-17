package com.example.almacen.invoice.domain;

import com.example.almacen.client.domain.Client;
import com.example.almacen.item.domain.Item;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String code;
  @OneToOne
  private Client client;
  private String direction;
  private Double value;
  private Double tax;
  private Double shippingValue;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Item> items;
  private LocalDateTime creationDate;
  private String status;
}
