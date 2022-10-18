package com.example.ej13.uploaddownloadfile.controller;

import com.example.ej13.uploaddownloadfile.exception.StorageFileNotFoundException;
import com.example.ej13.uploaddownloadfile.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class UploadFileController {

    private final StorageService storageService;


    @Autowired
    public UploadFileController(StorageService storageService) {
        this.storageService = storageService;
    }


//    Looks up the current list of uploaded files from the StorageService and loads it into a
//    Thymeleaf template. It calculates a link to the actual resource by using MvcUriComponentsBuilder.
    @GetMapping("/listUploadedFiles")
    public String listUploadedFiles(Model model) throws IOException
    {
        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(UploadFileController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

//    Loads the resource (if it exists) and sends it to the browser to download by using a Content-Disposition response header.
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename)
    {
        Resource file = (Resource) storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    //Handles a multi-part message file and gives it to the StorageService for saving.
    @PostMapping("/handleFileUpload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes)
    {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc)
    {
        return ResponseEntity.notFound().build();
    }
}