package com.example.almacen.client.domain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Client save(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public Client findByCc(String cc) {
    return clientRepository.findByCc(cc);
  }

  @Override
  public Client update(Client client) {
    return clientRepository.save(client);
  }

}
