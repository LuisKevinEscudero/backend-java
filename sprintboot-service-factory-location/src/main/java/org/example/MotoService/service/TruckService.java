package org.example.MotoService.service;

import org.springframework.stereotype.Service;

@Service("Truck")
public class TruckService implements AdapterService{
    int numberExecution=1;
    @Override
    public String process() {
        return "inside truck service -  number of executions: "+(numberExecution++);
    }
}

