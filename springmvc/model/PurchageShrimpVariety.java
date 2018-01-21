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
@Table(name="JME_PURCHASE_SHRIMP_VARIETY")
public class PurchageShrimpVariety implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billVarietyId;
	private String billShrimpType;
	
	public PurchageShrimpVariety() {}
	
	public PurchageShrimpVariety(Integer billVarietyId, String billShrimpType) {
		super();
		this.billVarietyId = billVarietyId;
		this.billShrimpType = billShrimpType;
	}
	
	@Id
	@Column(name="BILLD_VARIETY_ID",unique=true,nullable=false,length=20)
	public Integer getBillVarietyId() {
		return billVarietyId;
	}

	public void setBillVarietyId(Integer billVarietyId) {
		this.billVarietyId = billVarietyId;
	}

	@Column(name="BILLD_SHRIMP_TYPE")
	public String getBillShrimpType() {
		return billShrimpType;
	}

	public void setBillShrimpType(String billShrimpType) {
		this.billShrimpType = billShrimpType;
	}
	
	
}
