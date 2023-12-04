package com.celac.ecommerce.service.impl;

import com.celac.ecommerce.dto.FileMetaDTO;
import com.celac.ecommerce.exceptions.FileStorageException;
import com.celac.ecommerce.service.StorageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
* @author scelac
*/
@Service
public class FileSystemStorageService implements StorageService {
    @Value("${file.upload.dir}")
    private String fileUploadDir;

    @Override
    public FileMetaDTO store(MultipartFile file) throws FileStorageException {
        Path root = Paths.get(fileUploadDir);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            Files.createDirectories(root);
            Path uploadFile = root.resolve(fileName);
            Files.copy(file.getInputStream(), uploadFile);
            return new FileMetaDTO(fileName,"/img/"+fileName,uploadFile.toString(),file.getSize());
        } catch (IOException e) {
            throw new FileStorageException(MessageFormat.format("Cant save file: {0}", fileName));
        }
    }
}
