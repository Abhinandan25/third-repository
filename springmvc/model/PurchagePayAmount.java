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
@Table(name="JME_PURCHASE_PAY_AMT")
public class PurchagePayAmount implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billPayId;
	private PurchageBillReport billPayBillId;
	private String billLotNo;
	private String billVarietyId;
	private BigDecimal billCount; 
	private BigDecimal billQuantity;
	private BigDecimal billPurchageQuantity;
	private BigDecimal billPurchageRate;
	

	
	
	
	public PurchagePayAmount() {}


	public PurchagePayAmount(Integer billPayId, PurchageBillReport billPayBillId, String billLotNo,
			String billVarietyId, BigDecimal billCount, BigDecimal billQuantity, BigDecimal billPurchageQuantity,
			BigDecimal billPurchageRate) {
		super();
		this.billPayId = billPayId;
		this.billPayBillId = billPayBillId;
		this.billLotNo = billLotNo;
		this.billVarietyId = billVarietyId;
		this.billCount = billCount;
		this.billQuantity = billQuantity;
		this.billPurchageQuantity = billPurchageQuantity;
		this.billPurchageRate = billPurchageRate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLD_PAY_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getBillPayId() {
		return billPayId;
	}


	public void setBillPayId(Integer billPayId) {
		this.billPayId = billPayId;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BILLD_PAY_BILL_ID")
	public PurchageBillReport getBillPayBillId() {
		return billPayBillId;
	}


	public void setBillPayBillId(PurchageBillReport billPayBillId) {
		this.billPayBillId = billPayBillId;
	}

	@Column(name="BILL_LOT_NO",nullable=false)
	public String getBillLotNo() {
		return billLotNo;
	}


	public void setBillLotNo(String billLotNo) {
		this.billLotNo = billLotNo;
	}

	@Column(name="BILLD_VARIETY_ID")
	public String getBillVarietyId() {
		return billVarietyId;
	}


	public void setBillVarietyId(String billVarietyId) {
		this.billVarietyId = billVarietyId;
	}

	@Column(name="BILLD_COUNT")
	public BigDecimal getBillCount() {
		return billCount;
	}


	public void setBillCount(BigDecimal billCount) {
		this.billCount = billCount;
	}

	@Column(name="BILLD_QUANTITY")
	public BigDecimal getBillQuantity() {
		return billQuantity;
	}


	public void setBillQuantity(BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}

	@Column(name="BILLD_PUR_QUANTITY")
	public BigDecimal getBillPurchageQuantity() {
		return billPurchageQuantity;
	}


	public void setBillPurchageQuantity(BigDecimal billPurchageQuantity) {
		this.billPurchageQuantity = billPurchageQuantity;
	}

	@Column(name="BILLD_PUR_RATE")
	public BigDecimal getBillPurchageRate() {
		return billPurchageRate;
	}


	public void setBillPurchageRate(BigDecimal billPurchageRate) {
		this.billPurchageRate = billPurchageRate;
	}

	
}
