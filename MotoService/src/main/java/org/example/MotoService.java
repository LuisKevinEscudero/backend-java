package org.example;

import org.springframework.stereotype.Service;

@Service("Moto")
public class MotoService implements AdapterService {
	int numberExecution=1;
	@Override
	public String process() {
		return "inside moto service  number of executions: "+(numberExecution++);
	}
	
}
