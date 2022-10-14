package org.example.MotoService.service;

import org.springframework.stereotype.Service;

@Service("Car")
public class CarService implements AdapterService {
    int numberExecution=1;

    @Override
    public String process() {
        return "inside car service -  number of executions: "+(numberExecution++);
    }
}
