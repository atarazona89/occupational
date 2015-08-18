package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "id")
public class Doctor extends User {

	private Long regNumber;
	private List<Patient> patients;

	@Column(name="regnumber")
	public Long getRegNumber() {
		return regNumber;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public List<Patient> getPatients() {
		return patients;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
