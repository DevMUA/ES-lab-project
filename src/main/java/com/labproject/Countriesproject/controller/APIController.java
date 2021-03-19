package com.labproject.Countriesproject.controller;

import com.labproject.Countriesproject.country.Country;
import com.labproject.Countriesproject.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class APIController {

    private static final String JSON_COUNTRY_BASE_URL = "https://restcountries.eu/rest/v2/";
    private static final String JSON_COUNTRY_URL = "https://restcountries.eu/rest/v2/all";

    @Autowired
    private ParsingService parsingService;

    public APIController(){ }

    public List<Country> GetCountries(){
        List<Country> countries =  parsingService.parse(JSON_COUNTRY_URL);
        return countries;
    }

    public Country GetCountryByName(String name){
        String query = JSON_COUNTRY_BASE_URL + "name/" + name;
        Country country = parsingService.parse(query).get(0);
        return country;
    }
}
