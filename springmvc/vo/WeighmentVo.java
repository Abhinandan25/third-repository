package com.jme.springmvc.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jme.springmvc.model.PurchagePayAmount;
import com.jme.springmvc.model.WeighmentDetails;

public class WeighmentVo implements Serializable{
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
	private String billDate;
	private Boolean billVim;
	private Boolean billBt;
	private String billSignGrader;
	private String verifiedBy;
	private String billHalt;
	private String billCount;
	private String billCreId;
	private String billGraderPh;
	private String billIceQty;
	private List<WeighmentVarietyDetailsVo> weighmentVarietyDetailsVo =new ArrayList<WeighmentVarietyDetailsVo>();
	
	private String billTruckNUmber;
	private String billDriverName;
	private Boolean billDispatchedBvrm;
	private Boolean billDispatchedNsp;
	private Date billDispatchTime;
	private Date billArrivalTime;
	private String billStatus;
	
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	private BigDecimal totalWeight=BigDecimal.ZERO;
	private BigDecimal totalCount=BigDecimal.ZERO;
	private int totalNoOfNets;
	private PurchageWorkflowVo purchageWorkflow ;
	private Map<String,BigDecimal> totalCountQuantity;
	private Map<String,Map<String,BigDecimal>> totalCountVarietyQuantity;
	private List<PurchagePayAmount> purchageAmounts;
	private  BigDecimal totalInvoiceAmt;
	
	private String errorMessage;
	
	private Integer billMaterialTubs;
	private Integer billEmpty;
	private Integer billTotalTubs;
	private Integer billRemainingTubs;
	public Integer getBillRemainingTubs() {
		return billRemainingTubs;
	}

	public void setBillRemainingTubs(Integer billRemainingTubs) {
		this.billRemainingTubs = billRemainingTubs;
	}

	private BigDecimal billSingleNetWeight;
	private BigDecimal billTotalNetWeight;
	
	private Integer billTotalNets;
	public BigDecimal getBillTotalNetWeight() {
		return billTotalNetWeight;
	}

	public void setBillTotalNetWeight(BigDecimal billTotalNetWeight) {
		this.billTotalNetWeight = billTotalNetWeight;
	}

	public Integer getBillTotalNets() {
		return billTotalNets;
	}

	public void setBillTotalNets(Integer billTotalNets) {
		this.billTotalNets = billTotalNets;
	}

	private String billSupervisorName; 
	
	public BigDecimal getTotalInvoiceAmt() {
		return totalInvoiceAmt;
	}

	public void setTotalInvoiceAmt(BigDecimal totalInvoiceAmt) {
		this.totalInvoiceAmt = totalInvoiceAmt;
	}

	public String getBillIceQty() {
		return billIceQty;
	}

	public List<PurchagePayAmount> getPurchageAmounts() {
		return purchageAmounts;
	}

	public void setPurchageAmounts(List<PurchagePayAmount> purchageAmounts) {
		this.purchageAmounts = purchageAmounts;
	}

	public void setBillIceQty(String billIceQty) {
		this.billIceQty = billIceQty;
	}

	public String getBillPlantName() {
		return billPlantName;
	}

	public void setBillPlantName(String billPlantName) {
		this.billPlantName = billPlantName;
	}

	private String billPlantName;
	public String getBillGraderPh() {
		return billGraderPh;
	}

	public void setBillGraderPh(String billGraderPh) {
		this.billGraderPh = billGraderPh;
	}

	public Map<String, BigDecimal> getTotalCountQuantity() {
		return totalCountQuantity;
	}

	public void setTotalCountQuantity(Map<String, BigDecimal> totalCountQuantity) {
		this.totalCountQuantity = totalCountQuantity;
	}
	
	public PurchageWorkflowVo getPurchageWorkflow() {
		return purchageWorkflow;
	}

