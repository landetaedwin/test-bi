package com.elandeta.test.API.service.impl;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elandeta.test.API.dao.ClienteRepository;
import com.elandeta.test.API.model.Cliente;
import com.elandeta.test.API.model.ResponseMessage;
import com.elandeta.test.API.service.IUploadService;
import com.elandeta.test.API.util.CedulaUtils;
import com.elandeta.test.API.util.CuentaUtils;

@Service
public class ClienteService implements IUploadService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ResponseEntity<ResponseMessage> uploadFile(MultipartFile file) {

		// Validar que el archivo no esté vacío
		if (file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("El archivo está vacío"));
		}

		// Validar que el archivo sea un .txt
		if (!file.getOriginalFilename().endsWith(".txt")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseMessage("Solo se permiten archivos .txt"));
		}

		try {
			// Leer el contenido del archivo
			String content = new String(file.getBytes());

			// Dividir por líneas
			String[] lineas = content.split("\n");

			// Procesar cada línea
			for (String linea : lineas) {
				String[] campos = linea.split(",");
				Cliente cliente = new Cliente();

				cliente.setNombre(campos[0]);
				cliente.setApellido(campos[1]);
				cliente.setIdentificacion(campos[2]);
				cliente.setEdad(Integer.parseInt(campos[3]));
				cliente.setFechaRegistro(campos[4]);
				cliente.setCorreo(campos[5]);
				//3.	Generar un algoritmo para generar y asignar la cuenta al cliente que sea de 9 dígitos
				cliente.setCuenta(CuentaUtils.generarNumeroCuenta(9));

				if (!CedulaUtils.validarCedula(cliente.getIdentificacion())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(
							"La identificación: " + cliente.getIdentificacion() + " no es valida."));
				}

				try {
					clienteRepository.save(cliente);
				} catch (Exception e) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(new ResponseMessage("Error al insertar datos " + e));
				}

			}

		} catch (IOException e) {

		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Archivo procesado correctamente"));

	}

	@Override
	public Collection<Cliente> list() {
		return clienteRepository.findAll();
	}

}
