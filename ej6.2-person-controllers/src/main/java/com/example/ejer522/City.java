package com.example.ejer522;

import org.springframework.stereotype.Component;


@Component
public class City {
    String name;
    int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City addCity(String name, int population) {
        City city = new City();
        city.setName(name);
        city.setPopulation(population);

        return city;
    }

}
