package com.elandeta.test.API.service;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.elandeta.test.API.model.Cliente;
import com.elandeta.test.API.model.ResponseMessage;

public interface IUploadService {

	ResponseEntity<ResponseMessage> uploadFile(MultipartFile file);

	Collection<Cliente> list();
}
