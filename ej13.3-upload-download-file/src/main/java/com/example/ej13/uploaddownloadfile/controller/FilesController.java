package com.example.ej13.uploaddownloadfile.controller;


import java.util.List;
import com.example.ej13.uploaddownloadfile.message.ResponseMessage;
import com.example.ej13.uploaddownloadfile.model.FileInfo;
import com.example.ej13.uploaddownloadfile.repository.FileRepository;
import com.example.ej13.uploaddownloadfile.service.FilesStorageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FilesController {

    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;

    @Autowired
    FileRepository fileRepository;


    @PostMapping("/upload/{type}")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String type)
    {
        return filesStorageServiceImp.uploadFile(file, type);
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

    @GetMapping("/filesById/{idFile}")
    @ResponseBody
    public ResponseEntity<Resource> getFileById(@PathVariable Integer idFile)
    {
        return filesStorageServiceImp.getFile(fileRepository.findById(idFile).get().getName());
    }


}
