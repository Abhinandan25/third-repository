package com.jme.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.type.TrueFalseType;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="JME_WEIGHMENT")
public class Weighment implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billLotNo;
	private String billPlantId;
	private String billChequeName;
	private String billFormerName;
	private String billFormerMobile; 
	private String billAgentName;
	private String billAgentMobile;
	private String billPlace;
	
	private Date billDate;
	private Boolean billVim;
	private Boolean billBt;
	private String billSignGrader;
	private String verifiedBy;
	private String billHalt;
	private String billCount;
	private String billCreId;
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	
	private String billTruckNUmber;
	private String billDriverName;
	private Boolean billDispatchedBvrm;
	private Boolean billDispatchedNsp;
	private Date  billDispatchTime;
	private Date billArrivalTime;
	private String billStatus;
	
	private Integer billMaterialTubs;
	private Integer billEmpty;
	private Integer billTotalTubs;
	private BigDecimal billSingleNetWeight;
	
	private String billSupervisorName; 
	
	private BigDecimal billTotalNetWeight;
	private Integer billTotalNets;
	
	
	@Column(name="BILL_ICE_QTY")
	public BigDecimal getBillIceQty() {
		return billIceQty;
	}

	public void setBillIceQty(BigDecimal billIceQty) {
		this.billIceQty = billIceQty;
	}
	@Column(name="BILL_GRADER_PH")
	public String getBillGraderPh() {
		return billGraderPh;
	}

	public void setBillGraderPh(String billGraderPh) {
		this.billGraderPh = billGraderPh;
	}

	private BigDecimal billIceQty;
	private String billGraderPh;
	
	private List<WeighmentDetails> purchageBillDetails =new ArrayList<WeighmentDetails>();
	private List<WeighmentVarietyDetails> weighmentVarietyDetails=new ArrayList<WeighmentVarietyDetails>();
	
	private PurchageBillReport purchageBillReport =new PurchageBillReport();
	
	private PurchageWorkflow purchageWorkflow =new PurchageWorkflow();
	
	public Weighment() {}

	public Weighment(Integer billLotNo, String billPlantId, String billChequeName,
			String billFormerName, String billFormerMobile, String billAgentName, String billAgentMobile,
			String billPlace, Date billDate, Boolean billVim, Boolean billBt, String billSignGrader, String verifiedBy,
			String billHalt, String billCount, String billCreId, Date billCreDt, String billUpdId, Date billUpdDt,String billTruckNUmber,String billDriverName,
			java.sql.Date billDispatchTime,Date billArrivalTime,String billStatus) {
		this.billLotNo = billLotNo;
		this.billPlantId = billPlantId;
		this.billChequeName = billChequeName;
		this.billFormerName = billFormerName;
		this.billFormerMobile = billFormerMobile;
		this.billAgentName = billAgentName;
		this.billAgentMobile = billAgentMobile;
		this.billPlace = billPlace;
		this.billDate = billDate;
		this.billVim = billVim;
		this.billBt = billBt;
		this.billSignGrader = billSignGrader;
		this.verifiedBy = verifiedBy;
		this.billHalt = billHalt;
		this.billCount = billCount;
		this.billCreId = billCreId;
		this.billCreDt = billCreDt;
		this.billUpdId = billUpdId;
		this.billUpdDt = billUpdDt;
		this.billTruckNUmber=billTruckNUmber;
		this.billDriverName=billDriverName;
		this.billDispatchTime=billDispatchTime;
		this.billArrivalTime=billArrivalTime;
		this.billStatus=billStatus;
	}

	
	public Weighment(Integer billLotNo, String billPlantId, String billChequeName,
			String billFormerName, String billFormerMobile, String billAgentName, String billAgentMobile,
			String billPlace, Date billDate, Boolean billVim, Boolean billBt, String billSignGrader, String verifiedBy,
			String billHalt, String billCount, String billCreId, Date billCreDt, String billUpdId, Date billUpdDt,String billTruckNUmber,String billDriverName,
			java.sql.Date billDispatchTime,Date billArrivalTime,String billStatus,
			List<WeighmentDetails> purchageBillDetails,List<WeighmentVarietyDetails> weighmentVarietyDetails) {
		this.billLotNo = billLotNo;
		this.billPlantId = billPlantId;
		this.billChequeName = billChequeName;
		this.billFormerName = billFormerName;
		this.billFormerMobile = billFormerMobile;
		this.billAgentName = billAgentName;
		this.billAgentMobile = billAgentMobile;
		this.billPlace = billPlace;
		this.billDate = billDate;
		this.billVim = billVim;
		this.billBt = billBt;
		this.billSignGrader = billSignGrader;
		this.verifiedBy = verifiedBy;
		this.billHalt = billHalt;
		this.billCount = billCount;
		this.billCreId = billCreId;
		this.billCreDt = billCreDt;
		this.billUpdId = billUpdId;
		this.billUpdDt = billUpdDt;
		this.billTruckNUmber=billTruckNUmber;
		this.billDriverName=billDriverName;
		this.billDispatchTime=billDispatchTime;
		this.billArrivalTime=billArrivalTime;
		this.billStatus=billStatus;
		this.purchageBillDetails = purchageBillDetails;
		this.weighmentVarietyDetails=weighmentVarietyDetails;
	}
	
	public Weighment(Integer billLotNo, String billPlantId, String billChequeName, String billFormerName,
			String billFormerMobile, String billAgentName, String billAgentMobile, String billPlace, Date billDate,
			Boolean billVim, Boolean billBt, String billSignGrader, String verifiedBy, String billHalt, String billCount,
			String billCreId, Date billCreDt, String billUpdId, Date billUpdDt,String billTruckNUmber,String billDriverName,
			java.sql.Date billDispatchTime,Date billArrivalTime,String billStatus,
			List<WeighmentDetails> purchageBillDetails, PurchageBillReport purchageBillReport,PurchageWorkflow purchageWorkflow,List<WeighmentVarietyDetails> weighmentVarietyDetails) {
		super();
		this.billLotNo = billLotNo;
		this.billPlantId = billPlantId;
		this.billChequeName = billChequeName;
		this.billFormerName = billFormerName;
		this.billFormerMobile = billFormerMobile;
		this.billAgentName = billAgentName;
		this.billAgentMobile = billAgentMobile;
		this.billPlace = billPlace;
		this.billDate = billDate;
		this.billVim = billVim;
		this.billBt = billBt;
		this.billSignGrader = billSignGrader;
		this.verifiedBy = verifiedBy;
		this.billHalt = billHalt;
		this.billCount = billCount;
		this.billCreId = billCreId;
		this.billCreDt = billCreDt;
		this.billUpdId = billUpdId;
		this.billUpdDt = billUpdDt;
		this.billTruckNUmber=billTruckNUmber;
		this.billDriverName=billDriverName;
		this.billDispatchTime=billDispatchTime;
		this.billArrivalTime=billArrivalTime;
		this.billStatus=billStatus;
		this.purchageBillDetails = purchageBillDetails;
		this.purchageBillReport = purchageBillReport;
		this.purchageWorkflow=purchageWorkflow;
		this.weighmentVarietyDetails=weighmentVarietyDetails;
	}

	public Weighment(Integer billLotNo, String billPlantId, String billChequeName, String billFormerName,
			String billFormerMobile, String billAgentName, String billAgentMobile, String billPlace, Date billDate,
			Boolean billVim, Boolean billBt, String billSignGrader, String verifiedBy, String billHalt,
			String billCount, String billCreId, Date billCreDt, String billUpdId, Date billUpdDt,
			String billTruckNUmber, String billDriverName, Boolean billDispatchedBvrm, Boolean billDispatchedNsp,
			Date billDispatchTime, Date billArrivalTime, String billStatus, Integer billMaterialTubs, Integer billEmpty,
			Integer billTotalTubs, BigDecimal billNetWeight, BigDecimal billIceQty, String billGraderPh,
			List<WeighmentDetails> purchageBillDetails, PurchageBillReport purchageBillReport,
			PurchageWorkflow purchageWorkflow,List<WeighmentVarietyDetails> weighmentVarietyDetails) {
		super();
		this.billLotNo = billLotNo;
		this.billPlantId = billPlantId;
		this.billChequeName = billChequeName;
		this.billFormerName = billFormerName;
		this.billFormerMobile = billFormerMobile;
		this.billAgentName = billAgentName;
		this.billAgentMobile = billAgentMobile;
		this.billPlace = billPlace;
		this.billDate = billDate;
		this.billVim = billVim;
		this.billBt = billBt;
		this.billSignGrader = billSignGrader;
		this.verifiedBy = verifiedBy;
		this.billHalt = billHalt;
		this.billCount = billCount;
		this.billCreId = billCreId;
		this.billCreDt = billCreDt;
		this.billUpdId = billUpdId;
		this.billUpdDt = billUpdDt;
		this.billTruckNUmber = billTruckNUmber;
		this.billDriverName = billDriverName;
		this.billDispatchedBvrm = billDispatchedBvrm;
		this.billDispatchedNsp = billDispatchedNsp;
		this.billDispatchTime = billDispatchTime;
		this.billArrivalTime = billArrivalTime;
		this.billStatus = billStatus;
		this.billMaterialTubs = billMaterialTubs;
		this.billEmpty = billEmpty;
		this.billTotalTubs = billTotalTubs;
		this.billSingleNetWeight = billSingleNetWeight;
		this.billIceQty = billIceQty;
		this.billGraderPh = billGraderPh;
		this.purchageBillDetails = purchageBillDetails;
		this.purchageBillReport = purchageBillReport;
		this.purchageWorkflow = purchageWorkflow;
		this.weighmentVarietyDetails=weighmentVarietyDetails;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOT_NO",unique=true,nullable=false,length=20,insertable = false)
	public Integer getBillLotNo() {
		return billLotNo;
	}


	public void setBillLotNo(Integer billLotNo) {
		this.billLotNo = billLotNo;
	}

	@Column(name="PLANT_ID",updatable=true)
	public String getBillPlantId() {
		return billPlantId;
	}


	public void setBillPlantId(String billPlantId) {
		this.billPlantId = billPlantId;
	}

	@Column(name="CHQUE_NAME",nullable=false)
	public String getBillChequeName() {
		return billChequeName;
	}


	public void setBillChequeName(String billChequeName) {
		this.billChequeName = billChequeName;
	}

	@Column(name="FARMER_NAME",nullable=false)
	public String getBillFormerName() {
		return billFormerName;
	}


	public void setBillFormerName(String billFormerName) {
		this.billFormerName = billFormerName;
	}

	@Column(name="FARMER_MOBILE")
	public String getBillFormerMobile() {
		return billFormerMobile;
	}


	public void setBillFormerMobile(String billFormerMobile) {
		this.billFormerMobile = billFormerMobile;
	}

	@Column(name="AGENT_NAME",nullable=false)
	public String getBillAgentName() {
		return billAgentName;
	}


	public void setBillAgentName(String billAgentName) {
		this.billAgentName = billAgentName;
	}

	@Column(name="AGENT_MOBILE")
	public String getBillAgentMobile() {
		return billAgentMobile;
	}


	public void setBillAgentMobile(String billAgentMobile) {
		this.billAgentMobile = billAgentMobile;
	}

	@Column(name="PLACE",nullable=false)
	public String getBillPlace() {
		return billPlace;
	}


	public void setBillPlace(String billPlace) {
		this.billPlace = billPlace;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getBillDate() {
		return billDate;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Column(name="VIM")
	public Boolean getBillVim() {
		return billVim;
	}


	public void setBillVim(Boolean billVim) {
		this.billVim = billVim;
	}

	@Column(name="BT")
	public Boolean getBillBt() {
		return billBt;
	}


	public void setBillBt(Boolean billBt) {
		this.billBt = billBt;
	}

	@Column(name="SIGN_GRADER")
	public String getBillSignGrader() {
		return billSignGrader;
	}


	public void setBillSignGrader(String billSignGrader) {
		this.billSignGrader = billSignGrader;
	}

	@Column(name="VERIFYED_BY")
	public String getVerifiedBy() {
		return verifiedBy;
	}


	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	@Column(name="HALT")
	public String getBillHalt() {
		return billHalt;
	}


	public void setBillHalt(String billHalt) {
		this.billHalt = billHalt;
	}

	@Column(name="COUNT")
	public String getBillCount() {
		return billCount;
	}


	public void setBillCount(String billCount) {
		this.billCount = billCount;
	}

	@Column(name="CRE_ID")
	public String getBillCreId() {
		return billCreId;
	}


	public void setBillCreId(String billCreId) {
		this.billCreId = billCreId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CRE_DT")
	public Date getBillCreDt() {
		return billCreDt;
	}


	public void setBillCreDt(Date billCreDt) {
		this.billCreDt = billCreDt;
	}

	@Column(name="UPD_ID")
	public String getBillUpdId() {
		return billUpdId;
	}


	public void setBillUpdId(String billUpdId) {
		this.billUpdId = billUpdId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPD_DT")
	public Date getBillUpdDt() {
		return billUpdDt;
	}


	public void setBillUpdDt(Date billUpdDt) {
		this.billUpdDt = billUpdDt;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="billedBillLotNo")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	public List<WeighmentDetails> getPurchageBillDetails() {
		return purchageBillDetails;
	}

	public void setPurchageBillDetails(List<WeighmentDetails> purchageBillDetails) {
		this.purchageBillDetails = purchageBillDetails;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy="billedBillLotNo")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	public List<WeighmentVarietyDetails> getWeighmentVarietyDetails() {
		return weighmentVarietyDetails;
	}

	public void setWeighmentVarietyDetails(List<WeighmentVarietyDetails> weighmentVarietyDetails) {
		this.weighmentVarietyDetails = weighmentVarietyDetails;
	}

	@OneToOne(fetch = FetchType.EAGER,mappedBy="billReportLotNo")
	//@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	public PurchageBillReport getPurchageBillReport() {
		return purchageBillReport;
	}

	public void setPurchageBillReport(PurchageBillReport purchageBillReport) {
		this.purchageBillReport = purchageBillReport;
	}
	
	@Column(name="BILL_TRUCK_NUMBER")
	public String getBillTruckNUmber() {
		return billTruckNUmber;
	}

	public void setBillTruckNUmber(String billTruckNUmber) {
		this.billTruckNUmber = billTruckNUmber;
	}

	@Column(name="BILL_DRIVER_NAME")
	public String getBillDriverName() {
		return billDriverName;
	}

	public void setBillDriverName(String billDriverName) {
		this.billDriverName = billDriverName;
	}

	@Column(name="bill_dispatched_bvrm")
	public Boolean getBillDispatchedBvrm() {
		return billDispatchedBvrm;
	}

	public void setBillDispatchedBvrm(Boolean billDispatchedBvrm) {
		this.billDispatchedBvrm = billDispatchedBvrm;
	}

	@Column(name="bill_dispatched_nsp")
	public Boolean getBillDispatchedNsp() {
		return billDispatchedNsp;
	}

	public void setBillDispatchedNsp(Boolean billDispatchedNsp) {
		this.billDispatchedNsp = billDispatchedNsp;
	}

	
	@Column(name="BILL_DISPATCH_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date  getBillDispatchTime() {
		return billDispatchTime;
	}

	public void setBillDispatchTime(Date  billDispatchTime) {
		this.billDispatchTime = billDispatchTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BILL_ARRIVAL_TIME")
	public Date getBillArrivalTime() {
		return billArrivalTime;
	}

	public void setBillArrivalTime(Date billArrivalTime) {
		this.billArrivalTime = billArrivalTime;
	}

	@Column(name="BILL_STATUS")
	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	@OneToOne(fetch = FetchType.EAGER,mappedBy="billlotNo")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	public PurchageWorkflow getPurchageWorkflow() {
		return purchageWorkflow;
	}

	public void setPurchageWorkflow(PurchageWorkflow purchageWorkflow) {
		this.purchageWorkflow = purchageWorkflow;
	}

	@Column(name="BILLD_MATERIAL_TUBS")
	public Integer getBillMaterialTubs() {
		return billMaterialTubs;
	}

	public void setBillMaterialTubs(Integer billMaterialTubs) {
		this.billMaterialTubs = billMaterialTubs;
	}

	@Column(name="BILLD_EMPTY")
	public Integer getBillEmpty() {
		return billEmpty;
	}

	public void setBillEmpty(Integer billEmpty) {
		this.billEmpty = billEmpty;
	}

	@Column(name="BILLD_TOTAL_TUBS")
	public Integer getBillTotalTubs() {
		return billTotalTubs;
	}

	public void setBillTotalTubs(Integer billTotalTubs) {
		this.billTotalTubs = billTotalTubs;
	}

	@Column(name="SINGLE_NET_WEIGHT")
	public BigDecimal getBillSingleNetWeight() {
		return billSingleNetWeight;
	}

	public void setBillSingleNetWeight(BigDecimal billSingleNetWeight) {
		this.billSingleNetWeight = billSingleNetWeight;
	}	

	@Column(name="BILL_SUPERVISOR_NAME")
	public String getBillSupervisorName() {
		return billSupervisorName;
	}

	public void setBillSupervisorName(String billSupervisorName) {
		this.billSupervisorName = billSupervisorName;
	}

	@Column(name="BILLD_TOTAL_NET_WEIGHT")
	public BigDecimal getBillTotalNetWeight() {
		return billTotalNetWeight;
	}

	public void setBillTotalNetWeight(BigDecimal billTotalNetWeight) {
		this.billTotalNetWeight = billTotalNetWeight;
	}

	@Column(name="BILLD_TOTAL_NETS")
	public Integer getBillTotalNets() {
		return billTotalNets;
	}

	public void setBillTotalNets(Integer billTotalNets) {
		this.billTotalNets = billTotalNets;
	}
}
