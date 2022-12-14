package com.example.ej13.uploaddownloadfile.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


public interface FilesStorageService {
    public void init(String route);

    public void save(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll(String route);

    public Stream<Path> loadAll();
}
