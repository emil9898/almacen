package com.example.almacen.client.mapper;

import com.example.almacen.client.controller.dto.ClientDto;
import com.example.almacen.client.domain.Client;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  Client toEntity(ClientDto invoiceDto);


  ClientDto toRest(Client invoice);

  List<Client> toEntity(List<ClientDto> invoiceDto);

  List<ClientDto> toRest(List<Client> invoice);
}
