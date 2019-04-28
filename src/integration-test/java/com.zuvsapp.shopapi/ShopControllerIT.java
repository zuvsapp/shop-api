package com.zuvsapp.shopapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ShopControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET - SUCCESS - OK STATUS CODE - WITH SHOP DATA: If a shop is found, tests that " +
        "the controller responds with OK and the shop data")
    void testControllerStatusOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/shop/1")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.id").value("1"))
            .andExpect(jsonPath("$.country").value("Wales"))
            .andExpect(jsonPath("$.city").value("Swansea"))
            .andExpect(jsonPath("$.size").value("small"));
    }

    @Test
    @DisplayName("GET - NOT FOUND STATUS CODE - WITH NO DATA: If a shop is not found, tests that " +
        "the controller responds with not found and no response body")
    void testControllerStatusNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/shop/0")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound());
    }
}