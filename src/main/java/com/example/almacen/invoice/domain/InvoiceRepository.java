package com.example.almacen.invoice.domain;

import com.example.almacen.client.domain.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

  Invoice findByCode(String code);

  List<Invoice> findByClient(Client client);

}
