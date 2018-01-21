package com.jme.springmvc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.jme.springmvc.model.Weighment;

public class WeighmentDetailsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Weighment billedBillLotNo;
	private BigDecimal billedBillCount=BigDecimal.ZERO;
	private BigDecimal billedWgtKgs=BigDecimal.ZERO;
	private String billedNoOfNets;
	private String billedCreId;
	private Date billedCreDt;
	private String billedUpdId;
	private Date billedUpdDt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Weighment getBilledBillLotNo() {
		return billedBillLotNo;
	}
	public void setBilledBillLotNo(Weighment billedBillLotNo) {
		this.billedBillLotNo = billedBillLotNo;
	}
	public BigDecimal getBilledBillCount() {
		return billedBillCount;
	}
	public void setBilledBillCount(BigDecimal billedBillCount) {
		this.billedBillCount = billedBillCount;
	}
	public BigDecimal getBilledWgtKgs() {
		return billedWgtKgs;
	}
	public void setBilledWgtKgs(BigDecimal billedWgtKgs) {
		this.billedWgtKgs = billedWgtKgs;
	}
	public String getBilledNoOfNets() {
		return billedNoOfNets;
	}
	public void setBilledNoOfNets(String billedNoOfNets) {
		this.billedNoOfNets = billedNoOfNets;
	}
	public String getBilledCreId() {
		return billedCreId;
	}
	public void setBilledCreId(String billedCreId) {
		this.billedCreId = billedCreId;
	}
	public Date getBilledCreDt() {
		return billedCreDt;
	}
	public void setBilledCreDt(Date billedCreDt) {
		this.billedCreDt = billedCreDt;
	}
	public String getBilledUpdId() {
		return billedUpdId;
	}
	public void setBilledUpdId(String billedUpdId) {
		this.billedUpdId = billedUpdId;
	}
	public Date getBilledUpdDt() {
		return billedUpdDt;
	}
	public void setBilledUpdDt(Date billedUpdDt) {
		this.billedUpdDt = billedUpdDt;
	}
	
}
