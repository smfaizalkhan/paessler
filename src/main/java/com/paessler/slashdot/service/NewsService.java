package com.paessler.slashdot.service;

import com.paessler.slashdot.exception.ExternalSourceException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class NewsService {

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^[12][0-9]{3}$");
    private static final String SLASHDOT_ORG_ARCHIVE_PL_OP_BYTIME_KEYWORD_YEAR = "https://slashdot.org/archive.pl?op=bytime&keyword=&year=";
   private final FetchNews fetchNews;


    public List<String> filterationDate(Optional<String> year) {
        List<String> newsContent ;
        if(year.isPresent() && !DATE_PATTERN.matcher(year.get()).matches())
            throw new InputMismatchException(String.format("Please enter a valid year %s",year.get()));
        String filtrationYear = year.isPresent()?year.get():String.valueOf(LocalDate.now().getYear());
        newsContent = fetchNews.extractNews(SLASHDOT_ORG_ARCHIVE_PL_OP_BYTIME_KEYWORD_YEAR +filtrationYear);
        return newsContent;
    }
}
