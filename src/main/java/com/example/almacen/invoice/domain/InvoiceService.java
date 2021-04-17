package com.example.almacen.invoice.domain;

import java.util.List;

public interface InvoiceService {

  Invoice findByCode(String code);

  Invoice save(Invoice invoice);

  void delete(Invoice invoice);

  Invoice update(Invoice invoice);

  List<Invoice> findAll();

  List<Invoice> findByUser(String cc);

}
