package com.example.ejer522;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controlador2 {

    @Autowired
    CityService cityService;

    @GetMapping("/controlador2/getCity")
    public List<City> getCity()
    {
        return CityService.getCity();
    }
}