	public void setPurchageWorkflow(PurchageWorkflowVo purchageWorkflow) {
		this.purchageWorkflow = purchageWorkflow;
	}
	
	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public BigDecimal getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(BigDecimal totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalNoOfNets() {
		return totalNoOfNets;
	}

	public void setTotalNoOfNets(int totalNoOfNets) {
		this.totalNoOfNets = totalNoOfNets;
	}

	private List<WeighmentDetailsVo> weighmentBillDetails =new ArrayList<WeighmentDetailsVo>();
	public Integer getBillLotNo() {
		return billLotNo;
	}

	public void setBillLotNo(Integer billLotNo) {
		this.billLotNo = billLotNo;
	}

	public String getBillPlantId() {
		return billPlantId;
	}

	public void setBillPlantId(String billPlantId) {
		this.billPlantId = billPlantId;
	}

	public String getBillChequeName() {
		return billChequeName;
	}

	public void setBillChequeName(String billChequeName) {
		this.billChequeName = billChequeName;
	}

	public String getBillFormerName() {
		return billFormerName;
	}

	public void setBillFormerName(String billFormerName) {
		this.billFormerName = billFormerName;
	}

	public String getBillFormerMobile() {
		return billFormerMobile;
	}

	public void setBillFormerMobile(String billFormerMobile) {
		this.billFormerMobile = billFormerMobile;
	}

	public String getBillAgentName() {
		return billAgentName;
	}

	public void setBillAgentName(String billAgentName) {
		this.billAgentName = billAgentName;
	}

	public String getBillAgentMobile() {
		return billAgentMobile;
	}

	public void setBillAgentMobile(String billAgentMobile) {
		this.billAgentMobile = billAgentMobile;
	}

	public String getBillPlace() {
		return billPlace;
	}

	public void setBillPlace(String billPlace) {
		this.billPlace = billPlace;
	}

	
	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Boolean getBillVim() {
		return billVim;
	}

	public void setBillVim(Boolean billVim) {
		this.billVim = billVim;
	}

	public Boolean getBillBt() {
		return billBt;
	}

	public void setBillBt(Boolean billBt) {
		this.billBt = billBt;
	}

	public String getBillSignGrader() {
		return billSignGrader;
	}

	public void setBillSignGrader(String billSignGrader) {
		this.billSignGrader = billSignGrader;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getBillHalt() {
		return billHalt;
	}

	public void setBillHalt(String billHalt) {
		this.billHalt = billHalt;
	}

	public String getBillCount() {
		return billCount;
	}

	public void setBillCount(String billCount) {
		this.billCount = billCount;
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

	public List<WeighmentDetailsVo> getWeighmentBillDetails() {
		return weighmentBillDetails;
	}

	public void setWeighmentBillDetails(List<WeighmentDetailsVo> weighmentBillDetails) {
		this.weighmentBillDetails = weighmentBillDetails;
	}

	public void setBillUpdDt(Date billUpdDt) {
		this.billUpdDt = billUpdDt;
	}

	public String getBillTruckNUmber() {
		return billTruckNUmber;
	}

	public void setBillTruckNUmber(String billTruckNUmber) {
		this.billTruckNUmber = billTruckNUmber;
	}

	public String getBillDriverName() {
		return billDriverName;
	}

	public void setBillDriverName(String billDriverName) {
		this.billDriverName = billDriverName;
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

	public Date  getBillDispatchTime() {
		return billDispatchTime;
	}

	public void setBillDispatchTime(Date  billDispatchTime) {
		this.billDispatchTime = billDispatchTime;
	}

	public Date getBillArrivalTime() {
		return billArrivalTime;
	}

	public void setBillArrivalTime(Date billArrivalTime) {
		this.billArrivalTime = billArrivalTime;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getBillMaterialTubs() {
		return billMaterialTubs;
	}

	public void setBillMaterialTubs(Integer billMaterialTubs) {
		this.billMaterialTubs = billMaterialTubs;
	}

	public Integer getBillEmpty() {
		return billEmpty;
	}

	public void setBillEmpty(Integer billEmpty) {
		this.billEmpty = billEmpty;
	}

	public Integer getBillTotalTubs() {
		return billTotalTubs;
	}

	public void setBillTotalTubs(Integer billTotalTubs) {
		this.billTotalTubs = billTotalTubs;
	}

	public BigDecimal getBillSingleNetWeight() {
		return billSingleNetWeight;
	}

	public void setBillSingleNetWeight(BigDecimal billSingleNetWeight) {
		this.billSingleNetWeight = billSingleNetWeight;
	}

	public String getBillSupervisorName() {
		return billSupervisorName;
	}

	public void setBillSupervisorName(String billSupervisorName) {
		this.billSupervisorName = billSupervisorName;
	}

	public List<WeighmentVarietyDetailsVo> getWeighmentVarietyDetailsVo() {
		return weighmentVarietyDetailsVo;
	}

	public void setWeighmentVarietyDetailsVo(List<WeighmentVarietyDetailsVo> weighmentVarietyDetailsVo) {
		this.weighmentVarietyDetailsVo = weighmentVarietyDetailsVo;
	}

	public Map<String, Map<String, BigDecimal>> getTotalCountVarietyQuantity() {
		return totalCountVarietyQuantity;
	}

	public void setTotalCountVarietyQuantity(Map<String, Map<String, BigDecimal>> totalCountVarietyQuantity) {
		this.totalCountVarietyQuantity = totalCountVarietyQuantity;
	}
	
}
