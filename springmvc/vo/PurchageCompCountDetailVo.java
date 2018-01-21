package com.jme.springmvc.vo;

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

public class PurchageCompCountDetailVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billCompCountId;
	private PurchageBillReportVo billBillId;
	private String billLotNo;
	private String bill25kGCount;
	private String billPeeling; 
	private BigDecimal billDiscolored;
	private BigDecimal billBlackSpot;
	private Integer bill1kgc;
	private BigDecimal billdCompCount;
	
	public Integer getBill1kgc() {
		return bill1kgc;
	}

	public BigDecimal getBilldCompCount() {
		return billdCompCount;
	}

	public void setBilldCompCount(BigDecimal billdCompCount) {
		this.billdCompCount = billdCompCount;
	}

	public void setBill1kgc(Integer bill1kgc) {
		this.bill1kgc = bill1kgc;
	}

	public PurchageCompCountDetailVo() {}

	public Integer getBillCompCountId() {
		return billCompCountId;
	}

	public void setBillCompCountId(Integer billCompCountId) {
		this.billCompCountId = billCompCountId;
	}

	public PurchageBillReportVo getBillBillId() {
		return billBillId;
	}

	public void setBillBillId(PurchageBillReportVo billBillId) {
		this.billBillId = billBillId;
	}

	public String getBillLotNo() {
		return billLotNo;
	}

	public void setBillLotNo(String billLotNo) {
		this.billLotNo = billLotNo;
	}

	public String getBill25kGCount() {
		return bill25kGCount;
	}

	public void setBill25kGCount(String bill25kGCount) {
		this.bill25kGCount = bill25kGCount;
	}

	public String getBillPeeling() {
		return billPeeling;
	}

	public void setBillPeeling(String billPeeling) {
		this.billPeeling = billPeeling;
	}

	public BigDecimal getBillDiscolored() {
		return billDiscolored;
	}

	public void setBillDiscolored(BigDecimal billDiscolored) {
		this.billDiscolored = billDiscolored;
	}

	public BigDecimal getBillBlackSpot() {
		return billBlackSpot;
	}

	public void setBillBlackSpot(BigDecimal billBlackSpot) {
		this.billBlackSpot = billBlackSpot;
	}
	
	
	
}
