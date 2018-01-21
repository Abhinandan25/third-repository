package com.jme.springmvc.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jme.springmvc.filter.User;
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.Message;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.TabsyncVo;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.service.UserService;
import com.jme.springmvc.vo.EmployeeVo;
import com.jme.springmvc.vo.UserCredentials;

@RestController
@RequestMapping("/rest")
public class JMERestController {
	
	@Autowired
	UserService userService;
	SimpleDateFormat  format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	 
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player) {//REST Endpoint.
 
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }
    
    @RequestMapping(value ="/findByTabId/{tabId}")
	public TabsyncVo findByTabId(@PathVariable Integer tabId) {
		
    	TabSync tabSync=userService.findByTabId(tabId.toString());
    	  String DateToStr = format.format(tabSync.getSyncTime());
    	  TabsyncVo tabSyncVo=new TabsyncVo();
    	  tabSyncVo.setId(tabSync.getId());
    	  tabSyncVo.setTabId(tabSync.getTabId());
    	  tabSyncVo.setSyncTime(DateToStr);
		return tabSyncVo;
	}
    
    @RequestMapping(value = "/createSyncData/", method = RequestMethod.GET)
    public ResponseEntity<String> listAllUsers() {
       
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    

    @RequestMapping(value = "/createSyncData/", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity<String> createSyncData(@RequestBody EmployeeVo user,UriComponentsBuilder ucBuilder) 
	{
    	Employee emp=new Employee();
    	emp.setDate(user.getCreateTime());
    	emp.setEmpName(user.getEmpName());
    	emp.setTabId(user.getTabId());
    	emp.setEmpId(user.getEmpId());
    	
    	userService.saveEmployee(emp);
    	
    	TabSync tabSync=new TabSync();
    	tabSync.setSyncTime(user.getCreateTime());
    	tabSync.setTabId(user.getTabId());
    	userService.saveTabSync(tabSync);
        return new ResponseEntity<String>("Success", HttpStatus.CREATED);	
    	
	}
    
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<String> listAllUsersS() {
      
        return new ResponseEntity<String>("Sucess", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
       
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
 
        
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/findAllEmp/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployees() {
    	List<Employee> emp=userService.findEmployee();
        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/createWeighment", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity<Weighment> createWeighment(@RequestBody Weighment weighment,UriComponentsBuilder ucBuilder) 
	{
		
		//LOGGER.info("Cheque Name.........."+weighment.getBillAgentName());
		
		// ModelAndView mav = new ModelAndView("createWeighment");
		
	//	User user=(User)request.getSession().getAttribute("user");
		
		Weighment weighmentData = new Weighment();
		weighmentData.setBillAgentName(weighment.getBillAgentName());
		weighmentData.setBillAgentMobile(weighment.getBillAgentMobile());
		weighmentData.setBillBt(weighment.getBillBt());
		weighmentData.setBillChequeName(weighment.getBillChequeName());
		weighmentData.setBillCount(weighment.getBillCount());
		weighmentData.setBillCreDt(weighment.getBillCreDt());
		//weighmentData.setBillCreDt(new Date());
		//weighmentData.setBillCreId(Long.toString(user.getId()));
		//weighmentData.setBillDate(weighment.getBillDate());
		weighmentData.setBillDate(new Date());
		weighmentData.setBillFormerMobile(weighment.getBillFormerMobile());
		weighmentData.setBillFormerName(weighment.getBillFormerName());
		weighmentData.setBillHalt(weighment.getBillHalt());
		weighmentData.setBillPlace(weighment.getBillPlace());
		weighmentData.setBillPlantId(weighment.getBillPlantId());
		weighmentData.setBillSignGrader(weighment.getBillSignGrader());
		weighmentData.setBillGraderPh(weighment.getBillGraderPh());
		//weighmentData.setBillUpdDt(weighment.getBillUpdDt());
		weighmentData.setBillUpdDt(new Date());
		weighmentData.setBillUpdId(weighment.getBillUpdId());
		weighmentData.setBillVim(weighment.getBillVim());
		weighmentData.setVerifiedBy(weighment.getVerifiedBy());
		weighmentData.setBillTruckNUmber(weighment.getBillTruckNUmber());
		weighmentData.setBillDriverName(weighment.getBillDriverName());
		weighmentData.setBillDispatchedBvrm(weighment.getBillDispatchedBvrm());
		weighmentData.setBillDispatchedNsp(weighment.getBillDispatchedNsp());
		weighmentData.setBillDispatchTime(weighment.getBillDispatchTime());
		weighmentData.setBillArrivalTime(weighment.getBillArrivalTime());
		weighmentData.setBillStatus(weighment.getBillStatus());
		weighmentData.setBillIceQty(weighment.getBillIceQty());
		
		List<WeighmentDetails> purchageBillDetails =new ArrayList<WeighmentDetails>();
		
		for(int i=0;i<weighment.getPurchageBillDetails().size();i++) {
		
			WeighmentDetails weighmentDetails=new WeighmentDetails();
				
			weighmentDetails.setBilledBillCount(weighment.getPurchageBillDetails().get(i).getBilledBillCount());
			weighmentDetails.setBilledCreDt(weighment.getPurchageBillDetails().get(i).getBilledCreDt());
			weighmentDetails.setBilledCreId(weighment.getPurchageBillDetails().get(i).getBilledCreId());
			weighmentDetails.setBilledNoOfNets(weighment.getPurchageBillDetails().get(i).getBilledNoOfNets());
			weighmentDetails.setBilledUpdDt(weighment.getPurchageBillDetails().get(i).getBilledUpdDt());
			weighmentDetails.setBilledUpdId(weighment.getPurchageBillDetails().get(i).getBilledUpdId());
			weighmentDetails.setBilledWgtKgs(weighment.getPurchageBillDetails().get(i).getBilledWgtKgs());
			
			weighmentDetails.setBilledBillLotNo(weighmentData);
			
			purchageBillDetails.add(weighmentDetails);
		
		
		}
		
		weighmentData.setPurchageBillDetails(purchageBillDetails);
		
		PurchageWorkflow purchageWorkflow=new PurchageWorkflow();
		purchageWorkflow.setBillId(1); // Status 1 while creating weighment
		purchageWorkflow.setBilllotNo(weighmentData);
		//purchageWorkflow.setBillCreId(Long.toString(user.getId()));
		purchageWorkflow.setBillCreDt(weighment.getBillCreDt());
		purchageWorkflow.setBillUpdId(weighment.getBillUpdId());
		purchageWorkflow.setBillUpdDt(new Date());
		purchageWorkflow.setStatus("CREATE_WEIGHMENT");
		
		weighmentData.setPurchageWorkflow(purchageWorkflow);
		
		userService.savePurchageBill(weighmentData);
		
		System.out.println("Lot Number created as........"+weighmentData.getBillLotNo());
		weighment.setBillLotNo(weighmentData.getBillLotNo());
			
		 return new ResponseEntity<Weighment>(weighment, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<com.jme.springmvc.model.User> loginPage(@RequestBody UserCredentials userCredentials) {
    	
    	com.jme.springmvc.model.User val=userService.findUserObjectByUserNameAndCheck(userCredentials.getUserName(), userCredentials.getPassword());
    	
    	return new ResponseEntity<com.jme.springmvc.model.User>(val, HttpStatus.OK);
    }
    
   
}
