package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

	private Long id;
	private String username;
	private String password;
	private Long ci;
	private Long rif;
	private String firstName;
	private String lastName;
	private String sex;
	private Date birthDate;
	private String address;
	private String phoneNumber;
	private String email;
	private CostCenter works;
	private Company employer;
	private Post post;
	private List<Contract> contracts;
	private File photo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "ci")
	public Long getCi() {
		return ci;
	}

	@Column(name = "rif")
	public Long getRif() {
		return rif;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public String getSex() {
		return sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idcostcenter", referencedColumnName = "id")
	@JsonBackReference
	public CostCenter getWorks() {
		return works;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idcompany", referencedColumnName = "id")
	@JsonBackReference
	public Company getEmployer() {
		return employer;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idpost", referencedColumnName = "id")
	@JsonBackReference
	public Post getPost() {
		return post;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user")
	@JsonManagedReference
	public List<Contract> getContracts() {
		return contracts;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="photo", referencedColumnName="id")
	public File getPhoto() {
		return photo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public void setWorks(CostCenter works) {
		this.works = works;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String toString() {
		return "Id: " + id + "\n\tUsername: " + username;
	}

}
