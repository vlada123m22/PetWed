package com.example.demo.service.implementation;

import com.example.demo.dto.FileMetaDTO;
import com.example.demo.exceptions.FileStorageException;
import com.example.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.Objects;

@Service
public class FileSystemStorageService implements StorageService {
    private static final String ROOT_FOLDER = System.getProperty("user.dir");
    private final String fileUploadDir=ROOT_FOLDER+"/src/main/resources/static/img";

    @Override
    public FileMetaDTO store(MultipartFile file) throws FileStorageException {
        Path root = Paths.get(fileUploadDir);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Files.createDirectories(root);
            Path uploadFile = root.resolve(fileName);
            Files.copy(file.getInputStream(), uploadFile, StandardCopyOption.REPLACE_EXISTING);
            return new FileMetaDTO(fileName,"/img/"+fileName,uploadFile.toString(),file.getSize());
        } catch (IOException e) {
            throw new FileStorageException(MessageFormat.format("Cannot save file: {0}", fileName));
        }
    }
}
