package com.paessler.slashdot.service;

import com.paessler.slashdot.factory.DomainFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

class NewsServiceTest {

    @InjectMocks
    private NewsService newsService;
    @Mock
    private FetchNews fetchNews;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        reset(fetchNews);
    }

    @Test
    void filtrationDate_Success() {
       when(fetchNews.extractNews(anyString())).thenReturn(DomainFactory.getNewsContent());
        assertThat(newsService.filterationDate(Optional.of("2015"))).isNotEmpty();
    }
    @Test
    void filtrationDate_Failure() {
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("12243")));
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("xxxx")));
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("3333")));
    }
}