package com.labproject.Countriesproject.controller;

import com.labproject.Countriesproject.country.Country;
import com.labproject.Countriesproject.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
@EnableScheduling
//@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class MainController {

    private static final String MAIN_PAGE = "index";

    List<Country> countries;

    @Autowired
    private APIController apiController;


    @GetMapping
    public String main(final Model model){

        if(countries == null)
            countries = apiController.GetCountries();

        //Get a random country index
        Random random = new Random();
        int max = countries.size()-1;
        int randomCountryIndex = random.nextInt(max);

        model.addAttribute("country", countries.get(randomCountryIndex));
        return MAIN_PAGE;
    }

    @Scheduled(fixedRate = 5000L)
    public void UpdateCountryList(){
        System.out.println("Updating Country list");
        countries = apiController.GetCountries();
    }
}
