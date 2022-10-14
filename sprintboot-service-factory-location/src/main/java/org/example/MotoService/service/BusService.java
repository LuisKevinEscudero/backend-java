package org.example.MotoService.service;

import org.springframework.stereotype.Service;

@Service("Bus")
public class BusService implements AdapterService {
    int numberExecution=1;
    @Override
    public String process() {
        return  "inside bus service  number of executions: "+(numberExecution++);
    }
}
