package com.paessler.slashdot.service;

import com.paessler.slashdot.exception.ExternalSourceException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchNews {

    public List<String> extractNews(String urlValue) {
        List<String> newsContent = new ArrayList<>();
        Document doc;
        String pageNumber = "1";
        int prevPageNumber=0,currentPageNumber=0;
        try {
            do {
                doc = Jsoup.connect(urlValue + "&page=" + pageNumber).timeout(600000).get();
                Elements sampleLinks = doc.select("div.grid_24 > a");
                for (Element link : sampleLinks) {
                    newsContent.add(link.text());
                }
                Elements pageLink = doc.select("div.tleft > a");
                prevPageNumber = Integer.valueOf(pageNumber);
                for(Element pageNo : pageLink){
                    if(pageNo.text().contains("→"))
                        pageNumber =  pageNo.text().substring(0, pageNo.text().indexOf('→')).trim();
                }
                currentPageNumber = Integer.valueOf(pageNumber);
            }
            while(currentPageNumber>prevPageNumber);


        } catch (IOException e) {
            throw new ExternalSourceException(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"External Source Exception");
        }
        return newsContent;
    }
}
