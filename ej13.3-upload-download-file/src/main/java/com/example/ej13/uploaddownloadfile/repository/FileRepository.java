package com.example.ej13.uploaddownloadfile.repository;

import com.example.ej13.uploaddownloadfile.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<FileInfo, Integer> {

}
