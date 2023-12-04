package com.example.demo.service;


import com.example.demo.dto.FileMetaDTO;
import com.example.demo.exceptions.FileStorageException;
import org.springframework.web.multipart.MultipartFile;



public interface StorageService {

    FileMetaDTO store(MultipartFile file) throws FileStorageException;
}
