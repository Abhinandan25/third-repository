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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.CascadeType;

public class PurchageBillReportVo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billId;
	private WeighmentVo billReportLotNo;
	private String billDriverName;
	private String billGraderName;
	private String billSupervisorName; 
	private String billPurchageManager;
	private String billPurchageAuthorized;
	private String billPlantManager;
	private String billAccountManager;
	private String billAuthorized;
	
	
	public Integer getBillLotNo() {
		return billLotNo;
	}

	public void setBillLotNo(Integer billLotNo) {
		this.billLotNo = billLotNo;
	}

	private Integer billLotNo;
	private String billCreId;
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	
	private Boolean billDispatchedBvrm;
	private Boolean billDispatchedNsp;
	
	private Boolean billCertificate;
	private Boolean billNoCertificate;
	
	private String billRemarks;
	
	private BigDecimal totalInvoiceAmt;
	
	private BigDecimal totalInvoiceQuantity;
	
	
	private List<PurchageBillTubsVo> purchageBillTubs =new ArrayList<PurchageBillTubsVo>();
	
	private List<PurchagePayAmountVo> purchagePayAmount =new ArrayList<PurchagePayAmountVo>();
	

	private List<PurchageCompCountDetailVo> purchageCompCountDetail =new ArrayList<PurchageCompCountDetailVo>();
	
	private String billDueDate;
	
	public PurchageBillReportVo() {}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public WeighmentVo getBillReportLotNo() {
		return billReportLotNo;
	}

	public void setBillReportLotNo(WeighmentVo billReportLotNo) {
		this.billReportLotNo = billReportLotNo;
	}

	public String getBillDriverName() {
		return billDriverName;
	}

	public void setBillDriverName(String billDriverName) {
		this.billDriverName = billDriverName;
	}

	public String getBillGraderName() {
		return billGraderName;
	}

	public void setBillGraderName(String billGraderName) {
		this.billGraderName = billGraderName;
	}

	public String getBillSupervisorName() {
		return billSupervisorName;
	}

	public void setBillSupervisorName(String billSupervisorName) {
		this.billSupervisorName = billSupervisorName;
	}

	public String getBillPurchageManager() {
		return billPurchageManager;
	}

	public void setBillPurchageManager(String billPurchageManager) {
		this.billPurchageManager = billPurchageManager;
	}

	public String getBillPurchageAuthorized() {
		return billPurchageAuthorized;
	}

	public void setBillPurchageAuthorized(String billPurchageAuthorized) {
		this.billPurchageAuthorized = billPurchageAuthorized;
	}

	public String getBillPlantManager() {
		return billPlantManager;
	}

	public void setBillPlantManager(String billPlantManager) {
		this.billPlantManager = billPlantManager;
	}

	public String getBillAccountManager() {
		return billAccountManager;
	}

	public void setBillAccountManager(String billAccountManager) {
		this.billAccountManager = billAccountManager;
	}

	public String getBillAuthorized() {
		return billAuthorized;
	}

	public void setBillAuthorized(String billAuthorized) {
		this.billAuthorized = billAuthorized;
	}

	public Boolean getBillCertificate() {
		return billCertificate;
	}

	public void setBillCertificate(Boolean billCertificate) {
		this.billCertificate = billCertificate;
	}

	public Boolean getBillNoCertificate() {
		return billNoCertificate;
	}

	public void setBillNoCertificate(Boolean billNoCertificate) {
		this.billNoCertificate = billNoCertificate;
	}

	public String getBillCreId() {
		return billCreId;
	}

	public void setBillCreId(String billCreId) {
		this.billCreId = billCreId;
	}

	public Date getBillCreDt() {
		return billCreDt;
	}

	public void setBillCreDt(Date billCreDt) {
		this.billCreDt = billCreDt;
	}

	public String getBillUpdId() {
		return billUpdId;
	}

	public void setBillUpdId(String billUpdId) {
		this.billUpdId = billUpdId;
	}

	public Date getBillUpdDt() {
		return billUpdDt;
	}

	public void setBillUpdDt(Date billUpdDt) {
		this.billUpdDt = billUpdDt;
	}

	public List<PurchageBillTubsVo> getPurchageBillTubs() {
		return purchageBillTubs;
	}

	public void setPurchageBillTubs(List<PurchageBillTubsVo> purchageBillTubs) {
		this.purchageBillTubs = purchageBillTubs;
	}

	public List<PurchagePayAmountVo> getPurchagePayAmount() {
		return purchagePayAmount;
	}

	public void setPurchagePayAmount(List<PurchagePayAmountVo> purchagePayAmount) {
		this.purchagePayAmount = purchagePayAmount;
	}

	public List<PurchageCompCountDetailVo> getPurchageCompCountDetail() {
		return purchageCompCountDetail;
	}

	public void setPurchageCompCountDetail(List<PurchageCompCountDetailVo> purchageCompCountDetail) {
		this.purchageCompCountDetail = purchageCompCountDetail;
	}

	public Boolean getBillDispatchedBvrm() {
		return billDispatchedBvrm;
	}

	public void setBillDispatchedBvrm(Boolean billDispatchedBvrm) {
		this.billDispatchedBvrm = billDispatchedBvrm;
	}

	public Boolean getBillDispatchedNsp() {
		return billDispatchedNsp;
	}

	public void setBillDispatchedNsp(Boolean billDispatchedNsp) {
		this.billDispatchedNsp = billDispatchedNsp;
	}

	public String getBillRemarks() {
		return billRemarks;
	}

	public void setBillRemarks(String billRemarks) {
		this.billRemarks = billRemarks;
	}

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

	public String getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}
	
}
