package com.springboot.restspringbootjpa.service.impl;

import com.springboot.restspringbootjpa.converter.DozerConverter;
import com.springboot.restspringbootjpa.data.model.Client;
import com.springboot.restspringbootjpa.data.vo.ClientVO;
import com.springboot.restspringbootjpa.exception.ResourceNotFoundException;
import com.springboot.restspringbootjpa.repository.ClientRepository;
import com.springboot.restspringbootjpa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientVO create(ClientVO client) {
        var entity = DozerConverter.parseObject(client, Client.class);
        if(entity != null) {
            return DozerConverter.parseObject(repository.save(entity), ClientVO.class);
        }else{
            return null;
        }
    }

    public List<ClientVO> findByAll() {
        var list = repository.findAll();
        if(list != null && !list.isEmpty()) {
            return DozerConverter.parseListObject(repository.findAll(), ClientVO.class);
        }else{
            return  null;
        }
    }

    public ClientVO findById(Long id) {
        var entity = repository.findById(id);
        if(entity != null && !entity.isEmpty()) {
            return DozerConverter.parseObject(entity, ClientVO.class);
        }else{
            return null;
        }
    }

    public ClientVO update(ClientVO client) {
        var entity = repository.findById(client.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFistName(client.getFistName());
        entity.setLastName(client.getLastName());
        entity.setAddress(client.getAddress());
        entity.setGender(client.getGender());
        if(entity != null) {
            return DozerConverter.parseObject(repository.save(entity), ClientVO.class);
        }else{
            return null;
        }
    }

    public void delete(Long id) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
