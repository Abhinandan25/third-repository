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
@Table(name="JME_PURCHASE_WORKFLOW")
public class PurchageWorkflow implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer workflowId;
	private Integer billId;
	private Weighment billlotNo;
	private String billCreId;
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	private String status;
	
	public PurchageWorkflow() {}
	
	public PurchageWorkflow(Integer workflowId, Integer billId, Weighment billlotNo, String billCreId, Date billCreDt,
			String billUpdId, Date billUpdDt,String status) {
		super();
		this.workflowId = workflowId;
		this.billId = billId;
		this.billlotNo = billlotNo;
		this.billCreId = billCreId;
		this.billCreDt = billCreDt;
		this.billUpdId = billUpdId;
		this.billUpdDt = billUpdDt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WORKFLOW_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	
	@Column(name="BILL_ID")
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="LOT_NO")
	public Weighment getBilllotNo() {
		return billlotNo;
	}

	public void setBilllotNo(Weighment billlotNo) {
		this.billlotNo = billlotNo;
	}

	@Column(name="BILLD_CRE_ID")
	public String getBillCreId() {
		return billCreId;
	}

	public void setBillCreId(String billCreId) {
		this.billCreId = billCreId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BILLD_CRE_DT")
	public Date getBillCreDt() {
		return billCreDt;
	}

	public void setBillCreDt(Date billCreDt) {
		this.billCreDt = billCreDt;
	}

	@Column(name="BILLD_UPD_ID")
	public String getBillUpdId() {
		return billUpdId;
	}

	public void setBillUpdId(String billUpdId) {
		this.billUpdId = billUpdId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BILLD_UPD_DT")
	public Date getBillUpdDt() {
		return billUpdDt;
	}

	public void setBillUpdDt(Date billUpdDt) {
		this.billUpdDt = billUpdDt;
	}

	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
