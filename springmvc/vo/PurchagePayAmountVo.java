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

public class PurchagePayAmountVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billPayId;
	private PurchageBillReportVo billPayBillId;
	private String billLotNo;
	private String billVarietyId;
	private BigDecimal billCount; 
	private BigDecimal billQuantity;
	private BigDecimal billPurchageQuantity;
	private BigDecimal billPurchageRate;
	private BigDecimal totalInvoiceAmt;
	public BigDecimal getTotalInvoiceAmt() {
		return totalInvoiceAmt;
	}


	public void setTotalInvoiceAmt(BigDecimal totalInvoiceAmt) {
		this.totalInvoiceAmt = totalInvoiceAmt;
	}


	public BigDecimal getTotalInvoiceQuantity() {
		return totalInvoiceQuantity;
	}


	public void setTotalInvoiceQuantity(BigDecimal totalInvoiceQuantity) {
		this.totalInvoiceQuantity = totalInvoiceQuantity;
	}


	private BigDecimal totalInvoiceQuantity;
	
	
	public PurchagePayAmountVo() {}


	public Integer getBillPayId() {
		return billPayId;
	}


	public void setBillPayId(Integer billPayId) {
		this.billPayId = billPayId;
	}


	public PurchageBillReportVo getBillPayBillId() {
		return billPayBillId;
	}


	public void setBillPayBillId(PurchageBillReportVo billPayBillId) {
		this.billPayBillId = billPayBillId;
	}


	public String getBillLotNo() {
		return billLotNo;
	}


	public void setBillLotNo(String billLotNo) {
		this.billLotNo = billLotNo;
	}


	public String getBillVarietyId() {
		return billVarietyId;
	}


	public void setBillVarietyId(String billVarietyId) {
		this.billVarietyId = billVarietyId;
	}


	public BigDecimal getBillCount() {
		return billCount;
	}


	public void setBillCount(BigDecimal billCount) {
		this.billCount = billCount;
	}


	public BigDecimal getBillQuantity() {
		return billQuantity;
	}


	public void setBillQuantity(BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}


	public BigDecimal getBillPurchageQuantity() {
		return billPurchageQuantity;
	}


	public void setBillPurchageQuantity(BigDecimal billPurchageQuantity) {
		this.billPurchageQuantity = billPurchageQuantity;
	}


	public BigDecimal getBillPurchageRate() {
		return billPurchageRate;
	}


	public void setBillPurchageRate(BigDecimal billPurchageRate) {
		this.billPurchageRate = billPurchageRate;
	}


	
	
}
