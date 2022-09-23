package com.example.ej6.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller1 {

    @Autowired
    private Environment environment;

    @Autowired
    perfiles perf;

    @Value("${server.port}")
    private String port;

    @Value("${server.url}")
    private String url;

    @Value("${server.password}")
    private String password;

    @GetMapping("parametros")
    public String parametros() {
        return "El valor de port es: "+port+" El valor de url es: "+url+" El valor de password es: "+password;
    }

    @GetMapping("profile")
    public void profile() {
       perf.miFuncion();
    }
}

