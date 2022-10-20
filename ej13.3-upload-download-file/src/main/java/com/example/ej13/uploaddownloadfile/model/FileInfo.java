package com.example.ej13.uploaddownloadfile.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Integer idFile;

    @Column
    String name;

    @Column
    String url;

    @Column
    String metadata;

    @Column
    Date uploadDate;

    public FileInfo(String filename, String url, String metadata, Date uploadDate) {
        this.name = filename;
        this.url = url;
        this.metadata = metadata;
        this.uploadDate = uploadDate;
    }
}
