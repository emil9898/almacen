package com.example.almacen.client.application;

import com.example.almacen.client.controller.dto.ClientDto;
import com.example.almacen.client.domain.ClientService;
import com.example.almacen.client.mapper.ClientMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientApplication {

  @Autowired
  private ClientService clientService;
  @Autowired
  private ClientMapper clientMapper;

  public List<ClientDto> findAll() {
    return clientMapper.toRest(clientService.findAll());
  }


}
