package com.jme.springmvc.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jme.springmvc.dao.EmployeeDao;
import com.jme.springmvc.dao.InvoiceReportDao;
import com.jme.springmvc.dao.PurchageBillDao;
import com.jme.springmvc.dao.PurchageBillDetailsDao;
import com.jme.springmvc.dao.PurchageBillDraftDao;
import com.jme.springmvc.dao.PurchageBillPlantDao;
import com.jme.springmvc.dao.PurchageBillReportDao;
import com.jme.springmvc.dao.PurchageBillVarietyDao;
import com.jme.springmvc.dao.PurchageWorkflowDao;
import com.jme.springmvc.dao.TabSyncDao;
import com.jme.springmvc.dao.UserDao;
import com.jme.springmvc.dao.WeighmentVarietyDetailsDao;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.model.WeighmentVarietyDetails;
import com.jme.springmvc.vo.WeighmentVo;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.InvoiceReport;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.PurchageBillTubs;
import com.jme.springmvc.model.PurchageCompCountDetail;
import com.jme.springmvc.model.PurchagePayAmount;
import com.jme.springmvc.model.PurchagePlant;
import com.jme.springmvc.model.PurchageShrimpVariety;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	
	@Autowired
	private PurchageBillDao purchageBillDao;
	
	@Autowired
	private PurchageWorkflowDao purchageWorkflowDao;
	
	@Autowired
	private PurchageBillReportDao purchaseBillReportDao;
	
	@Autowired
	private PurchageBillPlantDao purchaseBillPlantDao;
	
	@Autowired
	private PurchageBillDetailsDao purchageBillDetailsDao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PurchageBillVarietyDao purchageBillVarietyDao;
	
	@Autowired
	private InvoiceReportDao invoiceReportDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private TabSyncDao tabSyncDao;
	
	@Autowired
	private PurchageBillDraftDao purchaseBillDraftDao;
	

	@Autowired
	private WeighmentVarietyDetailsDao weighmentVarietyDetailsDao;
	
	public static DateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd");
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public void savePurchageBill(Weighment purchaseBill) {
		purchageBillDao.savePurchaseBill(purchaseBill);
	}
	
	@Override
	public void updatePurchageBill(Weighment purchaseBill) {
		purchageBillDao.updatePurchaseBill(purchaseBill);
	}
	
	@Override
	public void savePurchaseWorkflow(PurchageWorkflow purchageWorkflow) {
		purchageWorkflowDao.savePurchaseWorkflow(purchageWorkflow);
		
	}

	@Override
	public void savePurchageBillDetails(WeighmentDetails purchaseBillDetails) {
		purchageBillDetailsDao.savePurchaseBillDetails(purchaseBillDetails);		
	}
	
	public Weighment findByLotId(int id) {
		return purchageBillDao.findByLotId(id);
	}
	
	public List<Weighment> findByType(String chequeName,String farmer,String place,Integer lotNo,String agentName,String date) {
		return purchageBillDao.findByType(chequeName, farmer, place, lotNo, agentName, date);
	}
	
	@Override
	public void savePurchageBillReport(PurchageBillReport purchageBillReport) {
		purchaseBillReportDao.savePurchaseBillReport(purchageBillReport);
		
	}
	
	public List<Integer> findBillCount(Integer lotNo){
		return purchageBillDetailsDao.findBillCount(lotNo);
		
	}
	
	public PurchageWorkflow findByWorkFlowId(Integer id) {
		return purchageWorkflowDao.findById(id);
	}
	
	public void updatePurchaseBill(PurchageWorkflow purchaseBill) {
		 purchageWorkflowDao.updatePurchaseBill(purchaseBill);
	}
	
	public List<PurchagePlant> findAllPlantDetails() {
		return purchaseBillPlantDao.findAllPlantDetails();
	}
	
	public void updateWeighment(Weighment weighment) {
		
		Weighment entity=purchageBillDao.findByLotId(weighment.getBillLotNo());
		
		if(entity!=null) {
			
			entity.setBillAgentMobile(weighment.getBillAgentMobile());
			entity.setBillAgentName(weighment.getBillAgentName());
			entity.setBillArrivalTime(weighment.getBillArrivalTime());
			entity.setBillBt(weighment.getBillBt());
			entity.setBillChequeName(weighment.getBillChequeName());
			entity.setBillCount(weighment.getBillCount());
			
			String testDateString=null;
			if (weighment.getBillDate() != null && !StringUtils.isEmpty(weighment.getBillDate())) {
				testDateString = dateFrmt.format(weighment.getBillDate());
			}	
			
			Date date1 = null;
			try {
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(testDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			entity.setBillCreDt(date1);
			entity.setBillCreId(weighment.getBillCreId());
			entity.setBillDate(weighment.getBillDate());
			entity.setBillDispatchedBvrm(weighment.getBillDispatchedBvrm());
			entity.setBillDispatchedNsp(weighment.getBillDispatchedNsp());
			entity.setBillDispatchTime(weighment.getBillDispatchTime());
			entity.setBillDriverName(weighment.getBillDriverName());
			entity.setBillFormerMobile(weighment.getBillFormerMobile());
			entity.setBillFormerName(weighment.getBillFormerName());
			entity.setBillHalt(weighment.getBillHalt());
			entity.setBillPlace(weighment.getBillPlace());
			entity.setBillPlantId(weighment.getBillPlantId());
			entity.setBillSignGrader(weighment.getBillSignGrader());
			entity.setBillStatus(weighment.getBillStatus());
			entity.setBillTruckNUmber(weighment.getBillTruckNUmber());
			entity.setBillUpdDt(weighment.getBillUpdDt());
			entity.setBillUpdId(weighment.getBillUpdId());
			entity.setBillVim(weighment.getBillVim());
			entity.setVerifiedBy(weighment.getVerifiedBy());
			entity.setBillMaterialTubs(weighment.getBillMaterialTubs());
			entity.setBillEmpty(weighment.getBillEmpty());
			entity.setBillTotalTubs(weighment.getBillTotalTubs());
			entity.setBillSingleNetWeight(weighment.getBillSingleNetWeight());
			entity.setBillIceQty(weighment.getBillIceQty());
			entity.setBillTotalNets(weighment.getBillTotalNets());
			entity.setBillTotalNetWeight(weighment.getBillTotalNetWeight());
			entity.setBillTotalTubs(weighment.getBillTotalTubs());
			entity.setBillMaterialTubs(weighment.getBillMaterialTubs());
			entity.setBillSingleNetWeight(weighment.getBillSingleNetWeight());
			
			entity.setBillSupervisorName(weighment.getBillSupervisorName());
			List<WeighmentDetails> weighmentDetailsList=null;
			for(int i=0;i<weighment.getPurchageBillDetails().size();i++) {
			//	weighment.getPurchageBillDetails().get(i).setBilledId(140);
				if(weighment.getPurchageBillDetails().get(i).getBilledId()!=null)
				{
				entity.getPurchageBillDetails().get(i).setBilledBillCount(weighment.getPurchageBillDetails().get(i).getBilledBillCount());
				entity.getPurchageBillDetails().get(i).setBilledCreDt(weighment.getPurchageBillDetails().get(i).getBilledCreDt());
				entity.getPurchageBillDetails().get(i).setBilledCreId(weighment.getPurchageBillDetails().get(i).getBilledCreId());
				entity.getPurchageBillDetails().get(i).setBilledNoOfNets(weighment.getPurchageBillDetails().get(i).getBilledNoOfNets());
				entity.getPurchageBillDetails().get(i).setBilledUpdDt(weighment.getPurchageBillDetails().get(i).getBilledUpdDt());
				entity.getPurchageBillDetails().get(i).setBilledUpdId(weighment.getPurchageBillDetails().get(i).getBilledUpdId());
				entity.getPurchageBillDetails().get(i).setBilledWgtKgs(weighment.getPurchageBillDetails().get(i).getBilledWgtKgs());
				entity.getPurchageBillDetails().get(i).setBilledBillLotNo(entity);
				}
				else {
					
					weighment.getPurchageBillDetails().get(i).setBilledBillLotNo(weighment);
					
					savePurchagebillDetails(weighment.getPurchageBillDetails().get(i));
					
				}
			}
			
			for(int i=0;i<weighment.getWeighmentVarietyDetails().size();i++) {
				if(weighment.getWeighmentVarietyDetails().get(i).getBilledId()!=null)
				{
					entity.getWeighmentVarietyDetails().get(i).setBilledBillVarietyCount(weighment.getWeighmentVarietyDetails().get(i).getBilledBillVarietyCount());
					entity.getWeighmentVarietyDetails().get(i).setBilledVarietyName(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyName());
					entity.getWeighmentVarietyDetails().get(i).setBilledVarietyWgtKgs(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyWgtKgs());
					entity.getWeighmentVarietyDetails().get(i).setBilledBillLotNo(entity);
					entity.getWeighmentVarietyDetails().get(i).setBilledCreId(weighment.getWeighmentVarietyDetails().get(i).getBilledCreId());
					entity.getWeighmentVarietyDetails().get(i).setBilledCreDt(weighment.getWeighmentVarietyDetails().get(i).getBilledCreDt());
					entity.getWeighmentVarietyDetails().get(i).setBilledUpdId(weighment.getWeighmentVarietyDetails().get(i).getBilledUpdId());
					entity.getWeighmentVarietyDetails().get(i).setBilledUpdDt(weighment.getWeighmentVarietyDetails().get(i).getBilledUpdDt());
					
				}
				else {
					weighment.getWeighmentVarietyDetails().get(i).setBilledBillLotNo(weighment);
					saveWeighmentVarietyDetails(weighment.getWeighmentVarietyDetails().get(i));
				}
			}
			//entity.setPurchageBillDetails(weighmentDetailsList);
			//updatePurchageBill(entity);
			//mergePurchageBill(entity);
		}
	}
	
	public PurchagePlant findByPlantId(Integer id) {
		return purchaseBillPlantDao.findByPlantId(id);
	}
	
	public PurchageShrimpVariety findByVarietyId(Integer id) {
		return purchageBillVarietyDao.findByVarietyId(id);
	}
	
	public List<PurchageShrimpVariety> findAllPlantVarietyDetails() {
		return purchageBillVarietyDao.findAllPlantVarietyDetails();
	}
public void updatePurchageBillReport(PurchageBillReport purchageBillReport) {
	
		 PurchageBillReport entity=purchaseBillReportDao.findByPurchageLotId(purchageBillReport.getBillReportLotNo().getBillLotNo());
		removeCompDetailsNullObjects(purchageBillReport);
		if(entity!=null) {
			
			entity.setBillAccountManager(purchageBillReport.getBillAccountManager());
			entity.setBillAuthorized(purchageBillReport.getBillAuthorized());
			entity.setBillCertificate(purchageBillReport.getBillCertificate());
			entity.setBillCreDt(purchageBillReport.getBillCreDt());
			entity.setBillCreId(purchageBillReport.getBillCreId());
			entity.setBillDriverName(purchageBillReport.getBillDriverName());
			entity.setBillGraderName(purchageBillReport.getBillGraderName());
			entity.setBillPlantManager(purchageBillReport.getBillPlantManager());
			entity.setBillPurchageAuthorized(purchageBillReport.getBillPurchageAuthorized());
			entity.setBillPurchageManager(purchageBillReport.getBillPurchageManager());
			entity.setBillUpdDt(purchageBillReport.getBillUpdDt());
			entity.setBillUpdId(purchageBillReport.getBillUpdId());
			entity.setBillDueDate(purchageBillReport.getBillDueDate());
			entity.setTotalInvoiceQuantity(purchageBillReport.getTotalInvoiceQuantity());
			entity.setTotalInvoiceAmt(purchageBillReport.getTotalInvoiceAmt());
			 		
			entity.setBillRemarks(purchageBillReport.getBillRemarks());
			
			for(int i=0;i<purchageBillReport.getPurchageCompCountDetail().size();i++) {
			if(purchageBillReport.getPurchageCompCountDetail().get(i)!=null) {
				entity.getPurchageCompCountDetail().get(i).setBill25kGCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount());
				entity.getPurchageCompCountDetail().get(i).setBillBillId(entity);
				entity.getPurchageCompCountDetail().get(i).setBillBlackSpot(purchageBillReport.getPurchageCompCountDetail().get(i).getBillBlackSpot());
				entity.getPurchageCompCountDetail().get(i).setBillDiscolored(purchageBillReport.getPurchageCompCountDetail().get(i).getBillDiscolored());
				entity.getPurchageCompCountDetail().get(i).setBillLotNo(entity.getBillReportLotNo().getBillLotNo().toString());
				entity.getPurchageCompCountDetail().get(i).setBillPeeling(purchageBillReport.getPurchageCompCountDetail().get(i).getBillPeeling());
				entity.getPurchageCompCountDetail().get(i).setBilldCompCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBilldCompCount());
			}
			}

			for(int i=0;i<purchageBillReport.getPurchageBillTubs().size();i++) {
				if(entity.getPurchageBillTubs().get(i)!=null) {
				entity.getPurchageBillTubs().get(i).setBillEmpty(purchageBillReport.getPurchageBillTubs().get(i).getBillEmpty());
				entity.getPurchageBillTubs().get(i).setBillBillId(entity);
				entity.getPurchageBillTubs().get(i).setBillLotNo(entity.getBillReportLotNo().getBillLotNo().toString());
				entity.getPurchageBillTubs().get(i).setBillMaterialTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillMaterialTubs());
				entity.getPurchageBillTubs().get(i).setBillQuantity(purchageBillReport.getPurchageBillTubs().get(i).getBillQuantity());
				entity.getPurchageBillTubs().get(i).setBillTotalTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillTotalTubs());
				}
			}
			
			for(int i=0;i<purchageBillReport.getPurchagePayAmount().size();i++) {
				if(entity.getPurchagePayAmount().get(i)!=null) {
				entity.getPurchagePayAmount().get(i).setBillCount(purchageBillReport.getPurchagePayAmount().get(i).getBillCount());
				entity.getPurchagePayAmount().get(i).setBillLotNo(entity.getBillReportLotNo().getBillLotNo().toString());
				entity.getPurchagePayAmount().get(i).setBillPurchageQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity());
				entity.getPurchagePayAmount().get(i).setBillPurchageRate(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate());
				entity.getPurchagePayAmount().get(i).setBillQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillQuantity());
				entity.getPurchagePayAmount().get(i).setBillVarietyId(purchageBillReport.getPurchagePayAmount().get(i).getBillVarietyId());
				entity.getPurchagePayAmount().get(i).setBillPayBillId(entity);
				}
			}
			
			/*entity.getBillReportLotNo().setBillAgentMobile(purchageBillReport.getBillReportLotNo().getBillAgentMobile());
			entity.getBillReportLotNo().setBillAgentName(purchageBillReport.getBillReportLotNo().getBillAgentName());
			entity.getBillReportLotNo().setBillFormerMobile(purchageBillReport.getBillReportLotNo().getBillFormerMobile());
			entity.getBillReportLotNo().setBillFormerName(purchageBillReport.getBillReportLotNo().getBillFormerName());
			entity.getBillReportLotNo().setBillPlace(purchageBillReport.getBillReportLotNo().getBillPlace());
			entity.getBillReportLotNo().setBillDate(purchageBillReport.getBillReportLotNo().getBillDate());
			//entity.getBillReportLotNo().setBillVim(purchageBillReport.getBillReportLotNo().getBillVim());
			//entity.getBillReportLotNo().setBillBt(purchageBillReport.getBillReportLotNo().getBillBt());
			entity.getBillReportLotNo().setBillSignGrader(purchageBillReport.getBillReportLotNo().getBillSignGrader());
			entity.getBillReportLotNo().setBillGraderPh(purchageBillReport.getBillReportLotNo().getBillGraderPh());
			entity.getBillReportLotNo().setVerifiedBy(purchageBillReport.getBillReportLotNo().getVerifiedBy());
			entity.getBillReportLotNo().setBillTruckNUmber(purchageBillReport.getBillReportLotNo().getBillTruckNUmber());
			entity.getBillReportLotNo().setBillDriverName(purchageBillReport.getBillReportLotNo().getBillDriverName());
			entity.getBillReportLotNo().setBillDispatchTime(purchageBillReport.getBillReportLotNo().getBillDispatchTime());
			entity.getBillReportLotNo().setBillArrivalTime(purchageBillReport.getBillReportLotNo().getBillArrivalTime());
			entity.getBillReportLotNo().setBillDispatchedBvrm(purchageBillReport.getBillReportLotNo().getBillDispatchedBvrm());
			entity.getBillReportLotNo().setBillDispatchedNsp(purchageBillReport.getBillReportLotNo().getBillDispatchedNsp());
			entity.getBillReportLotNo().setBillChequeName(purchageBillReport.getBillReportLotNo().getBillChequeName());*/
			
			entity.getBillReportLotNo().getPurchageWorkflow().setStatus("WEIGHMENT_APPROVED");
			entity.getBillReportLotNo().getPurchageWorkflow().setBillId(purchageBillReport.getBillId());
			
		}
}
	
	private void removeCompDetailsNullObjects(PurchageBillReport purchageBillReport) {
		purchageBillReport.getPurchageCompCountDetail().removeAll(Collections.singleton(null));
	
}

	public PurchageBillReport findByPurchageLotId(Integer id) {
		return purchaseBillReportDao.findByPurchageLotId(id);
	}
	
	public List<Weighment> findAllWeighmentWithStatus(){
				return purchageBillDao.findAllWeighmentWithStatus();
	}

	@Override
	public void saveInvoiceReport(InvoiceReport invoiceReport) {
		invoiceReportDao.saveInvoiceReport(invoiceReport);
	}
	
	public List<InvoiceReport> findByType(String voucherNumber,String farmer,Integer lotNo,String invoiceFromDate,String invoiceToDate){
		return invoiceReportDao.findByType(voucherNumber, farmer, lotNo, invoiceFromDate, invoiceToDate);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void saveTabSync(TabSync tabSync) {
		tabSyncDao.saveTabSync(tabSync);
	}

	@Override
	public TabSync findByTabId(String tabId) {
		return tabSyncDao.findByTabId(tabId);
	}
	
	@Override
	public List<Employee> findEmployee(){
		return employeeDao.findEmployee();
	}
	
	public Boolean findCredentails(String sso,String password) {
		return dao.findCredentails(sso, password);
	}
	
	public User findUserDetails(String sso,String password) {
		return dao.findUserDetails(sso, password);
	}
	
	@Override
	public void savePurchageBillDraft(WeighmentTemp purchaseBill) {
		purchaseBillDraftDao.savePurchaseBillDraft(purchaseBill);
	}
	
	public void deleteWeighmentDraftData(WeighmentTemp weighmentTemp) {
		purchaseBillDraftDao.deleteWeighmentDraftData(weighmentTemp);
	}
	
	public void findByLotNoAndId(Integer id) {
		purchageBillDetailsDao.findByLotNoAndId(id);
	}
	public com.jme.springmvc.model.User findUserObjectByUserNameAndCheck(String sso,String password)
	{
		return dao.findUserObjectByUserNameAndCheck(sso, password);
	}
	
	public void savePurchagebillDetails(WeighmentDetails weighment) {
		 purchageBillDetailsDao.savePurchagebillDetails(weighment);
	}
	public void updatePlantsWithCounter(PurchagePlant purchagePlant)
	{
		purchaseBillPlantDao.updatePlantsWithCounter(purchagePlant);
	}

	@Override
	public void deleteWeighmentVariety(Integer id) {
		// TODO Auto-generated method stub
		weighmentVarietyDetailsDao.deleteWeighmentVariety(id);
	}
	public void saveWeighmentVarietyDetails(WeighmentVarietyDetails weighmentVarietyDetails) {
		weighmentVarietyDetailsDao.saveWeighmentVarietyDetails(weighmentVarietyDetails);
	}
}
