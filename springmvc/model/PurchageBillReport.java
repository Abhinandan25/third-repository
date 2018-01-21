package com.jme.springmvc.model;

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
@Entity
@Table(name="JME_PURCHASE_BILL_REPORT")
public class PurchageBillReport implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer billId;
	private Weighment billReportLotNo;
	private String billDriverName;
	private String billGraderName;

	private String billPurchageManager;
	private String billPurchageAuthorized;
	private String billPlantManager;
	private String billAccountManager;
	private String billAuthorized;
	private Boolean billCertificate;
	private Boolean billNoCertificate;
	
	private String billCreId;
	private Date billCreDt;
	private String billUpdId;
	private Date billUpdDt;
	
	private Boolean billDispatchedBvrm;
	private Boolean billDispatchedNsp;
	
	private String billRemarks;
	
	private BigDecimal totalInvoiceAmt;
	
	private BigDecimal totalInvoiceQuantity;
	
	private List<PurchageBillTubs> purchageBillTubs =new ArrayList<PurchageBillTubs>();
	
	private List<PurchagePayAmount> purchagePayAmount =new ArrayList<PurchagePayAmount>();
	

	private List<PurchageCompCountDetail> purchageCompCountDetail =new ArrayList<PurchageCompCountDetail>();
	
	private Date billDueDate;
	
	private InvoiceReport invoiceReport=new InvoiceReport();
	
	public PurchageBillReport() {}
	
	public PurchageBillReport(Integer billId, Weighment billReportLotNo, String billDriverName, String billGraderName,
			String billSupervisorName, String billPurchageManager, String billPurchageAuthorized,
			String billPlantManager, String billAccountManager, String billAuthorized,String billCreId
			,Date billCreDt,String billUpdId,Date billUpdDt) {
		super();
		this.billId = billId;
		this.billReportLotNo = billReportLotNo;
		this.billDriverName = billDriverName;
		this.billGraderName = billGraderName;
		this.billPurchageManager = billPurchageManager;
		this.billPurchageAuthorized = billPurchageAuthorized;
		this.billPlantManager = billPlantManager;
		this.billAccountManager = billAccountManager;
		this.billAuthorized = billAuthorized;
		this.billCreId=billCreId;
		this.billCreDt=billCreDt;
		this.billUpdId=billUpdId;
		this.billUpdDt=billUpdDt;
	}


	public PurchageBillReport(Integer billId, String billDriverName, String billGraderName, String billSupervisorName,
			String billPurchageManager, String billPurchageAuthorized, String billPlantManager,
			String billAccountManager, String billAuthorized,String billCreId
			,Date billCreDt,String billUpdId,Date billUpdDt) {
		super();
		this.billId = billId;
		this.billDriverName = billDriverName;
		this.billGraderName = billGraderName;
		this.billPurchageManager = billPurchageManager;
		this.billPurchageAuthorized = billPurchageAuthorized;
		this.billPlantManager = billPlantManager;
		this.billAccountManager = billAccountManager;
		this.billAuthorized = billAuthorized;
		this.billCreId=billCreId;
		this.billCreDt=billCreDt;
		this.billUpdId=billUpdId;
		this.billUpdDt=billUpdDt;
	}
	

	public PurchageBillReport(Integer billId, Weighment billReportLotNo, String billDriverName, String billGraderName,
			String billSupervisorName, String billPurchageManager, String billPurchageAuthorized,
			String billPlantManager, String billAccountManager, String billAuthorized,String billCreId
			,Date billCreDt,String billUpdId,Date billUpdDt,
			List<PurchageBillTubs> purchageBillTubs,List<PurchagePayAmount> purchagePayAmount) {
		super();
		this.billId = billId;
		this.billReportLotNo = billReportLotNo;
		this.billDriverName = billDriverName;
		this.billGraderName = billGraderName;
		this.billPurchageManager = billPurchageManager;
		this.billPurchageAuthorized = billPurchageAuthorized;
		this.billPlantManager = billPlantManager;
		this.billAccountManager = billAccountManager;
		this.billAuthorized = billAuthorized;
		this.billCreId=billCreId;
		this.billCreDt=billCreDt;
		this.billUpdId=billUpdId;
		this.billUpdDt=billUpdDt;
		this.purchageBillTubs = purchageBillTubs;
		this.purchagePayAmount=purchagePayAmount;
		
	}
	
	

	public PurchageBillReport(Integer billId, Weighment billReportLotNo, String billDriverName, String billGraderName,
			String billSupervisorName, String billPurchageManager, String billPurchageAuthorized,
			String billPlantManager, String billAccountManager, String billAuthorized,String billCreId
			,Date billCreDt,String billUpdId,Date billUpdDt,
			List<PurchagePayAmount> purchagePayAmount) {
		super();
		this.billId = billId;
		this.billReportLotNo = billReportLotNo;
		this.billDriverName = billDriverName;
		this.billGraderName = billGraderName;
		this.billPurchageManager = billPurchageManager;
		this.billPurchageAuthorized = billPurchageAuthorized;
		this.billPlantManager = billPlantManager;
		this.billAccountManager = billAccountManager;
		this.billAuthorized = billAuthorized;
		this.billCreId=billCreId;
		this.billCreDt=billCreDt;
		this.billUpdId=billUpdId;
		this.billUpdDt=billUpdDt;
		this.purchagePayAmount = purchagePayAmount;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BILL_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BILL_REPORT_LOT_NO")
	public Weighment getBillReportLotNo() {
		return billReportLotNo;
	}

	public void setBillReportLotNo(Weighment billReportLotNo) {
		this.billReportLotNo = billReportLotNo;
	}
	
	@Column(name="BILL_DRIVER_NAME")
	public String getBillDriverName() {
		return billDriverName;
	}

	public void setBillDriverName(String billDriverName) {
		this.billDriverName = billDriverName;
	}

	@Column(name="BILL_GRADER_NAME")
	public String getBillGraderName() {
		return billGraderName;
	}

	public void setBillGraderName(String billGraderName) {
		this.billGraderName = billGraderName;
	}

	@Column(name="BILL_PURCHAGE_MANAGER")
	public String getBillPurchageManager() {
		return billPurchageManager;
	}

	public void setBillPurchageManager(String billPurchageManager) {
		this.billPurchageManager = billPurchageManager;
	}

	@Column(name="BILL_PURCHAGE_AUTHORIZED")
	public String getBillPurchageAuthorized() {
		return billPurchageAuthorized;
	}

	public void setBillPurchageAuthorized(String billPurchageAuthorized) {
		this.billPurchageAuthorized = billPurchageAuthorized;
	}

	@Column(name="BILL_PLANT_MANAGER")
	public String getBillPlantManager() {
		return billPlantManager;
	}

	public void setBillPlantManager(String billPlantManager) {
		this.billPlantManager = billPlantManager;
	}

	@Column(name="BILL_ACCOUNT_MANAGER")
	public String getBillAccountManager() {
		return billAccountManager;
	}

	public void setBillAccountManager(String billAccountManager) {
		this.billAccountManager = billAccountManager;
	}

	@Column(name="BILL_AUTHORIZED")
	public String getBillAuthorized() {
		return billAuthorized;
	}

	public void setBillAuthorized(String billAuthorized) {
		this.billAuthorized = billAuthorized;
	}

	@Column(name="BILL_CERTIFICATE")
	public Boolean getBillCertificate() {
		return billCertificate;
	}

	public void setBillCertificate(Boolean billCertificate) {
		this.billCertificate = billCertificate;
	}

	@Column(name="BILL_NO_CERTIFICATE")
	public Boolean getBillNoCertificate() {
		return billNoCertificate;
	}

	public void setBillNoCertificate(Boolean billNoCertificate) {
		this.billNoCertificate = billNoCertificate;
	}

	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="billBillId")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	public List<PurchageBillTubs> getPurchageBillTubs() {
		return purchageBillTubs;
	}

	public void setPurchageBillTubs(List<PurchageBillTubs> purchageBillTubs) {
		this.purchageBillTubs = purchageBillTubs;
	}

	@OneToMany(fetch = FetchType.EAGER,mappedBy="billPayBillId")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	public List<PurchagePayAmount> getPurchagePayAmount() {
		return purchagePayAmount;
	}

	public void setPurchagePayAmount(List<PurchagePayAmount> purchagePayAmount) {
		this.purchagePayAmount = purchagePayAmount;
	}

	@OneToMany(fetch = FetchType.EAGER,mappedBy="billBillId")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	public List<PurchageCompCountDetail> getPurchageCompCountDetail() {
		return purchageCompCountDetail;
	}

	public void setPurchageCompCountDetail(List<PurchageCompCountDetail> purchageCompCountDetail) {
		this.purchageCompCountDetail = purchageCompCountDetail;
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

	@Column(name="BILL_STATUS")
	public String getBillRemarks() {
		return billRemarks;
	}

	public void setBillRemarks(String billRemarks) {
		this.billRemarks = billRemarks;
	}
	
	@Column(name="TOTAL_INVOICE_AMT")
	public BigDecimal getTotalInvoiceAmt() {
		return totalInvoiceAmt;
	}

	public void setTotalInvoiceAmt(BigDecimal totalInvoiceAmt) {
		this.totalInvoiceAmt = totalInvoiceAmt;
	}

	@Column(name="TOTAL_INVOICE_QTY")
	public BigDecimal getTotalInvoiceQuantity() {
		return totalInvoiceQuantity;
	}

	public void setTotalInvoiceQuantity(BigDecimal totalInvoiceQuantity) {
		this.totalInvoiceQuantity = totalInvoiceQuantity;
	}

	@Column(name="BILL_DUE_DATE")
	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	/*@OneToOne(fetch = FetchType.EAGER,mappedBy="billReportlotNo")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	public InvoiceReport getInvoiceReport() {
		return invoiceReport;
	}

	public void setInvoiceReport(InvoiceReport invoiceReport) {
		this.invoiceReport = invoiceReport;
	}*/
	
}
