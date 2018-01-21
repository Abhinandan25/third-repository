package com.jme.springmvc.vo;

import java.util.Date;

import com.jme.springmvc.model.Weighment;

public class PurchageWorkflowVo {
	private Integer workflowId;
	private Integer billId;
	private Weighment billlotNo;
	private String billCreId;
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	private String status;
	public Integer getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Weighment getBilllotNo() {
		return billlotNo;
	}
	public void setBilllotNo(Weighment billlotNo) {
		this.billlotNo = billlotNo;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
