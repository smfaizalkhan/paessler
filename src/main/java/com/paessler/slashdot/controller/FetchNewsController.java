package com.paessler.slashdot.controller;


import com.paessler.slashdot.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class FetchNewsController {


    private final NewsService newsService;

    @GetMapping(value={"/", "/{year}"})
    public List<String> getNewsByYear(@PathVariable(required = false) Optional<String>  year){
       return newsService.filterationDate(year);
    }
}
