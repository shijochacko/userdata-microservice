package com.restexample.userdata.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restexample.userdata.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private  MockMvc mockMvc = null;
    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void should_verify_create_user_api_valid_input() throws Exception {
        String uri = "/api/create-user";
        User create_user = new User(1,"test_user","HealthCare","");
        String jsonInString = mapper.writeValueAsString(create_user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonInString)).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }



    @Test
    public void should_verify_create_user_api_call_with_invalid_input() throws Exception {
        String uri = "/api/create-user";
        User create_user = new User(1,null,"HealthCare","");
        String userJson = mapper.writeValueAsString(create_user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(userJson)).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    public void should_verify_get_user_api_valid_input() throws Exception {
        String uri = "/api/user/1";
        User load_user = new User(1,"first_user","IT","");
        loadUserData(load_user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void should_verify_get_user_api_invalid_input() throws Exception {
        String uri = "/api/user/2";
        User load_user = new User(1,"first_user","IT","");
        loadUserData(load_user);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
    }

    public void loadUserData(User user) throws Exception{

        String uri = "/api/create-user";
        String jsonInString = mapper.writeValueAsString(user);
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonInString)).andReturn();
    }
}
