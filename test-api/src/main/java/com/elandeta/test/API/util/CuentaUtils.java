package com.elandeta.test.API.util;

import java.security.SecureRandom;

public class CuentaUtils {

	private static final SecureRandom random = new SecureRandom();

	/**
	 * Genera un número de cuenta aleatorio de longitud especificada.
	 * 
	 * @param longitud La longitud deseada del número de cuenta.
	 * @return El número de cuenta aleatorio como un String.
	 */
	public static String generarNumeroCuenta(int longitud) {
		if (longitud <= 0) {
			throw new IllegalArgumentException("La longitud debe ser mayor a 0");
		}

		StringBuilder cuenta = new StringBuilder();

		for (int i = 0; i < longitud; i++) {
			cuenta.append(random.nextInt(10));
		}

		return cuenta.toString();
	}

}
