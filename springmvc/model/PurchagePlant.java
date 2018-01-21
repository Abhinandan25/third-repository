package com.jme.springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import org.hibernate.annotations.Cascade;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.CascadeType;
@Entity
@Table(name="JME_PURCHASE_PLANT")
public class PurchagePlant implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billPlantId;
	private String billPlantName;
	private String billPlantShortName;
	private String billPlantPrefix;
	private String billPlantMonth;
	private Integer billPlantCounter;
	
	
	@Column(name="BILLD_PLANT_COUNTER")
	public Integer getBillPlantCounter() {
		return billPlantCounter;
	}

	public void setBillPlantCounter(Integer billPlantCounter) {
		this.billPlantCounter = billPlantCounter;
	}

	@Column(name="BILLD_PLANT_MONTH")
	public String getBillPlantMonth() {
		return billPlantMonth;
	}

	public void setBillPlantMonth(String billPlantMonth) {
		this.billPlantMonth = billPlantMonth;
	}

	@Column(name="BILLD_PLANT_PREFIX")
	public String getBillPlantPrefix() {
		return billPlantPrefix;
	}

	public void setBillPlantPrefix(String billPlantPrefix) {
		this.billPlantPrefix = billPlantPrefix;
	}

	public PurchagePlant() {}

	public PurchagePlant(Integer billPlantId, String billPlantName,String billPlantShortName) {
		super();
		this.billPlantId = billPlantId;
		this.billPlantName = billPlantName;
		this.billPlantShortName = billPlantShortName;
	}


	@Id
	@Column(name="BILLD_PLANT_ID",unique=true,nullable=false)
	public Integer getBillPlantId() {
		return billPlantId;
	}

	public void setBillPlantId(Integer billPlantId) {
		this.billPlantId = billPlantId;
	}

	@Column(name="BILLD_PLANT_NAME")
	public String getBillPlantName() {
		return billPlantName;
	}

	public void setBillPlantName(String billPlantName) {
		this.billPlantName = billPlantName;
	}

	@Column(name="BILLD_PLANT_SHORT_NAME")
	public String getBillPlantShortName() {
		return billPlantShortName;
	}

	public void setBillPlantShortName(String billPlantShortName) {
		this.billPlantShortName = billPlantShortName;
	}
	
	
	
}
