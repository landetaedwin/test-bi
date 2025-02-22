package com.elandeta.test.API.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nombre;

	@Column(nullable = false, length = 50)
	private String apellido;

	@Column(nullable = false, unique = true, length = 20)
	private String identificacion;

	@Column(nullable = false)
	private int edad;

	@Column(nullable = false)
	private String fecharegistro;

	@Column(nullable = false, unique = true, length = 100)
	private String correo;

	@Column(nullable = false, unique = true, length = 20)
	private String cuenta;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, String identificacion, int edad, String fecharegistro, String correo,
			String cuenta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.edad = edad;
		this.fecharegistro = fecharegistro;
		this.correo = correo;
		this.cuenta = cuenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaRegistro() {
		return fecharegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fecharegistro = fechaRegistro;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Cliente{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\''
				+ ", identificacion='" + identificacion + '\'' + ", edad=" + edad + ", fecharegistro=" + fecharegistro
				+ ", correo='" + correo + '\'' + ", cuenta='" + cuenta + '\'' + '}';
	}
}
