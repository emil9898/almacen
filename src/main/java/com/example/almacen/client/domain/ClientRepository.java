package com.example.almacen.client.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

  Client findByCc(String cc);
}
