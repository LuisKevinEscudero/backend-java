package com.example.ejer522;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImp implements CityService {

    List<City> cities= new ArrayList<>();

    City city = new City();
    @Override
    public City addCity(City c) {
        city = c;
        cities.add(c);
        return city;
    }

    @Override
    public List<City> getCities() {
        return cities;
    }
}

