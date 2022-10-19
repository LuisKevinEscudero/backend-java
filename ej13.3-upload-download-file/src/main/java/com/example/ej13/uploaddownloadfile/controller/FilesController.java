package com.example.ej13.uploaddownloadfile.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ej13.uploaddownloadfile.message.ResponseMessage;
import com.example.ej13.uploaddownloadfile.model.FileInfo;
import com.example.ej13.uploaddownloadfile.repository.FileRepository;
import com.example.ej13.uploaddownloadfile.service.FilesStorageService;
import com.example.ej13.uploaddownloadfile.service.FilesStorageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@RestController
public class FilesController {

    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
    {
        return filesStorageServiceImp.uploadFile(file);
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles()
    {
        return filesStorageServiceImp.getListFiles();
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename)
    {
        return filesStorageServiceImp.getFile(filename);
    }
}
