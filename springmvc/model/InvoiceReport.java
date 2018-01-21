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
@Table(name="INVOICE_REPORT")
public class InvoiceReport implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer invoiceId;
	private String formerName;
	private String invoiceStatus;
	private String errorStatus;
	private String voucherNumber;
	private String voucherId;
	private String invoiceRemoteId;
	private Date createDate;
	private Date createTime;
	private String createdBy;
	private Integer invoiceLotNo;
	
	public InvoiceReport() {}

	public InvoiceReport(Integer invoiceId, String formerName, String invoiceStatus,
			String errorStatus, String voucherNumber, String voucherId, String invoiceRemoteId) {
		super();
		this.invoiceId = invoiceId;
		this.formerName = formerName;
		this.invoiceStatus = invoiceStatus;
		this.errorStatus = errorStatus;
		this.voucherNumber = voucherNumber;
		this.voucherId = voucherId;
		this.invoiceRemoteId = invoiceRemoteId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name="FORMER_NAME")
	public String getFormerName() {
		return formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}

	

	@Column(name="INVOICE_STATUS")
	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	@Column(name="ERROR_MESSAGES")
	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	@Column(name="VOUCHER_NUMBER")
	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	@Column(name="VOUCHER_ID")
	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	@Column(name="INVOICE_REMOTE_ID")
	public String getInvoiceRemoteId() {
		return invoiceRemoteId;
	}

	public void setInvoiceRemoteId(String invoiceRemoteId) {
		this.invoiceRemoteId = invoiceRemoteId;
	}

	@Column(name="CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="INVOICE_LOT_NO")
	public Integer getInvoiceLotNo() {
		return invoiceLotNo;
	}

	public void setInvoiceLotNo(Integer invoiceLotNo) {
		this.invoiceLotNo = invoiceLotNo;
	}
	
	
	
}
