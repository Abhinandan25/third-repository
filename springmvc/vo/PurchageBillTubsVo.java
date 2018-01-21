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

public class PurchageBillTubsVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billTubId;
	private PurchageBillReportVo billBillId;
	private String billLotNo;
	private String billMaterialTubs;
	private String billEmpty; 
	private String billTotalTubs;
	private BigDecimal billQuantity;
	
	
	public PurchageBillTubsVo() {}


	public Integer getBillTubId() {
		return billTubId;
	}


	public void setBillTubId(Integer billTubId) {
		this.billTubId = billTubId;
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


	public String getBillMaterialTubs() {
		return billMaterialTubs;
	}


	public void setBillMaterialTubs(String billMaterialTubs) {
		this.billMaterialTubs = billMaterialTubs;
	}


	public String getBillEmpty() {
		return billEmpty;
	}


	public void setBillEmpty(String billEmpty) {
		this.billEmpty = billEmpty;
	}


	public String getBillTotalTubs() {
		return billTotalTubs;
	}


	public void setBillTotalTubs(String billTotalTubs) {
		this.billTotalTubs = billTotalTubs;
	}


	public BigDecimal getBillQuantity() {
		return billQuantity;
	}


	public void setBillQuantity(BigDecimal billQuantity) {
		this.billQuantity = billQuantity;
	}


	
	
}
