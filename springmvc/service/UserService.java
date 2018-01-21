package com.jme.springmvc.service;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.model.WeighmentVarietyDetails;
import com.jme.springmvc.vo.WeighmentVo;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.InvoiceReport;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.PurchagePlant;
import com.jme.springmvc.model.PurchageShrimpVariety;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findBySSO(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);
	
	void savePurchageBill(Weighment purchaseBill);
	
	void savePurchageBillDraft(WeighmentTemp purchaseBill);
	
	void savePurchageBillDetails(WeighmentDetails purchaseBillDetails);
	
	public Weighment findByLotId(int id);
	
	public List<Weighment> findByType(String chequeName,String farmer,String place,Integer lotNo,String agentName,String date);
	
	public void savePurchageBillReport(PurchageBillReport purchageBillReport);
	
	public List<Integer> findBillCount(Integer lotNo);
	
	public void savePurchaseWorkflow(PurchageWorkflow purchageWorkflow);
	
	public void updatePurchageBill(Weighment purchaseBill);
	
	public PurchageWorkflow findByWorkFlowId(Integer id);
	
	public void updatePurchaseBill(PurchageWorkflow purchaseBill);
	
	public List<PurchagePlant> findAllPlantDetails();
	
	public void updateWeighment(Weighment weighment);
	public PurchagePlant findByPlantId(Integer id);
	
	public PurchageShrimpVariety findByVarietyId(Integer id);
	
	public List<PurchageShrimpVariety> findAllPlantVarietyDetails();

	public PurchageBillReport findByPurchageLotId(Integer id);
	
	public void updatePurchageBillReport(PurchageBillReport purchageBillReport);
	
	public List<Weighment> findAllWeighmentWithStatus();
	
	public void saveInvoiceReport(InvoiceReport invoiceReport);
	
	public List<InvoiceReport> findByType(String voucherNumber,String farmer,Integer lotNo,String invoiceFromDate,String invoiceToDate);
	
	public void saveEmployee(Employee employee);
	
	public void saveTabSync(TabSync tabSync);
	
	public TabSync findByTabId(String tabId);
	
	public List<Employee> findEmployee();
	
	public Boolean findCredentails(String sso,String password);
	
	public User findUserDetails(String sso,String password);
	
	public void deleteWeighmentDraftData(WeighmentTemp weighmentTemp);
	
	public void findByLotNoAndId(Integer id);
	
	public User findUserObjectByUserNameAndCheck(String sso,String password);
	
	public void updatePlantsWithCounter(PurchagePlant purchagePlant);

	void deleteWeighmentVariety(Integer id);
	
	void saveWeighmentVarietyDetails(WeighmentVarietyDetails weighmentVarietyDetails);
}