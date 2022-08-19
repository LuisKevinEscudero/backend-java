package com.example.ejer522;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controlador1 {

    @Autowired
    CityService cityService;

    @GetMapping("/controlador1/addCity/")
    public City addCity(@RequestHeader String name, @RequestHeader int population)
    {
        return cityService.addCity(new City().addCity(name, population));
    }

}
