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
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

class NewsServiceTest {

    @InjectMocks
    private NewsService newsService;


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(newsService, "mapOfDateToNews", DomainFactory.getmapOfDateToNews());
        reset();
    }

    @Test
    void filtrationDate_Success() {
        assertThat(newsService.filterationDate(Optional.of("2015"))).isNotEmpty();
    }
    @Test
    void filtrationDate_Failure() {
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("12243")));
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("xxxx")));
        assertThrows(InputMismatchException.class,() ->newsService.filterationDate(Optional.of("3333")));
    }
}