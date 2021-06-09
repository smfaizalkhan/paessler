package com.paessler.slashdot.service;

import com.paessler.slashdot.exception.ExternalSourceException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.reset;

class FetchNewsTest {

    @InjectMocks
    private FetchNews fetchNews;
    private static final String SLASHDOT_ORG_ARCHIVE_PL_OP_BYTIME_KEYWORD_YEAR = "https://slashdot.org/archive.pl?op=bytime&keyword=&year=";


    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        reset();
    }

    @Test
    void extractNews_Success() throws URISyntaxException, IOException {
        URL path = ClassLoader.getSystemResource("test.html");
        File input = new File(path.toURI());
        Document document = Jsoup.parse(input, "UTF-8");
        System.out.println(document.title());
        List<String> newsContent =  fetchNews.extractNews(SLASHDOT_ORG_ARCHIVE_PL_OP_BYTIME_KEYWORD_YEAR+"2021");
        assertThat(document.title()).isEqualTo("Chronological Story Archive on Slashdot");
        assertTrue(!newsContent.isEmpty());

    }
}