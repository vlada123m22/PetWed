package com.celac.ecommerce.service;

import com.celac.ecommerce.dto.FileMetaDTO;
import com.celac.ecommerce.exceptions.FileStorageException;
import java.nio.file.Path;
import org.springframework.web.multipart.MultipartFile;

/**
* @author scelac
*/

public interface StorageService {

    FileMetaDTO store(MultipartFile file) throws FileStorageException;
}
