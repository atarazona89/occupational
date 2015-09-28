package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "history")
public class History {

	private Long id;
	private Background background;
	private List<Allergy> allergies;
	private List<Vaccine> vaccines;
	private List<Habit> habits;
	private List<Consult> consults;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbackground", referencedColumnName = "id")
	public Background getBackground() {
		return background;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "history")
	public List<Allergy> getAllergies() {
		return allergies;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "history")
	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "history")
	public List<Habit> getHabits() {
		return habits;
	}

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idhistory", referencedColumnName="id")
	public List<Consult> getConsults() {
		return consults;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public void setHabits(List<Habit> habits) {
		this.habits = habits;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

}
