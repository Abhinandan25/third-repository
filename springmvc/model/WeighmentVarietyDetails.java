package com.jme.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="JME_WEIGHMENT_VARIETY_TYPE")
public class WeighmentVarietyDetails implements Serializable{

/*	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;*/
	
	/**
	 * 
	 */
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
	
	public WeighmentVarietyDetails() {}
	
	public WeighmentVarietyDetails(Integer id, Weighment billedBillLotNo, BigDecimal billedBillCount, BigDecimal billedWgtKgs,
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getBilledId() {
		return id;
	}

	public void setBilledId(Integer id) {
		this.id = id;
	}

	//@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.}, fetch = FetchType.EAGER)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BILLD_BILL_VARIETY_LOT_NO")
	public Weighment getBilledBillLotNo() {
		return this.billedBillLotNo;
	}
	

	public void setBilledBillLotNo(Weighment billedBillLotNo) {
		this.billedBillLotNo = billedBillLotNo;
	}
	@Column(name="BILLD_VARIETY_WGT_KGS")
	public BigDecimal getBilledVarietyWgtKgs() {
		return billedVarietyWgtKgs;
	}

	public void setBilledVarietyWgtKgs(BigDecimal billedVarietyWgtKgs) {
		this.billedVarietyWgtKgs = billedVarietyWgtKgs;
	}

		
	@Column(name="BILLD_BILL__VARIETY_COUNT")
	public BigDecimal getBilledBillVarietyCount() {
		return billedBillVarietyCount;
	}

	public void setBilledBillVarietyCount(BigDecimal billedBillVarietyCount) {
		this.billedBillVarietyCount = billedBillVarietyCount;
	}

	@Column(name="BILLD_VARIETY_NAME")
	public String getBilledVarietyName() {
		return billedVarietyName;
	}

	public void setBilledVarietyName(String billedVarietyName) {
		this.billedVarietyName = billedVarietyName;
	}

	@Column(name="BILLD_CRE_ID")
	public String getBilledCreId() {
		return billedCreId;
	}

	public void setBilledCreId(String billedCreId) {
		this.billedCreId = billedCreId;
	}

	@Column(name="BILLD_CRE_DT")
	public Date getBilledCreDt() {
		return billedCreDt;
	}

	public void setBilledCreDt(Date billedCreDt) {
		this.billedCreDt = billedCreDt;
	}

	@Column(name="BILLD_UPD_ID")
	public String getBilledUpdId() {
		return billedUpdId;
	}

	public void setBilledUpdId(String billedUpdId) {
		this.billedUpdId = billedUpdId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BILLD_UPD_DT")
	public Date getBilledUpdDt() {
		return billedUpdDt;
	}

	public void setBilledUpdDt(Date billedUpdDt) {
		this.billedUpdDt = billedUpdDt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
