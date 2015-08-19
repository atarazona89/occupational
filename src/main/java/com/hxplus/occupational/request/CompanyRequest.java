package com.hxplus.occupational.request;

import com.hxplus.occupational.model.CostCenter;

public class CompanyRequest {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private CostCenter mainLocation;
	
	public Long getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getRif() {
		return rif;
	}
	public String getDescription() {
		return description;
	}
	public CostCenter getMainLocation() {
		return mainLocation;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setMainLocation(CostCenter mainLocation) {
		this.mainLocation = mainLocation;
	}

}