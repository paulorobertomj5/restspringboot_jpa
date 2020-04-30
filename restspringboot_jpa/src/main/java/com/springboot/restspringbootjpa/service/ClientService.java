package com.springboot.restspringbootjpa.service;

import com.springboot.restspringbootjpa.data.vo.ClientVO;

import java.util.List;


public interface ClientService {


    ClientVO create(ClientVO person);

    List<ClientVO> findByAll();

    ClientVO findById(Long id);

    ClientVO update(ClientVO person);

    void delete(Long id);

}
