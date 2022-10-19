package com.example.ej13.uploaddownloadfile;


import com.example.ej13.uploaddownloadfile.service.FilesStorageService;

import com.example.ej13.uploaddownloadfile.service.FilesStorageServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Resource
	FilesStorageServiceImp filesStorageServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		filesStorageServiceImp.deleteAll();
		filesStorageServiceImp.init();
	}

}
