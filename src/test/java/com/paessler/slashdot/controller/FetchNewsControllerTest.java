package com.paessler.slashdot.controller;

import com.paessler.slashdot.factory.DomainFactory;
import com.paessler.slashdot.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.InputMismatchException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FetchNewsController.class)
class FetchNewsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private NewsService newsService;

    @Test
    void getNewsByYear_Test_Success() throws Exception {

        when(newsService.filterationDate(any(Optional.class))).thenReturn(DomainFactory.getNewsContent());
        mockMvc.perform(get("/api/news/2015")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void getNewsByYear_Test_Success_WithEmptyValue() throws Exception {

        when(newsService.filterationDate(any(Optional.class))).thenReturn(DomainFactory.getNewsContent());
        mockMvc.perform(get("/api/news/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void getNewsByYear_Test_Failure() throws Exception {
        when(newsService.filterationDate(any(Optional.class))).thenThrow(new InputMismatchException(String.format("Please enter a valid year %s","xxxx")));
        mockMvc.perform(get("/api/news/xxxx")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.status").exists());
    }


}