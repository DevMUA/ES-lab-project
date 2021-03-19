package com.labproject.Countriesproject.controller;

import com.labproject.Countriesproject.country.Country;
import com.labproject.Countriesproject.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    private static final String MAIN_PAGE = "index";
    private static final String JSON_COUNTRY_URL = "https://restcountries.eu/rest/v2/all";

    @Autowired
    private ParsingService parsingService;

    @GetMapping
    public String main(final Model model){
        List<Country> countries =  parsingService.parse(JSON_COUNTRY_URL);

        //Get a random country index
        Random random = new Random();
        int max = countries.size()-1;
        int randomCountryIndex = random.nextInt(max);

        model.addAttribute("country", countries.get(randomCountryIndex));
        return MAIN_PAGE;
    }
}
