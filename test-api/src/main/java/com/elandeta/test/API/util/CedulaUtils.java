package com.elandeta.test.API.util;

public class CedulaUtils {
	/**
	 * Valida una cédula de identidad.
	 * 
	 * @param cedula La cédula a validar.
	 * @return true si la cédula es válida, false si no lo es.
	 */
	public static boolean validarCedula(String cedula) {
		// Eliminar espacios en blanco y asegurarse de que la cédula tenga 10 caracteres
		cedula = cedula.replaceAll("\\s+", "");

		// Verificar que la cédula tenga exactamente 10 dígitos y que sea numérica
		if (cedula.length() != 10 || !cedula.matches("\\d+")) {
			return false; // No es un número de 10 dígitos
		}

		// El primer dígito debe ser 0, 1, 2, 3 (códigos de provincia)
		int primerDigito = Character.getNumericValue(cedula.charAt(0));
		if (primerDigito < 0 || primerDigito > 3) {
			return false;
		}

		// Cálculo del dígito verificador
		int[] multiplicadores = { 2, 1, 2, 1, 2, 1, 2, 1, 2 }; // Multiplicadores
		int suma = 0;

		// Multiplicar cada dígito por su correspondiente multiplicador
		for (int i = 0; i < 9; i++) {
			int digito = Character.getNumericValue(cedula.charAt(i));
			suma += digito * multiplicadores[i];
		}

		// Calcular el dígito verificador
		int digitoVerificador = 10 - (suma % 10);
		if (digitoVerificador == 10) {
			digitoVerificador = 0;
		}

		// Verificar que el último dígito coincida con el dígito verificador
		return digitoVerificador == Character.getNumericValue(cedula.charAt(9));
	}

}
