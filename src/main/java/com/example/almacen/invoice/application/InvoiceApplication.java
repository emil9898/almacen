package com.example.almacen.invoice.application;

import com.example.almacen.client.controller.dto.ClientDto;
import com.example.almacen.client.domain.Client;
import com.example.almacen.client.domain.ClientService;
import com.example.almacen.client.mapper.ClientMapper;
import com.example.almacen.exception.BadRequestBusinessException;
import com.example.almacen.invoice.controller.dto.InvoiceDto;
import com.example.almacen.invoice.domain.Invoice;
import com.example.almacen.invoice.domain.InvoiceService;
import com.example.almacen.invoice.mapper.InvoiceMapper;
import com.example.almacen.item.controller.ItemDto;
import com.example.almacen.product.controller.dto.ProductDto;
import com.example.almacen.product.domain.ProductService;
import com.example.almacen.product.mapper.ProductMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceApplication {

  @Autowired
  private InvoiceService invoiceService;

  @Autowired
  private ProductService productService;

  @Autowired
  private InvoiceMapper invoiceMapper;

  @Autowired
  private ProductMapper productMapper;

  @Autowired
  private ClientService clientService;

  @Autowired
  private ClientMapper clientMapper;


  public InvoiceDto save(InvoiceDto invoiceDto) {
    invoiceDto.setId(0);
    invoiceDto.setStatus("ACTIVO");
    invoiceDto.setCode(UUID.randomUUID().toString());
    invoiceDto.setCreationDate(LocalDateTime.now());
    invoiceDto.setItems(loadProduct(invoiceDto.getItems()));
    invoiceDto.setClient(loadClient(invoiceDto.getClient().getCc()));
    return invoiceMapper
        .toRest(invoiceService.save(invoiceMapper.toEntity(calculateValue(invoiceDto))));
  }

  public String delete(String cc) {
    Invoice invoice = invoiceService.findByCode(cc);
    if (invoice == null) {
      throw new BadRequestBusinessException("Registro no encontrado");

    }
    if (!LocalDateTime.now().isBefore(invoice.getCreationDate().plusHours(12))) {
      invoice.setStatus("CANCELADO");
      invoice.setValue(invoice.getValue() * 0.10);
      invoiceService.update(invoice);
      return "pedido CANCELADO";
    } else {
      invoiceService.delete(invoice);
      return "pedido eliminado";
    }
  }

  private ClientDto loadClient(String cc) {
    Client client = clientService.findByCc(cc);
    if (client == null) {
      return clientMapper.toRest(clientService.save(new Client(0, cc)));
    }
    return clientMapper.toRest(client);

  }

  public List<ItemDto> loadProduct(List<ItemDto> items) {

    List<ProductDto> productDtos = productMapper.toRest(productService.findByIds(getCodes(items)));
    for (ItemDto item : items) {
      item.setId(0);
      item.setProductDto(productDtos.stream()
          .filter(producto -> producto.getId().equals(item.getProductDto().getId())).findAny()
          .orElseThrow(() -> new BadRequestBusinessException("producto no encontrado")));
      item.setValue(item.getAmount() * item.getProductDto().getValue());
    }
    return items;
  }


  public List<Integer> getCodes(List<ItemDto> items) {
    return items.stream().map(item -> item.getProductDto().getId()).collect(Collectors.toList());
  }

  private InvoiceDto calculateValue(InvoiceDto invoiceDto) {
    invoiceDto.setShippingValue(5000d);
    invoiceDto.setTax(0d);

    Double netValue = invoiceDto.getItems().stream().mapToDouble(ItemDto::getValue)
        .sum();
    if (netValue > 70000d) {
      invoiceDto.setTax(netValue * 0.19);
    }
    if (netValue > 100000d) {
      invoiceDto.setShippingValue(0d);
    }
    invoiceDto.setValue(invoiceDto.getTax() + invoiceDto.getShippingValue() + netValue);
    return invoiceDto;
  }

  public List<InvoiceDto> findAll() {
    return invoiceMapper.toRest(invoiceService.findAll());
  }

  public InvoiceDto update(InvoiceDto invoiceDto) {
    Invoice found = invoiceService.findByCode(invoiceDto.getCode());
    invoiceDto.setId(found.getId());
    invoiceDto.setClient(clientMapper.toRest(found.getClient()));
    invoiceDto.setCode(found.getCode());
    invoiceDto.setClient(loadClient(invoiceDto.getClient().getCc()));
    invoiceDto.setCreationDate(LocalDateTime.now());
    validateUpdate(found.getCreationDate(), invoiceDto.getCreationDate());
    invoiceDto.setItems(loadProduct(invoiceDto.getItems()));
    invoiceDto = calculateValue(invoiceDto);
    validateValueUpdate(found.getValue(), invoiceDto.getValue());
    return invoiceMapper.toRest(invoiceService.update(invoiceMapper.toEntity(invoiceDto)));
  }

  private void validateUpdate(LocalDateTime dateTimeOld, LocalDateTime dateTimeNew) {
    if (!dateTimeNew.isBefore(dateTimeOld.plusHours(5))) {
      throw new BadRequestBusinessException("No puede editar su pedido despues de 5 horas");
    }
  }

  private void validateValueUpdate(Double valueOld, Double valueNew) {
    if (valueNew < valueOld) {
      throw new BadRequestBusinessException(
          "No puede editar su pedido por un valor menos al original");

    }
  }

  public List<InvoiceDto> findByUser(String cc) {
    return invoiceMapper.toRest(invoiceService.findByUser(cc));
  }
}
