package com.labproject.Countriesproject.service;

import com.labproject.Countriesproject.country.Country;

import java.util.List;

public interface ParsingService {
    List<Country> parse(String url);
}
