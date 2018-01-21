package com.jme.springmvc.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.jme.springmvc.model.Weighment;

public class WeighmentVarietyDetailsVo {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Weighment billedBillLotNo;
	private BigDecimal billedBillVarietyCount;
	private BigDecimal billedVarietyWgtKgs;
	private String billedVarietyName;
	private String billedCreId;
	private Date billedCreDt;
	private String billedUpdId;
	private Date billedUpdDt;
	//private Integer tempId;
	
	public WeighmentVarietyDetailsVo() {}
	
	public WeighmentVarietyDetailsVo(Integer id, Weighment billedBillLotNo, BigDecimal billedBillCount, BigDecimal billedWgtKgs,
			String billedVarietyName, String billedCreId, Date billedCreDt, String billedUpdId, Date billedUpdDt) {
		super();
		this.id = id;
		this.billedBillLotNo = billedBillLotNo;
		this.billedBillVarietyCount = billedBillCount;
		this.billedVarietyWgtKgs = billedWgtKgs;
		this.billedVarietyName=billedVarietyName;
		this.billedCreId = billedCreId;
		this.billedCreDt = billedCreDt;
		this.billedUpdId = billedUpdId;
		this.billedUpdDt = billedUpdDt;
	}

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

	public BigDecimal getBilledBillVarietyCount() {
		return billedBillVarietyCount;
	}

	public void setBilledBillVarietyCount(BigDecimal billedBillVarietyCount) {
		this.billedBillVarietyCount = billedBillVarietyCount;
	}

	public BigDecimal getBilledVarietyWgtKgs() {
		return billedVarietyWgtKgs;
	}

	public void setBilledVarietyWgtKgs(BigDecimal billedVarietyWgtKgs) {
		this.billedVarietyWgtKgs = billedVarietyWgtKgs;
	}

	public String getBilledVarietyName() {
		return billedVarietyName;
	}

	public void setBilledVarietyName(String billedVarietyName) {
		this.billedVarietyName = billedVarietyName;
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
