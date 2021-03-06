package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Contract;

public class UserRequest {

	private Long id;
	private String username;
	private String password;
	private Long ci;
	private Long rif;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private List<Contract> contracts;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Long getCi() {
		return ci;
	}

	public Long getRif() {
		return rif;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public void setRif(Long rif) {
		this.rif = rif;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
