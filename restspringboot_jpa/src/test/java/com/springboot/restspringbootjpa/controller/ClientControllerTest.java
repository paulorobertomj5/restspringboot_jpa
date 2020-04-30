package com.springboot.restspringbootjpa.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.restspringbootjpa.data.vo.ClientVO;
import com.springboot.restspringbootjpa.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        ClientController.class
})
public class ClientControllerTest {

    @Autowired
    private ClientController controller;

    @MockBean
    private ClientService clientService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }


    @Test
    public void testFindByAll_Success() throws Exception {

        List<ClientVO> listResponse = new ArrayList<>();
        ClientVO response = new ClientVO();
        response.setKey(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        listResponse.add(response);

        when(clientService.findByAll()).thenReturn(listResponse);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients/")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "1";
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertTrue(jsonResult.contains(expectedKey));
        assertTrue(jsonResult.contains(expectedFistName));
        assertTrue(jsonResult.contains(expectedLastName));
        assertTrue(jsonResult.contains(expectedAddress));
        assertTrue(jsonResult.contains(expectedGender));
    }

    @Test
    public void testFindByAll_Error() throws Exception {

        List<ClientVO> listResponse = new ArrayList<>();
        ClientVO response = new ClientVO();
        response.setKey(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");

        listResponse.add(response);

        when(clientService.findByAll()).thenReturn(listResponse);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients/")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertFalse(jsonResult.contains(expectedKey));
        assertFalse(jsonResult.contains(expectedFistName));
        assertFalse(jsonResult.contains(expectedLastName));
        assertFalse(jsonResult.contains(expectedAddress));
        assertFalse(jsonResult.contains(expectedGender));
    }

    @Test
    public void testFindById_Success() throws Exception {

        ClientVO response = new ClientVO();
        response.setKey(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");


        when(clientService.findById(any())).thenReturn(response);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "1";
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertTrue(jsonResult.contains(expectedKey));
        assertTrue(jsonResult.contains(expectedFistName));
        assertTrue(jsonResult.contains(expectedLastName));
        assertTrue(jsonResult.contains(expectedAddress));
        assertTrue(jsonResult.contains(expectedGender));
    }

    @Test
    public void testFindByid_Error() throws Exception {

        ClientVO response = new ClientVO();
        response.setKey(1L);
        response.setFistName("Paulo");
        response.setLastName("Roberto");
        response.setAddress("Av. Paulista");
        response.setGender("M");


        when(clientService.findById(any())).thenReturn(response);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/clients/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertFalse(jsonResult.contains(expectedKey));
        assertFalse(jsonResult.contains(expectedFistName));
        assertFalse(jsonResult.contains(expectedLastName));
        assertFalse(jsonResult.contains(expectedAddress));
        assertFalse(jsonResult.contains(expectedGender));
    }

    @Test
    public void testCreate_Success() throws Exception {

        ClientVO clientVO = new ClientVO();
        clientVO.setKey(1L);
        clientVO.setFistName("Paulo");
        clientVO.setLastName("Roberto");
        clientVO.setAddress("Av. Paulista");
        clientVO.setGender("M");


        when(clientService.create(any())).thenReturn(clientVO);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/clients/")
                .content(objectMapper.writeValueAsString(clientVO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "1";
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";

        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertTrue(jsonResult.contains(expectedKey));
        assertTrue(jsonResult.contains(expectedFistName));
        assertTrue(jsonResult.contains(expectedLastName));
        assertTrue(jsonResult.contains(expectedAddress));
        assertTrue(jsonResult.contains(expectedGender));

    }

    @Test
    public void testCreate_Error() throws Exception {

        ClientVO clientVO = new ClientVO();
        clientVO.setKey(1L);
        clientVO.setFistName("Paulo");
        clientVO.setFistName("Roberto");
        clientVO.setAddress("Av. Paulista");
        clientVO.setGender("M");


        when(clientService.create(any())).thenReturn(clientVO);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/clients/")
                .content(objectMapper.writeValueAsString(clientVO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertFalse(jsonResult.contains(expectedKey));
        assertFalse(jsonResult.contains(expectedFistName));
        assertFalse(jsonResult.contains(expectedLastName));
        assertFalse(jsonResult.contains(expectedAddress));
        assertFalse(jsonResult.contains(expectedGender));
    }

    @Test
    public void testUpdate_Success() throws Exception {

        ClientVO clientVO = new ClientVO();
        clientVO.setKey(1L);
        clientVO.setFistName("Paulo");
        clientVO.setLastName("Roberto");
        clientVO.setAddress("Av. Paulista");
        clientVO.setGender("M");


        when(clientService.update(any())).thenReturn(clientVO);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/clients/")
                .content(objectMapper.writeValueAsString(clientVO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "1";
        String expectedFistName = "Paulo";
        String expectedLastName = "Roberto";
        String expectedAddress = "Av. Paulista";
        String expectedGender = "M";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertTrue(jsonResult.contains(expectedKey));
        assertTrue(jsonResult.contains(expectedFistName));
        assertTrue(jsonResult.contains(expectedLastName));
        assertTrue(jsonResult.contains(expectedAddress));
        assertTrue(jsonResult.contains(expectedGender));
    }

    @Test
    public void testUpdate_Error() throws Exception {

        ClientVO clientVO = new ClientVO();
        clientVO.setKey(1L);
        clientVO.setFistName("Paulo");
        clientVO.setFistName("Roberto");
        clientVO.setAddress("Av. Paulista");
        clientVO.setGender("M");


        when(clientService.update(any())).thenReturn(clientVO);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/clients/")
                .content(objectMapper.writeValueAsString(clientVO))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedKey = "2";
        String expectedFistName = "João";
        String expectedLastName = "Maroa";
        String expectedAddress = "Av. Faria Lima";
        String expectedGender = "G";


        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();

        assertFalse(jsonResult.contains(expectedKey));
        assertFalse(jsonResult.contains(expectedFistName));
        assertFalse(jsonResult.contains(expectedLastName));
        assertFalse(jsonResult.contains(expectedAddress));
        assertFalse(jsonResult.contains(expectedGender));
    }

}
