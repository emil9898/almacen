package com.example.almacen.client.controller;

import com.example.almacen.client.application.ClientApplication;
import com.example.almacen.client.controller.dto.ClientDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

  @Autowired
  private ClientApplication clientApplication;

  @GetMapping
  public List<ClientDto> findAll() {
    return clientApplication.findAll();
  }

}
