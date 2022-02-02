package com.example.relaciones;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

@AutoConfigureMockMvc()
@TestPropertySource(locations = { "classpath:application-test.properties" })
@SpringBootTest(classes = { RelacionesApplication.class })
@ActiveProfiles("test")
public class RelacionesTestConfiguration {

    @Autowired
    protected MockMvc mockMvc;

    protected final ObjectMapper MAPPER;

    protected final MediaType JSON = MediaType.APPLICATION_JSON;

    public RelacionesTestConfiguration() {
        MAPPER = new ObjectMapper();
    }
}
