package org.example.MotoService.service;

import org.springframework.stereotype.Service;

@Service("Bike")
public class BikeService implements AdapterService {
    int numberExecution=1;
    @Override
    public String process() {
        return "inside bike service  number of executions: "+(numberExecution++);
    }

}