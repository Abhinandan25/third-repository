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
@Table(name="JME_PURCHASE_COMP_COUNT_DTL")
public class PurchageCompCountDetail implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billCompCountId;
	private PurchageBillReport billBillId;
	private String billLotNo;
	private String bill25kGCount;
	private String billPeeling; 
	private BigDecimal billDiscolored;
	private BigDecimal billBlackSpot;
	private BigDecimal billdCompCount;
	
	public PurchageCompCountDetail() {}
	
	public PurchageCompCountDetail(Integer billCompCountId, PurchageBillReport billBillId, String billLotNo,
			String bill25kGCount, String billPeeling, BigDecimal billDiscolored, BigDecimal billBlackSpot) {
		super();
		this.billCompCountId = billCompCountId;
		this.billBillId = billBillId;
		this.billLotNo = billLotNo;
		this.bill25kGCount = bill25kGCount;
		this.billPeeling = billPeeling;
		this.billDiscolored = billDiscolored;
		this.billBlackSpot = billBlackSpot;
	}

	public PurchageCompCountDetail(Integer billCompCountId, String billLotNo, String bill25kGCount, String billPeeling,
			BigDecimal billDiscolored, BigDecimal billBlackSpot) {
		super();
		this.billCompCountId = billCompCountId;
		this.billLotNo = billLotNo;
		this.bill25kGCount = bill25kGCount;
		this.billPeeling = billPeeling;
		this.billDiscolored = billDiscolored;
		this.billBlackSpot = billBlackSpot;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILLD_COMP_COUNT_ID",unique=true,nullable=false,insertable = false)
	public Integer getBillCompCountId() {
		return billCompCountId;
	}

	public void setBillCompCountId(Integer billCompCountId) {
		this.billCompCountId = billCompCountId;
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
	
	@Column(name="25KGCOUNT")
	public String getBill25kGCount() {
		return bill25kGCount;
	}

	public void setBill25kGCount(String bill25kGCount) {
		this.bill25kGCount = bill25kGCount;
	}

	@Column(name="PEELING")
	public String getBillPeeling() {
		return billPeeling;
	}

	public void setBillPeeling(String billPeeling) {
		this.billPeeling = billPeeling;
	}

	@Column(name="DISCOLORED")
	public BigDecimal getBillDiscolored() {
		return billDiscolored;
	}

	public void setBillDiscolored(BigDecimal billDiscolored) {
		this.billDiscolored = billDiscolored;
	}

	@Column(name="BLACKSPOT")
	public BigDecimal getBillBlackSpot() {
		return billBlackSpot;
	}

	public void setBillBlackSpot(BigDecimal billBlackSpot) {
		this.billBlackSpot = billBlackSpot;
	}

	@Column(name="BILLD_COMP_COUNT")
	public BigDecimal getBilldCompCount() {
		return billdCompCount;
	}

	public void setBilldCompCount(BigDecimal billdCompCount) {
		this.billdCompCount = billdCompCount;
	}
	
	
	
}
