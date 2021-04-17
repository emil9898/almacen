package com.example.almacen.client.domain;

import java.util.List;

public interface ClientService {

  List<Client> findAll();

  Client save(Client client);

  Client findByCc(String cc);

  Client update(Client client);

}
