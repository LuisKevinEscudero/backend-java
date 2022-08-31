package com.example.ej6.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource("classpath:miconfiguracion.properties")
public class config {

    @Value("${var1}")
    private String var1;

    @Value("${var2}")
    private String var2;

    @GetMapping("miconfiguracion")
    public String miconfiguracion() {
        return "El valor de var1 es: "+var1+" El valor de var2 es: "+var2;
    }

}
