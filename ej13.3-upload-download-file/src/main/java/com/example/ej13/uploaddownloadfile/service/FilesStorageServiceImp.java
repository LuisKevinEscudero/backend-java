package com.example.ej13.uploaddownloadfile.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.example.ej13.uploaddownloadfile.controller.FilesController;
import com.example.ej13.uploaddownloadfile.message.ResponseMessage;
import com.example.ej13.uploaddownloadfile.model.FileInfo;
import com.example.ej13.uploaddownloadfile.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class FilesStorageServiceImp implements FilesStorageService {

    @Autowired
    FileRepository fileRepository;

    //private final Path root = Paths.get("ej13.3-upload-download-file/uploads");
    Path root;

    @Override
    public void init(String route) {
        try {
            this.root = Paths.get(route);
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(strippedFilename(file.getOriginalFilename())));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(String route) {
        this.root = Paths.get(route);
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    public ResponseEntity<ResponseMessage> uploadFile( MultipartFile file, String type)
    {

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        if (!extension.equals(type))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("El tipo de fichero no es correcto"));
        }

        String message = "";
        try
        {
            save(file);
            fileRepository.save(new FileInfo(
                    strippedFilename(file.getOriginalFilename()),
                    loadAll().map(path -> MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString()).toList().get(0),
                    file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1),
                    new Date() ) );

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = loadAll().map(path -> {
            String filename = path.getFileName().toString();
            Integer idFile=fileRepository.findByName(filename).get().getIdFile();
            String url=fileRepository.findByName(filename).get().getUrl();
            String metadata= fileRepository.findByName(filename).get().getMetadata();
            Date uploadDate = fileRepository.findByName(filename).get().getUploadDate();
            return new FileInfo(idFile,filename, url, metadata, uploadDate);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    public ResponseEntity<Resource> getFile(@PathVariable String filename)
    {
        Resource file = load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    // remove spaces from filename
    public String strippedFilename(String filename)
    {
        return filename.replaceAll("\\s", "");
    }


}