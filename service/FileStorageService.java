package com.olp.service;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeFile(MultipartFile file);
    Path getFile(String fileName);
	boolean deleteFile(String fileName);
}
