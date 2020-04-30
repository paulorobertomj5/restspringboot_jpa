package com.springboot.restspringbootjpa.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.restspringbootjpa.data.model.Client;
import com.springboot.restspringbootjpa.repository.ClientRepository;
import com.springboot.restspringbootjpa.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        ClientServiceImpl.class
})
public class ClientServiceTest {


    @MockBean
    private ClientRepository clientRepository;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(clientRepository)
                .build();
    }

    @Test
    public void testFindByAll_Success() throws Exception {

        List<Client> listResponse = new ArrayList<>();
        Client response = new Client();
        response.setId(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        listResponse.add(response);
        listResponse.add(response);

        when(clientRepository.findAll()).thenReturn(listResponse);

        assertEquals(2, listResponse.size());
    }

    @Test
    public void testFindByAll_Error() throws Exception {

        List<Client> listResponse = new ArrayList<>();
        Client response = new Client();
        response.setId(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        listResponse.add(response);
        listResponse.add(response);

        when(clientRepository.findAll()).thenReturn(listResponse);

        assertNotEquals(1, listResponse.size());
    }

    @Test
    public void testFindById_Success() throws Exception {

        Client response = new Client();
        response.setId(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        when(clientRepository.findById(any())).thenReturn(java.util.Optional.of(response));

        Long expectedKey = 1L;
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";

        assertEquals(response.getId(), expectedKey);
        assertEquals(response.getFistName(), expectedFistName);
        assertEquals(response.getLastName(), expectedLastName);
        assertEquals(response.getAddress(), expectedAddress);
        assertEquals(response.getGender(), expectedGender);

    }

    @Test
    public void testFindByid_Error() throws Exception {

        Client response = new Client();
        response.setId(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        when(clientRepository.findById(any())).thenReturn(java.util.Optional.of(response));

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";

        assertNotEquals(response.getId(), expectedKey);
        assertNotEquals(response.getFistName(), expectedFistName);
        assertNotEquals(response.getLastName(), expectedLastName);
        assertNotEquals(response.getAddress(), expectedAddress);
        assertNotEquals(response.getGender(), expectedGender);
    }

    @Test
    public void testCreate_Success() throws Exception {

        Client player = new Client();
        player.setId(1L);
        player.setFistName("Paulo");
        player.setLastName("Roberto");
        player.setAddress("Av. Paulista");
        player.setGender("M");

        when(clientRepository.save(any())).thenReturn(java.util.Optional.of(player));

        Long expectedKey = 1L;
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";

        assertEquals(player.getId(), expectedKey);
        assertEquals(player.getFistName(), expectedFistName);
        assertEquals(player.getLastName(), expectedLastName);
        assertEquals(player.getAddress(), expectedAddress);
        assertEquals(player.getGender(), expectedGender);

    }

    @Test
    public void testCreate_Error() throws Exception {

        Client player = new Client();
        player.setId(1L);
        player.setFistName("Paulo");
        player.setFistName("Roberto");
        player.setAddress("Av. Paulista");
        player.setGender("M");

        when(clientRepository.save(any())).thenReturn(java.util.Optional.of(player));

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";

        assertNotEquals(player.getId(), expectedKey);
        assertNotEquals(player.getFistName(), expectedFistName);
        assertNotEquals(player.getLastName(), expectedLastName);
        assertNotEquals(player.getAddress(), expectedAddress);
        assertNotEquals(player.getGender(), expectedGender);
    }

    @Test
    public void testUpdate_Success() throws Exception {

        Client player = new Client();
        player.setId(1L);
        player.setFistName("Paulo");
        player.setLastName("Roberto");
        player.setAddress("Av. Paulista");
        player.setGender("M");

        when(clientRepository.save(any())).thenReturn(player);

        Long expectedKey = 1L;
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";

        assertEquals(player.getId(), expectedKey);
        assertEquals(player.getFistName(), expectedFistName);
        assertEquals(player.getLastName(), expectedLastName);
        assertEquals(player.getAddress(), expectedAddress);
        assertEquals(player.getGender(), expectedGender);
    }

    @Test
    public void testUpdate_Error() throws Exception {

        Client player = new Client();
        player.setId(1L);
        player.setFistName("Paulo");
        player.setFistName("Roberto");
        player.setAddress("Av. Paulista");
        player.setGender("M");


        when(clientRepository.save(any())).thenReturn(player);

        Long expectedKey = 2L;
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";

        assertNotEquals(player.getId(), expectedKey);
        assertNotEquals(player.getFistName(), expectedFistName);
        assertNotEquals(player.getLastName(), expectedLastName);
        assertNotEquals(player.getAddress(), expectedAddress);
        assertNotEquals(player.getGender(), expectedGender);

    }

}
