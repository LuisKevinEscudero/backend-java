package com.example.ej13.uploaddownloadfile.repository;

import com.example.ej13.uploaddownloadfile.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FileRepository extends JpaRepository<FileInfo, Integer> {

    Optional<FileInfo> findByName(String name);
}
