package com.labproject.Countriesproject.service;

import com.labproject.Countriesproject.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class JsonParsingService implements ParsingService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Country> parse(String url){
        return Arrays.asList(restTemplate.getForObject(url,Country[].class));
    }

}
