package com.example.almacen.invoice.mapper;

import com.example.almacen.invoice.controller.dto.InvoiceDto;
import com.example.almacen.invoice.domain.Invoice;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

  Invoice toEntity(InvoiceDto invoiceDto);


  InvoiceDto toRest(Invoice invoice);


  List<Invoice> toEntity(List<InvoiceDto> invoiceDtos);


  List<InvoiceDto> toRest(List<Invoice> invoices);

}
