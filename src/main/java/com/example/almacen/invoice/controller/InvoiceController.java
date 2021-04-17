package com.example.almacen.invoice.controller;

import com.example.almacen.invoice.application.InvoiceApplication;
import com.example.almacen.invoice.controller.dto.InvoiceDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

  @Autowired
  private InvoiceApplication invoiceApplication;

  @PostMapping
  public InvoiceDto save(@RequestBody InvoiceDto invoiceDto) {
    return invoiceApplication.save(invoiceDto);
  }

  @GetMapping
  public List<InvoiceDto> findAll() {
    return invoiceApplication.findAll();
  }

  @PutMapping
  public InvoiceDto update(@RequestBody InvoiceDto invoiceDto) {
    return invoiceApplication.update(invoiceDto);
  }

  @DeleteMapping
  public String delete(String cc) {
    return invoiceApplication.delete(cc);
  }

  @GetMapping("/user/{cc}")
  public List<InvoiceDto> findByUser(@PathVariable String cc) {
    return invoiceApplication.findByUser(cc);
  }
}
