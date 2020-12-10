package com.init.products.dao;

import com.init.products.entitys.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsDAO extends JpaRepository<Clients, Long> {
}
