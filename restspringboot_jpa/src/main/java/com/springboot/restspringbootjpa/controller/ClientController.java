package com.springboot.restspringbootjpa.controller;

import com.springboot.restspringbootjpa.data.vo.ClientVO;
import com.springboot.restspringbootjpa.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Api(value = "Client API", description = "Client API description", tags = "Client")
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @ApiOperation(value = "findById")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/x-yaml"})
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {

        ClientVO clientVO = service.findById(id);

        if (clientVO != null) {
            clientVO.add(linkTo(methodOn(ClientController.class).findById(id)).withSelfRel());
            return ResponseEntity.status(HttpStatus.OK).body(clientVO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "findByAll")
    @GetMapping(produces = {"application/json", "application/x-yaml"})
    public ResponseEntity<Object> findByAll() {

        List<ClientVO> clientVOs = service.findByAll();

        if (clientVOs != null && clientVOs.size() > 0) {
            clientVOs.stream().forEach(p -> p.add(linkTo(methodOn(ClientController.class).findById(p.getKey())).withSelfRel()));
            return ResponseEntity.status(HttpStatus.OK).body(clientVOs);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "create")
    @PostMapping(produces = {"application/json", "application/x-yaml"}, consumes = {"application/json", "application/x-yaml"})
    public ResponseEntity<Object> create(@Valid @RequestBody ClientVO client) {

        ClientVO clientVO = service.create(client);

        if (clientVO != null) {
            clientVO.add(linkTo(methodOn(ClientController.class).findById(clientVO.getKey())).withSelfRel());
            return ResponseEntity.status(HttpStatus.CREATED).body(clientVO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "update")
    @PutMapping(produces = {"application/json", "application/x-yaml"}, consumes = {"application/json", "application/x-yaml"})
    public ResponseEntity<Object> update(@Valid @RequestBody ClientVO client) {
        ClientVO clientVO = service.update(client);
        if (clientVO != null) {
            clientVO.add(linkTo(methodOn(ClientController.class).findById(clientVO.getKey())).withSelfRel());
            return ResponseEntity.status(HttpStatus.OK).body(clientVO);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @ApiOperation(value = "delete")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
