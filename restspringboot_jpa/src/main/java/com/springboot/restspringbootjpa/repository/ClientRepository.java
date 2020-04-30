package com.springboot.restspringbootjpa.repository;

import com.springboot.restspringbootjpa.data.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
