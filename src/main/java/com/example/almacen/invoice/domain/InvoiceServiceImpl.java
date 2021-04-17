package com.example.almacen.invoice.domain;


import com.example.almacen.client.domain.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public Invoice findByCode(String code) {
    return invoiceRepository.findByCode(code);
  }

  @Override
  public Invoice save(Invoice invoice) {
    return invoiceRepository.save(invoice);

  }

  @Override
  public void delete(Invoice invoice) {
    invoiceRepository.delete(invoice);
  }


  @Override
  public Invoice update(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  @Override
  public List<Invoice> findAll() {
    return invoiceRepository.findAll();
  }

  @Override
  public List<Invoice> findByUser(String cc) {
    return invoiceRepository.findByClient(clientRepository.findByCc(cc));
  }


}
