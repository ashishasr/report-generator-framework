package com.reportgenerator.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="institute")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Institute {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="institutename")
	private String institutename;
	
	@Column(name="operatingyear")
	private String operatingyear;
	
	@Column(name="state")
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInstitutename() {
		return institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}

	public String getOperatingyear() {
		return operatingyear;
	}

	public void setOperatingyear(String operatingyear) {
		this.operatingyear = operatingyear;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
