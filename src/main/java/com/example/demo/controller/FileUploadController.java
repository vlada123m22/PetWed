package com.example.demo.controller;

import com.example.demo.dto.FileMetaDTO;
import com.example.demo.exceptions.FileStorageException;
import com.example.demo.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Secured("REGISTERED")
@Controller
public class FileUploadController {
    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload-file")
    @ResponseBody
    public ResponseEntity<FileMetaDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(storageService.store(file));
        } catch (FileStorageException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }


    }


}