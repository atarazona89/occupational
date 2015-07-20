package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private Long id;
	private Long ci;
	private Long rif;
	private String primerNombre;
	private String primerApellido;
	private String direccionHabitacion;
	private String nroTelefono;
	private String email;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "ci")
	public Long getCi() {
		return ci;
	}

	@Column(name = "rif")
	public Long getRif() {
		return rif;
	}

	@Column(name = "primerNombre")
	public String getPrimerNombre() {
		return primerNombre;
	}

	@Column(name = "primerApellido")
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	@Column(name = "direccionHabitacion")
	public String getDireccionHabitacion() {
		return direccionHabitacion;
	}

	@Column(name = "nroTelefono")
	public String getNroTelefono() {
		return nroTelefono;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public void setRif(Long rif) {
		this.rif = rif;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public void setDireccionHabitacion(String direccionHabitacion) {
		this.direccionHabitacion = direccionHabitacion;
	}

	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
