package com.example.ejer522;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    List<City> cities;

    City city = new City();
    @Override
    public City addCity(City c) {
        city = c;
        return city;
    }
    @Override
    public List<City> getCity() {
        return cities;
    }
}

