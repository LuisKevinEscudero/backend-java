package com.example.ejer523;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {


    @Autowired
    @Qualifier("bean1")
    Persona persona1;

    @Autowired
    @Qualifier("bean2")
    Persona persona2;

    @Autowired
    @Qualifier("bean3")
    Persona persona3;

    @GetMapping("/controlador1/bean/{bean}")
    public  Persona mostrarBean(@PathVariable String bean)
    {
        if (bean.equals("bean1"))
            return  persona1;
        if (bean.equals("bean2"))
            return  persona2;
        if (bean.equals("bean3"))
            return  persona3;

        return null;
    }


}
