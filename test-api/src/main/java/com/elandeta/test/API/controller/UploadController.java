package com.elandeta.test.API.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elandeta.test.API.model.Cliente;
import com.elandeta.test.API.model.ResponseMessage;
import com.elandeta.test.API.service.impl.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/upload-service")
public class UploadController {

	@Autowired
	private ClienteService clienteRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Collection<Cliente>> findAsuntoList() {

		Collection<Cliente> list = null;
		try {
			list = clienteRepository.list();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		return clienteRepository.uploadFile(file);
	}

}
