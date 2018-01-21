package com.jme.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="JME_PURCHASE_BILL_TUBS")
public class PurchageBillTubs implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billTubId;
	private PurchageBillReport billBillId;
	private String billLotNo;
	private String billMaterialTubs;
	private String billEmpty; 
	private String billTotalTubs;
	private BigDecimal billQuantity;
	
	
	public PurchageBillTubs() {}


	public PurchageBillTubs(Integer billTubId, PurchageBillReport billBillId, String billLotNo, String billMaterialTubs,
			String billEmpty, String billTotalTubs, BigDecimal billQuantity) {
		super();
		this.billTubId = billTubId;
		this.billBillId = billBillId;
		this.billLotNo = billLotNo;
		this.billMaterialTubs = billMaterialTubs;
		this.billEmpty = billEmpty;
		this.billTotalTubs = billTotalTubs;
		this.billQuantity = billQuantity;
	}


	public PurchageBillTubs(Integer billTubId, String billLotNo, String billMaterialTubs, String billEmpty,
			String billTotalTubs, BigDecimal billQuantity) {
		super();
		this.billTubId = billTubId;
		this.billLotNo = billLotNo;
		this.billMaterialTubs = billMaterialTubs;
		this.billEmpty = billEmpty;
		this.billTotalTubs = billTotalTubs;
		this.billQuantity = billQuantity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLD_TUB_ID",unique=true,nullable=false,insertable = false)
	public Integer getBillTubId() {
		return billTubId;
	}


	public void setBillTubId(Integer billTubId) {
		this.billTubId = billTubId;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BILLD_BILL_ID")
	public PurchageBillReport getBillBillId() {
		return billBillId;
	}


	public void setBillBillId(PurchageBillReport billBillId) {
		this.billBillId = billBillId;
	}

	@Column(name="BILL_LOT_NO",nullable=false)
	public String getBillLotNo() {
		return billLotNo;
	}


	public void setBillLotNo(String billLotNo) {
		this.billLotNo = billLotNo;
	}

	@Column(name="BILLD_MATERIAL_TUBS")
	public String getBillMaterialTubs() {
		return billMaterialTubs;
	}


	public void setBillMaterialTubs(String billMaterialTubs) {
		this.billMaterialTubs = billMaterialTubs;
	}

	@Column(name="BILLD_EMPTY")
	public String getBillEmpty() {
		return billEmpty;
	}


	public void setBillEmpty(String billEmpty) {
		this.billEmpty = billEmpty;
	}

	@Column(name="BILLD_TOTAL_TUBS")
	public String getBillTotalTubs() {
		return billTotalTubs;
	}


	public void setBillTotalTubs(String billTotalTubs) {
		this.billTotalTubs = billTotalTubs;
	}

	@Column(name="BILLD_QUANTITY")
	public BigDecimal getBillQuantity() {
		return billQuantity;
	}


	public void setBillQuantity(BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}
	
}
