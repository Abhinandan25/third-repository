package com.jme.springmvc.controller;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jme.springmvc.exception.CustomGenericException;
import com.jme.springmvc.exception.TallyException;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentDetailsTemp;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.model.WeighmentVarietyDetails;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.InvoiceReport;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.PurchageBillTubs;
import com.jme.springmvc.model.PurchageCompCountDetail;
import com.jme.springmvc.model.PurchagePayAmount;
import com.jme.springmvc.model.PurchagePlant;
import com.jme.springmvc.model.PurchageShrimpVariety;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.Response;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.jme.springmvc.service.UserProfileService;
import com.jme.springmvc.service.UserService;
import com.jme.springmvc.vo.InvoiceReportVo;
import com.jme.springmvc.vo.PurchageBillReportVo;
import com.jme.springmvc.vo.PurchageBillTubsVo;
import com.jme.springmvc.vo.PurchageCompCountDetailVo;
import com.jme.springmvc.vo.PurchagePayAmountVo;
import com.jme.springmvc.vo.PurchageWorkflowVo;
import com.jme.springmvc.vo.WeighmentDetailsVo;
import com.jme.springmvc.vo.WeighmentVarietyDetailsVo;
import com.jme.springmvc.vo.WeighmentVo;






@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	
	static HashMap<String,String> sh=null;
	static HashMap<Integer,PurchagePlant> plantList=new HashMap<Integer,PurchagePlant>();
	static{
		sh=new HashMap<String,String>();
		sh.put("April","01");
		sh.put("May","02");
		sh.put("June","03");
		sh.put("July","04");
		sh.put("August","05");
		sh.put("September","06");
		sh.put("October", "07");
		sh.put("November","08");
		sh.put("December","09");
		sh.put("January","10");
		sh.put("February","11");
		sh.put("March","12");
		
		
	}
         private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
         
    String TXML = "";

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	public static DateFormat dateFrmt = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String listUsers(HttpServletRequest request,ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user=userService.findBySSO(userDetails.getUsername());
		model.addAttribute("user", user);
		
		request.getSession().setAttribute("user", user);
		
		return "dashboard";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}
	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		 
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/list";
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	@RequestMapping(value = "/createWeighment", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  Weighment createWeighment(HttpServletRequest request, @RequestBody Weighment weighment,ModelMap model) 
	{
		
		/*
		 * Delete the record from Draft table before inserting new record into weighment table.
		 */
		/*WeighmentTemp weighmentTemp=new WeighmentTemp();
		
		weighmentTemp.setBillLotNo(1);  //pass lot No here
		
		userService.deleteWeighmentDraftData(weighmentTemp); */                                                                   
		
		/**
		 * Create Weighment
		 */
		
		LOGGER.info("Cheque Name.........."+weighment.getBillAgentName());
		
		// ModelAndView mav = new ModelAndView("createWeighment");
		
		User user=(User)request.getSession().getAttribute("user");
		
		Weighment weighmentData = new Weighment();
		weighmentData.setBillAgentName(weighment.getBillAgentName());
		weighmentData.setBillAgentMobile(weighment.getBillAgentMobile());
		weighmentData.setBillBt(weighment.getBillBt());
		weighmentData.setBillChequeName(weighment.getBillChequeName());
		weighmentData.setBillCount(weighment.getBillCount());
		weighmentData.setBillCreDt(weighment.getBillCreDt());
		//weighmentData.setBillCreDt(new Date());
		weighmentData.setBillCreId(user.getId().toString());
		//weighmentData.setBillDate(weighment.getBillDate());
		weighmentData.setBillDate(new Date());
		weighmentData.setBillFormerMobile(weighment.getBillFormerMobile());
		weighmentData.setBillFormerName(weighment.getBillFormerName());
		//weighmentData.setBillHalt(weighment.getBillHalt());
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
		weighmentData.setBillTotalNetWeight(weighment.getBillTotalNetWeight());
		weighmentData.setBillTotalNets(weighment.getBillTotalNets());
		weighmentData.setBillMaterialTubs(weighment.getBillMaterialTubs());
		weighmentData.setBillEmpty(weighment.getBillEmpty());
		weighmentData.setBillTotalTubs(weighment.getBillTotalTubs());
		weighmentData.setBillSingleNetWeight(weighment.getBillSingleNetWeight());
		
		weighmentData.setBillSupervisorName(weighment.getBillSupervisorName());
		
		List<WeighmentDetails> purchageBillDetails =new ArrayList<WeighmentDetails>();
		
		for(int i=0;i<weighment.getPurchageBillDetails().size();i++) {
		
			WeighmentDetails weighmentDetails=new WeighmentDetails();
				
			if(weighment.getPurchageBillDetails().get(i).getBilledBillCount()!=null && !weighment.getPurchageBillDetails().get(i).getBilledBillCount().toString().isEmpty()) {
				weighmentDetails.setBilledBillCount(weighment.getPurchageBillDetails().get(i).getBilledBillCount());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledCreDt()!=null && !weighment.getPurchageBillDetails().get(i).getBilledCreDt().toString().isEmpty()) {
				weighmentDetails.setBilledCreDt(weighment.getPurchageBillDetails().get(i).getBilledCreDt());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledCreId()!=null && !weighment.getPurchageBillDetails().get(i).getBilledCreId().toString().isEmpty()) {
				weighmentDetails.setBilledCreId(weighment.getPurchageBillDetails().get(i).getBilledCreId());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledNoOfNets()!=null && !weighment.getPurchageBillDetails().get(i).getBilledNoOfNets().toString().isEmpty()) {
				weighmentDetails.setBilledNoOfNets(weighment.getPurchageBillDetails().get(i).getBilledNoOfNets());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledUpdDt()!=null && !weighment.getPurchageBillDetails().get(i).getBilledUpdDt().toString().isEmpty()) {
				weighmentDetails.setBilledUpdDt(weighment.getPurchageBillDetails().get(i).getBilledUpdDt());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledUpdId()!=null && !weighment.getPurchageBillDetails().get(i).getBilledUpdId().toString().isEmpty()) {
				weighmentDetails.setBilledUpdId(weighment.getPurchageBillDetails().get(i).getBilledUpdId());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledWgtKgs()!=null && !weighment.getPurchageBillDetails().get(i).getBilledWgtKgs().toString().isEmpty()) {
				weighmentDetails.setBilledWgtKgs(weighment.getPurchageBillDetails().get(i).getBilledWgtKgs());
			}
			/*if(weighmentData.getBillTotalNetWeight()!=null && weighmentDetails.getBilledWgtKgs()!=null) {
				weighmentData.setBillTotalNetWeight(weighmentData.getBillTotalNetWeight().add(weighmentDetails.getBilledWgtKgs()));
			}
			if(weighmentData.getBillTotalNets()!=null && weighmentDetails.getBilledWgtKgs()!=null) {
				weighmentData.setBillTotalNets(weighmentData.getBillTotalNets()+Integer.parseInt(weighmentDetails.getBilledNoOfNets()));
			}*/
			weighmentDetails.setBilledBillLotNo(weighmentData);
			
			purchageBillDetails.add(weighmentDetails);
		}
		
		weighmentData.setPurchageBillDetails(purchageBillDetails);
		List<WeighmentVarietyDetails> weighmentVarietyDetailsList =new ArrayList<WeighmentVarietyDetails>();
		for(int i=0;i<weighment.getWeighmentVarietyDetails().size();i++) {
			WeighmentVarietyDetails weighmentVarietyDetails=new WeighmentVarietyDetails();
			if(weighment.getWeighmentVarietyDetails().get(i).getBilledBillVarietyCount()!=null && !weighment.getWeighmentVarietyDetails().get(i).getBilledBillVarietyCount().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledBillVarietyCount(weighment.getWeighmentVarietyDetails().get(i).getBilledBillVarietyCount());
			}
			if(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyName()!=null && !weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyName().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledVarietyName(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyName());
			}
			
			if(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyWgtKgs()!=null && !weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyWgtKgs().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledVarietyWgtKgs(weighment.getWeighmentVarietyDetails().get(i).getBilledVarietyWgtKgs());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledUpdDt()!=null && !weighment.getPurchageBillDetails().get(i).getBilledUpdDt().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledUpdDt(weighment.getPurchageBillDetails().get(i).getBilledUpdDt());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledUpdId()!=null && !weighment.getPurchageBillDetails().get(i).getBilledUpdId().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledUpdId(weighment.getPurchageBillDetails().get(i).getBilledUpdId());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledCreDt()!=null && !weighment.getPurchageBillDetails().get(i).getBilledCreDt().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledCreDt(weighment.getPurchageBillDetails().get(i).getBilledCreDt());
			}
			if(weighment.getPurchageBillDetails().get(i).getBilledCreId()!=null && !weighment.getPurchageBillDetails().get(i).getBilledCreId().toString().isEmpty()) {
				weighmentVarietyDetails.setBilledCreId(weighment.getPurchageBillDetails().get(i).getBilledCreId());
			}
			weighmentVarietyDetails.setBilledBillLotNo(weighmentData);
			weighmentVarietyDetailsList.add(weighmentVarietyDetails);
		}
		
		weighmentData.setWeighmentVarietyDetails(weighmentVarietyDetailsList);
		
		PurchageWorkflow purchageWorkflow=new PurchageWorkflow();
		purchageWorkflow.setBillId(1); // Status 1 while creating weighment
		purchageWorkflow.setBilllotNo(weighmentData);
		purchageWorkflow.setBillCreId(user.getId().toString());
		purchageWorkflow.setBillCreDt(weighment.getBillCreDt());
		purchageWorkflow.setBillUpdId(weighment.getBillUpdId());
		purchageWorkflow.setBillUpdDt(new Date());
		purchageWorkflow.setStatus("CREATE_WEIGHMENT");
		
		weighmentData.setPurchageWorkflow(purchageWorkflow);
		
		userService.savePurchageBill(weighmentData);
		
		System.out.println("Lot Number created as........"+weighmentData.getBillLotNo());
		weighment.setBillLotNo(weighmentData.getBillLotNo());
			
		return weighment;
	}

	@RequestMapping(value ="/listWeighment", method = RequestMethod.GET)
	public String listWeighments(@RequestParam("id") String id,ModelMap model) {

		WeighmentVo weighment = fetchWeighment(id, userService);
		model.addAttribute("Weighment", weighment);
		LOGGER.info("AgentName......." + weighment.getBillAgentName());
		return "viewWeighment";
	}
	
	
	@RequestMapping(value ="/editWeighment", method = RequestMethod.GET)
	public String editWeighments(@RequestParam("id") String id,ModelMap model) {

		WeighmentVo weighment = fetchWeighment(id, userService);
		model.addAttribute("editWeighment", weighment);
		model.addAttribute("editPlantList", userService.findAllPlantDetails());
		LOGGER.info("AgentName......." + weighment.getBillAgentName());
		
		//userService.updatePurchageBill(weighment);
		
		return "editWeighment";
	}
	
	@RequestMapping(value = "/editWeighment", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  WeighmentVo updateWeighments(HttpServletRequest request, @RequestBody Weighment weighment,ModelMap model) 
	{
		userService.updateWeighment(weighment);
		WeighmentVo weighmentVo=new WeighmentVo();
		weighmentVo = fetchWeighment(weighment.getBillLotNo().toString(), userService);
		model.addAttribute("editWeighment", weighmentVo);
		model.addAttribute("editPlantList", userService.findAllPlantDetails());
		return weighmentVo;
	}
	
	@RequestMapping(value ="/searchResults", method = RequestMethod.GET,produces="application/json")
	public  @ResponseBody List<WeighmentVo>  searchWeighment(@RequestParam("chequeName") String chequeName,@RequestParam("farmer") String farmer,
			@RequestParam("place") String place,
			@RequestParam("lotNo") Integer lotNo,
			@RequestParam("agentName") String agentName
			,@RequestParam("date") String date) {
     
			 //return fetchWeighment(id,userService);
		return (List<WeighmentVo>) fetchWeighmentDetails(chequeName, farmer, place, lotNo, agentName, date,userService);
	}
	
	
	@RequestMapping(value ="/search", method = RequestMethod.GET)
	public String  searchWeighmentPage() {
		 return "search";
	}
	
	@RequestMapping(value ="/profile", method = RequestMethod.GET)
	public String  getProfile() {
		 return "profile";
	}
	
	@RequestMapping(value ="/workInProgress", method = RequestMethod.GET)
	public String  getworkInProgress() {
		 return "workInProgress";
	}
	
	@RequestMapping(value ="/createWeighmentSucess", method = RequestMethod.GET)
	public String  createWeighmentStatusPage() {
		 

		 return "createWeighmentSucess";
	}
	
	@RequestMapping(value ="/createWeighment", method = RequestMethod.GET)
	public String createWeighmentPage(HttpServletRequest request,ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User user=userService.findBySSO(userDetails.getUsername());
		model.addAttribute("user", user);
		
		request.getSession().setAttribute("user", user);
		model.addAttribute("plantList", userService.findAllPlantDetails());
		
		
		return "createWeighment";
	}
	
	
	@ExceptionHandler(TallyException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CustomGenericException handleTallyException(TallyException ex,HttpServletResponse response) {
		
		//CustomGenericException exceptionVO = new CustomGenericException("handleAllException()", this.getClass().getName(), ex.getMessage());
		CustomGenericException exceptionVO = new CustomGenericException("", "", " # Tally Error...."+ex.getErrMsg());
		    return exceptionVO;

	}
	
	
	
	@ExceptionHandler(java.net.ConnectException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CustomGenericException handleConnectException(java.net.ConnectException ex,HttpServletResponse response) {
		
		//CustomGenericException exceptionVO = new CustomGenericException("handleAllException()", this.getClass().getName(), ex.getMessage());
		CustomGenericException exceptionVO = new CustomGenericException("", "", " # Tally Server is not responding....");
		    return exceptionVO;

	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CustomGenericException handleAllException(Exception ex,HttpServletResponse response) {
		
		CustomGenericException exceptionVO = new CustomGenericException("handleAllException()", this.getClass().getName(), ex.getCause().getMessage());
		 
		    return exceptionVO;

	}

	
	public static WeighmentVo fetchWeighment(String id,UserService userService)
	{
		Weighment weighmentObj=userService.findByLotId(Integer.parseInt(id));
		
		WeighmentVo weighmentData=new WeighmentVo();
		
		weighmentData.setBillAgentMobile(weighmentObj.getBillAgentMobile());
		weighmentData.setBillChequeName(weighmentObj.getBillChequeName());
		weighmentData.setBillFormerName(weighmentObj.getBillFormerName());
		weighmentData.setBillAgentName(weighmentObj.getBillAgentName());
		weighmentData.setBillFormerMobile(weighmentObj.getBillFormerMobile());
		weighmentData.setBillAgentMobile(weighmentObj.getBillAgentMobile());
		weighmentData.setBillPlantId(weighmentObj.getBillPlantId());
		weighmentData.setBillPlace(weighmentObj.getBillPlace());
		weighmentData.setVerifiedBy(weighmentObj.getVerifiedBy());
		weighmentData.setBillSignGrader(weighmentObj.getBillSignGrader());
		weighmentData.setBillGraderPh(weighmentObj.getBillGraderPh());
		//weighmentData.setBillHalt(weighmentObj.getBillGraderPh());
		weighmentData.setBillDriverName(weighmentObj.getBillDriverName());
		PurchagePlant purchagePlant=userService.findByPlantId(Integer.parseInt(weighmentObj.getBillPlantId()));
		weighmentData.setBillPlantName(purchagePlant.getBillPlantName());
		String testDateString=null;
		if (weighmentObj.getBillDate() != null && !StringUtils.isEmpty(weighmentObj.getBillDate())) {
			testDateString = dateFrmt.format(weighmentObj.getBillDate());
		}	
		weighmentData.setBillDate(testDateString);
		weighmentData.setBillLotNo(weighmentObj.getBillLotNo());
		if(weighmentObj.getBillIceQty()!=null)
		weighmentData.setBillIceQty(weighmentObj.getBillIceQty().toString());
		weighmentData.setBillTruckNUmber(weighmentObj.getBillTruckNUmber());
		weighmentData.setBillDispatchedBvrm(weighmentObj.getBillDispatchedBvrm());
		weighmentData.setBillDispatchedNsp(weighmentObj.getBillDispatchedNsp());
		weighmentData.setBillDispatchTime(weighmentObj.getBillDispatchTime());
		weighmentData.setBillArrivalTime(weighmentObj.getBillArrivalTime());
		weighmentData.setBillStatus(weighmentObj.getBillStatus());
		weighmentData.setBillBt(weighmentObj.getBillBt());
		weighmentData.setBillVim(weighmentObj.getBillVim());
		
		weighmentData.setBillMaterialTubs(weighmentObj.getBillMaterialTubs());
		weighmentData.setBillEmpty(weighmentObj.getBillEmpty());
		weighmentData.setBillTotalTubs(weighmentObj.getBillTotalTubs());
		if(weighmentObj.getBillTotalTubs()!=null && weighmentObj.getBillMaterialTubs()!=null)
		{
		weighmentData.setBillRemainingTubs(weighmentObj.getBillTotalTubs()-weighmentObj.getBillMaterialTubs());
		}
		weighmentData.setBillSingleNetWeight(weighmentObj.getBillSingleNetWeight());
		weighmentData.setBillTotalNets(weighmentObj.getBillTotalNets());
		weighmentData.setBillTotalNetWeight(weighmentObj.getBillTotalNetWeight());
		weighmentData.setBillSupervisorName(weighmentObj.getBillSupervisorName());
		
		List<WeighmentDetailsVo> purchageBillDetails =new ArrayList<WeighmentDetailsVo>();
			
		for(int i=0;i<weighmentObj.getPurchageBillDetails().size();i++) {
		
			WeighmentDetailsVo weighmentDetails=new WeighmentDetailsVo();
				
			weighmentDetails.setBilledBillCount(weighmentObj.getPurchageBillDetails().get(i).getBilledBillCount());
			weighmentDetails.setBilledCreDt(weighmentObj.getPurchageBillDetails().get(i).getBilledCreDt());
			weighmentDetails.setBilledCreId(weighmentObj.getPurchageBillDetails().get(i).getBilledCreId());
			weighmentDetails.setBilledNoOfNets(weighmentObj.getPurchageBillDetails().get(i).getBilledNoOfNets());
			weighmentDetails.setBilledUpdDt(weighmentObj.getPurchageBillDetails().get(i).getBilledUpdDt());
			weighmentDetails.setBilledUpdId(weighmentObj.getPurchageBillDetails().get(i).getBilledUpdId());
			weighmentDetails.setBilledWgtKgs(weighmentObj.getPurchageBillDetails().get(i).getBilledWgtKgs());
			weighmentDetails.setId(weighmentObj.getPurchageBillDetails().get(i).getBilledId());
			weighmentDetails.setBilledBillLotNo(weighmentDetails.getBilledBillLotNo());
			weighmentData.setTotalCount(weighmentData.getTotalCount().add(weighmentDetails.getBilledBillCount()));
			if(weighmentData.getTotalWeight()!=null && weighmentDetails.getBilledWgtKgs()!=null)
			weighmentData.setTotalWeight(weighmentData.getTotalWeight().add(weighmentDetails.getBilledWgtKgs()));
			if(weighmentDetails.getBilledNoOfNets()!=null)
			weighmentData.setTotalNoOfNets(weighmentData.getTotalNoOfNets()+Integer.parseInt(weighmentDetails.getBilledNoOfNets()));
			purchageBillDetails.add(weighmentDetails);
		
		}
		  weighmentData.setWeighmentBillDetails(purchageBillDetails);
		  
			List<WeighmentVarietyDetailsVo> weighmentVarietyDetailsVoList =new ArrayList<WeighmentVarietyDetailsVo>();

		  for(int i=0;i<weighmentObj.getWeighmentVarietyDetails().size();i++) {
			  WeighmentVarietyDetailsVo weighmentVarietyVo=new WeighmentVarietyDetailsVo();
			  weighmentVarietyVo.setBilledBillVarietyCount(weighmentObj.getWeighmentVarietyDetails().get(i).getBilledBillVarietyCount());
			  weighmentVarietyVo.setBilledVarietyName(weighmentObj.getWeighmentVarietyDetails().get(i).getBilledVarietyName());
			  weighmentVarietyVo.setBilledVarietyWgtKgs(weighmentObj.getWeighmentVarietyDetails().get(i).getBilledVarietyWgtKgs());
			  weighmentVarietyVo.setId(weighmentObj.getWeighmentVarietyDetails().get(i).getId());
			  weighmentVarietyDetailsVoList.add(weighmentVarietyVo);
		  }
		  weighmentData.setWeighmentVarietyDetailsVo(weighmentVarietyDetailsVoList);
		  return weighmentData;
	
	}
	
	public static List<WeighmentVo> fetchWeighmentDetails(String chequeName,String farmer,String place,Integer lotNo,String agentName,String date,UserService userService)
	{
		List<Weighment> weighmentObj=userService.findByType(chequeName, farmer, place, lotNo, agentName, date);
		
		List<WeighmentVo> weighmentDataDetails=new ArrayList<WeighmentVo>();
		
		for(int i=0;i<weighmentObj.size();i++) {
		
		WeighmentVo weighmentData=new WeighmentVo();
		PurchageWorkflowVo purchaseWflow=new PurchageWorkflowVo();
		if(weighmentObj.get(i).getPurchageWorkflow()!=null) {
		purchaseWflow.setWorkflowId(weighmentObj.get(i).getPurchageWorkflow().getWorkflowId());
		purchaseWflow.setStatus(weighmentObj.get(i).getPurchageWorkflow().getStatus());
		}
		weighmentData.setPurchageWorkflow(purchaseWflow);
		
		weighmentData.setBillAgentMobile( weighmentObj.get(i).getBillAgentMobile());
		weighmentData.setBillChequeName(weighmentObj.get(i).getBillChequeName());
		weighmentData.setBillFormerName(weighmentObj.get(i).getBillFormerName());
		weighmentData.setBillAgentName(weighmentObj.get(i).getBillAgentName());
		weighmentData.setBillPlace(weighmentObj.get(i).getBillPlace());
		if (weighmentObj.get(i).getBillDate() != null && !StringUtils.isEmpty(weighmentObj.get(i).getBillDate())) {
			weighmentData.setBillDate(dateFrmt.format(weighmentObj.get(i).getBillDate()));
		}
		weighmentData.setBillLotNo(weighmentObj.get(i).getBillLotNo());
		
		weighmentData.setBillTruckNUmber(weighmentObj.get(i).getBillTruckNUmber());
		weighmentData.setBillDriverName(weighmentObj.get(i).getBillDriverName());
		weighmentData.setBillDispatchedBvrm(weighmentObj.get(i).getBillDispatchedBvrm());
		weighmentData.setBillDispatchedNsp(weighmentObj.get(i).getBillDispatchedNsp());
		weighmentData.setBillDispatchTime(weighmentObj.get(i).getBillDispatchTime());
		weighmentData.setBillArrivalTime(weighmentObj.get(i).getBillArrivalTime());
		weighmentData.setBillStatus(weighmentObj.get(i).getBillStatus());
		
		weighmentData.setBillMaterialTubs(weighmentObj.get(i).getBillMaterialTubs());
		weighmentData.setBillEmpty(weighmentObj.get(i).getBillEmpty());
		weighmentData.setBillTotalTubs(weighmentObj.get(i).getBillTotalTubs());
		weighmentData.setBillSingleNetWeight(weighmentObj.get(i).getBillSingleNetWeight());
		
		weighmentData.setBillSupervisorName(weighmentObj.get(i).getBillSupervisorName());
		
		List<WeighmentDetailsVo> purchageBillDetails =new ArrayList<WeighmentDetailsVo>();
			
		for(int j=0;j<weighmentObj.get(i).getPurchageBillDetails().size();j++) {
		
			WeighmentDetailsVo weighmentDetails=new WeighmentDetailsVo();
				
			weighmentDetails.setBilledBillCount(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledBillCount());
			weighmentDetails.setBilledCreDt(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledCreDt());
			weighmentDetails.setBilledCreId(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledCreId());
			weighmentDetails.setBilledNoOfNets(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledNoOfNets());
			weighmentDetails.setBilledUpdDt(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledUpdDt());
			weighmentDetails.setBilledUpdId(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledUpdId());
			weighmentDetails.setBilledWgtKgs(weighmentObj.get(i).getPurchageBillDetails().get(j).getBilledWgtKgs());
			
			weighmentDetails.setBilledBillLotNo(weighmentDetails.getBilledBillLotNo());
			if(weighmentDetails.getBilledBillCount()!=null)
			weighmentData.setTotalCount(weighmentData.getTotalCount().add(weighmentDetails.getBilledBillCount()));
			if(weighmentData.getTotalWeight()!=null && weighmentDetails.getBilledWgtKgs()!=null)
			weighmentData.setTotalWeight(weighmentData.getTotalWeight().add(weighmentDetails.getBilledWgtKgs()));
			if(weighmentDetails.getBilledNoOfNets()!=null && !weighmentDetails.getBilledNoOfNets().isEmpty())
			weighmentData.setTotalNoOfNets(weighmentData.getTotalNoOfNets()+Integer.parseInt(weighmentDetails.getBilledNoOfNets()));
			purchageBillDetails.add(weighmentDetails);
		
		}
		
		  
		  weighmentDataDetails.add(weighmentData);
		  weighmentData.setWeighmentBillDetails(purchageBillDetails);
		}
		  return weighmentDataDetails;
	
	}
	
	@RequestMapping(value ="/plantDetails", method = RequestMethod.GET)
	public List<PurchagePlant> findAllPlants() {
		return userService.findAllPlantDetails();
	}
	
	@RequestMapping(value = "/createPurchageBillReport", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  PurchageBillReport createPurchageBillReport(HttpServletRequest request,@RequestBody PurchageBillReport purchageBillReport,ModelMap model) 
	{
		
		Weighment weighmentObj=userService.findByLotId(purchageBillReport.getBillReportLotNo().getBillLotNo());
		User user=(User)request.getSession().getAttribute("user");
		
		weighmentObj.setVerifiedBy(user.getFirstName()+" "+user.getLastName());
		
		weighmentObj.setBillChequeName(purchageBillReport.getBillReportLotNo().getBillChequeName());
		weighmentObj.setBillFormerName(purchageBillReport.getBillReportLotNo().getBillFormerName());
		weighmentObj.setBillFormerMobile(purchageBillReport.getBillReportLotNo().getBillFormerMobile());
		weighmentObj.setBillAgentName(purchageBillReport.getBillReportLotNo().getBillAgentName());
		weighmentObj.setBillAgentMobile(purchageBillReport.getBillReportLotNo().getBillAgentMobile());
		weighmentObj.setBillPlace(purchageBillReport.getBillReportLotNo().getBillPlace());
		weighmentObj.setBillDate(purchageBillReport.getBillReportLotNo().getBillDate());
		weighmentObj.setBillTruckNUmber(purchageBillReport.getBillReportLotNo().getBillTruckNUmber());
		
		/*
		weighmentObj.setBillMaterialTubs(purchageBillReport.getBillReportLotNo().getBillMaterialTubs());
		weighmentObj.setBillEmpty(purchageBillReport.getBillReportLotNo().getBillEmpty());
		weighmentObj.setBillTotalTubs(purchageBillReport.getBillReportLotNo().getBillTotalTubs());
		weighmentObj.setBillSingleNetWeight(purchageBillReport.getBillReportLotNo().getBillSingleNetWeight());*/
		
		weighmentObj.setBillSupervisorName(purchageBillReport.getBillReportLotNo().getBillSupervisorName());
		
		PurchageBillReport report=new PurchageBillReport();
		
		report.setBillAccountManager(purchageBillReport.getBillAccountManager());
		report.setBillAuthorized(purchageBillReport.getBillAuthorized());
		report.setBillCertificate(purchageBillReport.getBillCertificate());
		report.setBillDriverName(purchageBillReport.getBillDriverName());
		report.setBillGraderName(purchageBillReport.getBillGraderName());
		report.setBillPurchageManager(purchageBillReport.getBillPurchageManager());
		report.setBillPlantManager(purchageBillReport.getBillPlantManager());
		report.setBillPurchageAuthorized(purchageBillReport.getBillPurchageAuthorized());
		report.setBillCreId(purchageBillReport.getBillCreId());
		report.setBillDispatchedBvrm(purchageBillReport.getBillDispatchedBvrm());
		report.setBillDispatchedNsp(purchageBillReport.getBillDispatchedNsp());
		report.setBillCertificate(purchageBillReport.getBillCertificate());
		report.setBillNoCertificate(purchageBillReport.getBillNoCertificate());
		report.setBillRemarks(purchageBillReport.getBillRemarks());
		report.setTotalInvoiceAmt(purchageBillReport.getTotalInvoiceAmt());
		report.setTotalInvoiceQuantity(purchageBillReport.getTotalInvoiceQuantity());
		report.setBillDueDate(purchageBillReport.getBillDueDate());
		report.setBillReportLotNo(weighmentObj);
		
		List<PurchagePayAmount> purchagePayAmounts =new ArrayList<PurchagePayAmount>();
		
		
		for(int i=0;i<purchageBillReport.getPurchagePayAmount().size();i++)
			
		{
			
			PurchagePayAmount purchagePayAmount=new PurchagePayAmount();
				if(purchageBillReport.getPurchagePayAmount().get(i)!=null)
				{
				purchagePayAmount.setBillCount(purchageBillReport.getPurchagePayAmount().get(i).getBillCount());
				purchagePayAmount.setBillLotNo(purchageBillReport.getBillReportLotNo().getBillLotNo().toString());
				purchagePayAmount.setBillPurchageQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity());
				purchagePayAmount.setBillPurchageRate(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate());
				purchagePayAmount.setBillQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillQuantity());
				purchagePayAmount.setBillVarietyId(purchageBillReport.getPurchagePayAmount().get(i).getBillVarietyId());
				purchagePayAmount.setBillPayBillId(report);
				purchagePayAmounts.add(purchagePayAmount);
				}
		
		}
		
		report.setPurchagePayAmount(purchagePayAmounts);
		
		
		List<PurchageBillTubs> purchageBillTubs =new ArrayList<PurchageBillTubs>();
		
		for(int i=0;i<purchageBillReport.getPurchageBillTubs().size();i++) {
			
			PurchageBillTubs purchageBillTub=new PurchageBillTubs();
				
			if(purchageBillReport.getPurchageBillTubs().get(i)!=null)
			{
				if (purchageBillReport.getBillReportLotNo().getBillLotNo() != null
						&& !purchageBillReport.getBillReportLotNo().getBillLotNo().toString().isEmpty())
				{	
						purchageBillTub.setBillLotNo(purchageBillReport.getBillReportLotNo().getBillLotNo().toString());
				}
				if (purchageBillReport.getPurchageBillTubs().get(i).getBillEmpty() != null
						&& !purchageBillReport.getPurchageBillTubs().get(i).getBillEmpty().isEmpty())
				{
					purchageBillTub.setBillEmpty(purchageBillReport.getPurchageBillTubs().get(i).getBillEmpty());
				}
				if (purchageBillReport.getPurchageBillTubs().get(i).getBillMaterialTubs() != null
						&& !purchageBillReport.getPurchageBillTubs().get(i).getBillMaterialTubs().isEmpty())
				{
						purchageBillTub.setBillMaterialTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillMaterialTubs());
				}
				if(purchageBillReport.getPurchageBillTubs().get(i).getBillQuantity()!=null && !purchageBillReport.getPurchageBillTubs().get(i).getBillQuantity().toString().isEmpty())
				{
					purchageBillTub.setBillQuantity(purchageBillReport.getPurchageBillTubs().get(i).getBillQuantity());
				}
				if(purchageBillReport.getPurchageBillTubs().get(i).getBillTotalTubs()!=null && !purchageBillReport.getPurchageBillTubs().get(i).getBillTotalTubs().isEmpty())
				{
					purchageBillTub.setBillTotalTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillTotalTubs());
				}
				if(report!=null)
				{
					purchageBillTub.setBillBillId(report);
				}
			
			purchageBillTubs.add(purchageBillTub);
			}
		
		}
		
		report.setPurchageBillTubs(purchageBillTubs);
		
		
		
		List<PurchageCompCountDetail> purchageCompCountDetail=new ArrayList<PurchageCompCountDetail>();
		
		for(int i=0;i<purchageBillReport.getPurchageCompCountDetail().size();i++){
			
		PurchageCompCountDetail purchageCompCount=new PurchageCompCountDetail();
		if(purchageBillReport.getPurchageCompCountDetail().get(i)!=null)
		{
			if(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount()!=null && !purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount().isEmpty()) {
			purchageCompCount.setBill25kGCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount());
			}
			purchageCompCount.setBillBillId(report);
			if(purchageBillReport.getPurchageCompCountDetail().get(i).getBillBlackSpot() !=null && !purchageBillReport.getPurchageCompCountDetail().get(i).getBillBlackSpot().toString().isEmpty()) {
			purchageCompCount.setBillBlackSpot(purchageBillReport.getPurchageCompCountDetail().get(i).getBillBlackSpot());
			}
			if(purchageBillReport.getPurchageCompCountDetail().get(i).getBillDiscolored()!=null && !purchageBillReport.getPurchageCompCountDetail().get(i).getBillDiscolored().toString().isEmpty()) {
			purchageCompCount.setBillDiscolored(purchageBillReport.getPurchageCompCountDetail().get(i).getBillDiscolored());
			}
			purchageCompCount.setBillLotNo(purchageBillReport.getBillReportLotNo().getBillLotNo().toString());
			if(purchageBillReport.getPurchageCompCountDetail().get(i).getBillPeeling()!=null && !purchageBillReport.getPurchageCompCountDetail().get(i).getBillPeeling().isEmpty()) {
			purchageCompCount.setBillPeeling(purchageBillReport.getPurchageCompCountDetail().get(i).getBillPeeling());
			}
			if(purchageBillReport.getPurchageCompCountDetail().get(i).getBilldCompCount()!=null && !purchageBillReport.getPurchageCompCountDetail().get(i).getBilldCompCount().toString().isEmpty()) {
			purchageCompCount.setBilldCompCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBilldCompCount());
			}
			purchageCompCountDetail.add(purchageCompCount);
		}
		}
		report.setPurchageCompCountDetail(purchageCompCountDetail);
		
		
		
		report.getBillReportLotNo().getPurchageWorkflow().setStatus("PURCHASE_WEIGHMENT");
		report.getBillReportLotNo().getPurchageWorkflow().setBillId(purchageBillReport.getBillId());
		
		userService.savePurchageBillReport(report);
		
		/*PurchageWorkflow purchageWorkflow=userService.findByWorkFlowId(report.getBillReportLotNo().getBillLotNo());
		
		purchageWorkflow.setBillId(report.getBillId()); // create purchage report status
		purchageWorkflow.setStatus("PURCHASE_WEIGHMENT");
		purchageWorkflow.setBilllotNo(weighmentObj);
		
		userService.updatePurchaseBill(purchageWorkflow);
		
		model.addAttribute("purchageWorkflow", purchageWorkflow);*/
		
		return purchageBillReport;
		
	}
	
	@RequestMapping(value ="/createPurchaseBillReportPage", method = RequestMethod.GET)
	public String  createPurchageBillReport(@RequestParam("id") String id,ModelMap model) {
		WeighmentVo weighment = fetchWeighment(id, userService);
		HashMap<String,BigDecimal> countMap=new HashMap<String,BigDecimal>();
		//HashMap<String,String> countNetMap=new HashMap<String,String>();
		Map<String,Map<String,BigDecimal>> totalCountVarietyQuantity=new HashMap<String,Map<String,BigDecimal>>();
		for (WeighmentDetailsVo weighmentDetailsVo : weighment.getWeighmentBillDetails()) 
			{
				if (weighmentDetailsVo != null && weighmentDetailsVo.getBilledBillCount()!=null) {
					if (!countMap.containsKey(weighmentDetailsVo.getBilledBillCount().toString())) {

						//countMap.put(weighmentDetailsVo.getBilledBillCount().toString(), weighmentDetailsVo.getBilledWgtKgs());
						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(), weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets()))));
					} else {
						BigDecimal finalWeight=weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets())));
						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(),
								countMap.get(weighmentDetailsVo.getBilledBillCount().toString())
										.add(finalWeight));
						
					}
				}
			}

		for (WeighmentVarietyDetailsVo weighmentVarietyDetailsVo : weighment.getWeighmentVarietyDetailsVo()) 
		{
			if (weighmentVarietyDetailsVo != null && weighmentVarietyDetailsVo.getBilledBillVarietyCount()!=null) {
				if (!totalCountVarietyQuantity.containsKey(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString())) {
					Map<String,BigDecimal> totalVarietyWithWieght=new HashMap<String,BigDecimal>();
					//countMap.put(weighmentDetailsVo.getBilledBillCount().toString(), weighmentDetailsVo.getBilledWgtKgs());
					totalVarietyWithWieght.put(weighmentVarietyDetailsVo.getBilledVarietyName(),weighmentVarietyDetailsVo.getBilledVarietyWgtKgs());
					totalVarietyWithWieght.put("Normal", countMap.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).subtract(weighmentVarietyDetailsVo.getBilledVarietyWgtKgs()));
					totalCountVarietyQuantity.put(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString(),totalVarietyWithWieght);
				}
				else {
					BigDecimal finalWeightByCat=BigDecimal.ZERO;
					if(totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).get(weighmentVarietyDetailsVo.getBilledVarietyName())!=null)
					{
					finalWeightByCat=totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).get(weighmentVarietyDetailsVo.getBilledVarietyName()).add(weighmentVarietyDetailsVo.getBilledVarietyWgtKgs());
					totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).put(weighmentVarietyDetailsVo.getBilledVarietyName(), finalWeightByCat);
					totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).put("Normal", totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).get("Normal").subtract(weighmentVarietyDetailsVo.getBilledVarietyWgtKgs()));

					}
					else {
						BigDecimal finalWeightByCatifvalnull=BigDecimal.ZERO;
						finalWeightByCat=finalWeightByCatifvalnull.add(weighmentVarietyDetailsVo.getBilledVarietyWgtKgs());
						totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).put(weighmentVarietyDetailsVo.getBilledVarietyName(), finalWeightByCat);
						totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).put("Normal", totalCountVarietyQuantity.get(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString()).get("Normal").subtract(weighmentVarietyDetailsVo.getBilledVarietyWgtKgs()));

					}
						
					//totalVarietyWithWieght.put(weighmentVarietyDetailsVo.getBilledVarietyName(), finalWeightByCat);
				//	totalCountVarietyQuantity.put(weighmentVarietyDetailsVo.getBilledBillVarietyCount().toString(),
						//	totalVarietyWithWieght);
					
				}
			}
			else {
				for (String key : countMap.keySet()) {
						Map<String,BigDecimal> totalVarietyWithWieght=new HashMap<String,BigDecimal>();
						totalVarietyWithWieght.put("Normal", countMap.get(key));
						totalCountVarietyQuantity.put(key,totalVarietyWithWieght);
					}

			}
		}

		if(countMap!=null && totalCountVarietyQuantity!=null && totalCountVarietyQuantity.size()<countMap.size())
		{
			for (String key : countMap.keySet()) {
				if(!totalCountVarietyQuantity.containsKey(key))
				{
					Map<String,BigDecimal> totalVarietyWithWieght=new HashMap<String,BigDecimal>();
					totalVarietyWithWieght.put("Normal", countMap.get(key));
					totalCountVarietyQuantity.put(key,totalVarietyWithWieght);

					
				}
			}
		}
			weighment.setTotalCountQuantity(countMap);
			weighment.setTotalCountVarietyQuantity(totalCountVarietyQuantity);
			model.addAttribute("weighmentPurchase", weighment);
			model.addAttribute("plantListPurchase", userService.findAllPlantDetails());
			model.addAttribute("varietyListPurchase", userService.findAllPlantVarietyDetails());

		return "createPurchaseBillReport";
	
	}
	
	@RequestMapping(value ="/findBillCount", method = RequestMethod.GET)
	public String  findBillCount(@RequestParam("lotNo") Integer lotNo,ModelMap model) {
		 List<Integer> weighmentDetails= userService.findBillCount(lotNo);
		 model.addAttribute("billCount", weighmentDetails);
		 
		 for(int i=0;i<weighmentDetails.size();i++) {
			 System.out.println("count.............."+weighmentDetails.get(i));
		 }
		 return null;
	}
	
	
/*	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
 
    @RequestMapping(value = { "/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }
 
    @RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }*/
    @RequestMapping(value ="/findByVarietyId", method = RequestMethod.GET)
	public PurchageShrimpVariety findByVarietyId(@RequestParam("varietyId") Integer varietyId,ModelMap model) {
		
		PurchageShrimpVariety purchageShrimpVariety=userService.findByVarietyId(varietyId);
		model.addAttribute("purchageShrimpVariety", purchageShrimpVariety);
		LOGGER.info("ShrimpType......." + purchageShrimpVariety.getBillShrimpType());
				
		return purchageShrimpVariety;
	}
	
	@RequestMapping(value ="/varietyDetails", method = RequestMethod.GET)
	public List<PurchageShrimpVariety> varietyDetails() {
		return userService.findAllPlantVarietyDetails();
	}
	
	@RequestMapping(value ="/plantByIdDetails", method = RequestMethod.GET)
	public PurchagePlant findPlantByIdDetails(@RequestParam("plantId") Integer plantId,ModelMap model) {
		
		PurchagePlant purchagePlant=userService.findByPlantId(plantId);
		
		model.addAttribute("purchagePlant", purchagePlant);
		LOGGER.info("BillPlantName......." + purchagePlant.getBillPlantName());
				
		return purchagePlant;
	}
	
	@RequestMapping(value ="/editPurchageBillReport", method = RequestMethod.GET)
	public String editPurchageBillReport(@RequestParam("id") String id,ModelMap model) {

		PurchageBillReportVo purchageBillReport = fetchPurchageBillReport(id, userService);
		model.addAttribute("purchageBillReport", purchageBillReport);
		LOGGER.info("BillAccountManager......." + purchageBillReport.getBillAccountManager());
		
		WeighmentVo weighment = fetchWeighment(id, userService);
		HashMap<String,BigDecimal> countMap=new HashMap<String,BigDecimal>();
		for (WeighmentDetailsVo weighmentDetailsVo : weighment.getWeighmentBillDetails()) 
			{
				if (weighmentDetailsVo != null) {
					if (!countMap.containsKey(weighmentDetailsVo.getBilledBillCount().toString())) {

						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(), weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets()))));
					} else {
						BigDecimal finalWeight=weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets())));

						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(),
								countMap.get(weighmentDetailsVo.getBilledBillCount().toString())
										.add(finalWeight));
					}
				}
			}

			weighment.setTotalCountQuantity(countMap);
			model.addAttribute("weighmentPurchaseEditPB", weighment);
			model.addAttribute("plantListPurchaseEditPB", userService.findAllPlantDetails());
			model.addAttribute("varietyListPurchaseEditPB", userService.findAllPlantVarietyDetails());
				
		return "editPurchageReport";
	}
	
	@RequestMapping(value = "/editPurchageBillReport", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	
	public WeighmentVo updatePurchageBillReport(HttpServletRequest request,@RequestBody PurchageBillReport purchageBillReport,ModelMap model,BindingResult result) throws IOException,ConnectException,TallyException {
	
		if (result.hasErrors()) {
			//return "editPurchageReport";
		}
		//Weighment weighmentObj=userService.findByLotId(purchageBillReport.getBillReportLotNo().getBillLotNo());
		//purchageBillReport.setBillReportLotNo(weighmentObj);
		
		InvoiceReport reportTally=tallyXMLData(purchageBillReport);
		
		WeighmentVo weighment=new WeighmentVo();
		
		if(reportTally.getErrorStatus().equalsIgnoreCase("0")) {
		
		userService.updatePurchageBillReport(purchageBillReport);
		
		weighment = fetchWeighment(purchageBillReport.getBillReportLotNo().getBillLotNo().toString(), userService);
		
		
		
		/*for (WeighmentDetailsVo weighmentDetailsVo : weighment.getWeighmentBillDetails()) 
			{
				if (weighmentDetailsVo != null) {
					if (!countMap.containsKey(weighmentDetailsVo.getBilledBillCount())) {

						countMap.put(weighmentDetailsVo.getBilledBillCount(), weighmentDetailsVo.getBilledWgtKgs());
					} else {
						countMap.put(weighmentDetailsVo.getBilledBillCount(),
								countMap.get(weighmentDetailsVo.getBilledBillCount())
										.add(weighmentDetailsVo.getBilledWgtKgs()));
					}
				}
			}*/

			//weighment.setTotalCountQuantity(countMap);
		weighment.setTotalInvoiceAmt(purchageBillReport.getTotalInvoiceAmt());
		weighment.setPurchageAmounts(purchageBillReport.getPurchagePayAmount());
		model.addAttribute("weighmentinvoice", weighment);
		return weighment;
		
		}else {

			weighment.setErrorMessage("Sorry!!! Invoice has not been generated in tally for the Lot No: "+purchageBillReport.getBillReportLotNo().getBillLotNo()+"Error:"+reportTally.getErrorStatus());
			weighment.setBillLotNo(purchageBillReport.getBillReportLotNo().getBillLotNo());
			
			model.addAttribute("weighmentinvoice", weighment);
			
			return weighment;
		}
	}
	public static PurchageBillReportVo fetchPurchageBillReport(String id,UserService userService)
	{
		PurchageBillReport purchageBillReport=userService.findByPurchageLotId(Integer.parseInt(id));
		
		PurchageBillReportVo purchageBillReportData=new PurchageBillReportVo();
		
		if(purchageBillReport!=null) {
		purchageBillReportData.setBillAccountManager(purchageBillReport.getBillAccountManager());
		purchageBillReportData.setBillAuthorized(purchageBillReport.getBillAuthorized());
		purchageBillReportData.setBillCertificate(purchageBillReport.getBillCertificate());
		purchageBillReportData.setBillNoCertificate(purchageBillReport.getBillNoCertificate());
		purchageBillReportData.setBillCreDt(purchageBillReport.getBillCreDt());
		purchageBillReportData.setBillCreId(purchageBillReport.getBillCreId());
		purchageBillReportData.setBillDriverName(purchageBillReport.getBillDriverName());
		purchageBillReportData.setBillGraderName(purchageBillReport.getBillGraderName());
		purchageBillReportData.setBillId(purchageBillReport.getBillId());
		purchageBillReportData.setBillPlantManager(purchageBillReport.getBillPlantManager());
		purchageBillReportData.setBillPurchageAuthorized(purchageBillReport.getBillPurchageAuthorized());
		purchageBillReportData.setBillPurchageManager(purchageBillReport.getBillPurchageManager());
		purchageBillReportData.setBillUpdDt(purchageBillReport.getBillUpdDt());
		purchageBillReportData.setBillUpdId(purchageBillReport.getBillUpdId());
		purchageBillReportData.setBillDispatchedBvrm(purchageBillReport.getBillDispatchedBvrm());
		purchageBillReportData.setBillDispatchedNsp(purchageBillReport.getBillDispatchedNsp());
		purchageBillReportData.setBillRemarks(purchageBillReport.getBillRemarks());
		purchageBillReportData.setTotalInvoiceAmt(purchageBillReport.getTotalInvoiceAmt());
		purchageBillReportData.setTotalInvoiceQuantity(purchageBillReport.getTotalInvoiceQuantity());
		if(purchageBillReport.getBillDueDate()!=null)
		{
		purchageBillReportData.setBillDueDate(dateFrmt.format(purchageBillReport.getBillDueDate()));
		}
		//purchageBillReportData.setBillDispatchedBvrm(purchageBillReport.getBillDispatchedBvrm());
		//purchageBillReportData.setBillDispatchedNsp(purchageBillReport.getBillDispatchedNsp());
		List<PurchageBillTubsVo> purchageBillTubsVo=new ArrayList<PurchageBillTubsVo>();
		
		for(int i=0;i<purchageBillReport.getPurchageBillTubs().size();i++) {
			
			PurchageBillTubsVo purchageBillTub =new PurchageBillTubsVo();
			purchageBillTub.setBillBillId(purchageBillReportData);
			purchageBillTub.setBillEmpty(purchageBillReport.getPurchageBillTubs().get(i).getBillEmpty());
			purchageBillTub.setBillLotNo(purchageBillReport.getPurchageBillTubs().get(i).getBillLotNo());
			purchageBillTub.setBillMaterialTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillMaterialTubs());
			purchageBillTub.setBillQuantity(purchageBillReport.getPurchageBillTubs().get(i).getBillQuantity());
			purchageBillTub.setBillTotalTubs(purchageBillReport.getPurchageBillTubs().get(i).getBillTotalTubs());
			purchageBillTub.setBillTubId(purchageBillReport.getPurchageBillTubs().get(i).getBillTubId());
			
			purchageBillTubsVo.add(purchageBillTub);
		}
		
		purchageBillReportData.setPurchageBillTubs(purchageBillTubsVo);
		
		List<PurchagePayAmountVo> purchagePayAmountVo=new ArrayList<PurchagePayAmountVo>();
		
		for(int i=0;i<purchageBillReport.getPurchagePayAmount().size();i++) {
			
			PurchagePayAmountVo purchagePayAmount=new PurchagePayAmountVo();
			
			purchagePayAmount.setBillCount(purchageBillReport.getPurchagePayAmount().get(i).getBillCount());
			purchagePayAmount.setBillLotNo(purchageBillReport.getPurchagePayAmount().get(i).getBillLotNo());
			purchagePayAmount.setBillPayBillId(purchageBillReportData);
			purchagePayAmount.setBillPayId(purchageBillReport.getPurchagePayAmount().get(i).getBillPayId());
			purchagePayAmount.setBillPurchageQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity());
			purchagePayAmount.setBillPurchageRate(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate());
			purchagePayAmount.setBillQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillQuantity());
			purchagePayAmount.setBillVarietyId(purchageBillReport.getPurchagePayAmount().get(i).getBillVarietyId());
			purchagePayAmountVo.add(purchagePayAmount);
		}
		
		purchageBillReportData.setPurchagePayAmount(purchagePayAmountVo);
		
		List<PurchageCompCountDetailVo> purchageCompCountDetailVo=new ArrayList<PurchageCompCountDetailVo>();
		
		for(int i=0;i<purchageBillReport.getPurchageCompCountDetail().size();i++) {
			
			PurchageCompCountDetailVo purchageCompCountDetail=new PurchageCompCountDetailVo();
			if(purchageBillReport.getPurchageCompCountDetail().get(i)!=null)
				{
		purchageCompCountDetail.setBill25kGCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount());
		purchageCompCountDetail.setBillBillId(purchageBillReportData);
		if(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount()!=null)
				{
				purchageCompCountDetail.setBill1kgc(Integer.parseInt(purchageBillReport.getPurchageCompCountDetail().get(i).getBill25kGCount())/25);
				}
		purchageCompCountDetail.setBillBlackSpot(purchageBillReport.getPurchageCompCountDetail().get(i).getBillBlackSpot());
		purchageCompCountDetail.setBillCompCountId(purchageBillReport.getPurchageCompCountDetail().get(i).getBillCompCountId());
		purchageCompCountDetail.setBillDiscolored(purchageBillReport.getPurchageCompCountDetail().get(i).getBillDiscolored());
		purchageCompCountDetail.setBillLotNo(purchageBillReport.getPurchageCompCountDetail().get(i).getBillLotNo());
		purchageCompCountDetail.setBillPeeling(purchageBillReport.getPurchageCompCountDetail().get(i).getBillPeeling());
		purchageCompCountDetail.setBilldCompCount(purchageBillReport.getPurchageCompCountDetail().get(i).getBilldCompCount());
		purchageCompCountDetailVo.add(purchageCompCountDetail);
		}
		}
		purchageBillReportData.setPurchageCompCountDetail(purchageCompCountDetailVo);
		
		}
		
		return purchageBillReportData;
	}
	@RequestMapping(value ="/viewPurchageBillReport", method = RequestMethod.GET)
	public String viewPurchageBillReport(@RequestParam("id") String id,ModelMap model) {

		PurchageBillReportVo purchageBillReport = fetchPurchageBillReport(id, userService);
		model.addAttribute("purchageBillReportView", purchageBillReport);
		LOGGER.info("BillAccountManager......." + purchageBillReport.getBillAccountManager());
		
		WeighmentVo weighment = fetchWeighment(id, userService);
		HashMap<String,BigDecimal> countMap=new HashMap<String,BigDecimal>();
		for (WeighmentDetailsVo weighmentDetailsVo : weighment.getWeighmentBillDetails()) 
			{
				if (weighmentDetailsVo != null) {
					if (!countMap.containsKey(weighmentDetailsVo.getBilledBillCount().toString())) {

						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(), weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets()))));
					} else {
						BigDecimal finalWeight=weighmentDetailsVo.getBilledWgtKgs().subtract(weighment.getBillSingleNetWeight().multiply(new BigDecimal(weighmentDetailsVo.getBilledNoOfNets())));

						countMap.put(weighmentDetailsVo.getBilledBillCount().toString(),
								countMap.get(weighmentDetailsVo.getBilledBillCount().toString())
										.add(finalWeight));
					}
				}
			}

			weighment.setTotalCountQuantity(countMap);
			model.addAttribute("weighmentPurchaseViewPB", weighment);
			model.addAttribute("plantListPurchaseViewPB", userService.findAllPlantDetails());
			model.addAttribute("varietyListPurchaseViewPB", userService.findAllPlantVarietyDetails());
				
		return "viewPurchageReport";
	}
	
	@RequestMapping(value ="/searchInvoice", method = RequestMethod.GET)
	public String  searchInvoicePage() {
	 return "searchInvoice";
	}
	

	@RequestMapping(value ="/searchInvoiceResults", method = RequestMethod.GET,produces="application/json")
	public  @ResponseBody List<InvoiceReportVo>  searchInvoice(@RequestParam("voucherNumber") String voucherNumber,@RequestParam("farmer") String farmer,
			 		@RequestParam("lotNo") Integer lotNo,
					@RequestParam("invoiceFromDate") String invoiceFromDate,
					@RequestParam("invoiceToDate") String invoiceToDate) {
		
					List<InvoiceReportVo> listWeighMent=new ArrayList<InvoiceReportVo>();
					
					List<InvoiceReport> invoiceReport=userService.findByType(voucherNumber, farmer, lotNo, invoiceFromDate, invoiceToDate);
					
					for(int i=0;i<invoiceReport.size();i++) {
						InvoiceReportVo reportVo=new InvoiceReportVo();
						
						reportVo.setCreateDate(invoiceReport.get(i).getCreateDate());
						reportVo.setCreatedBy(invoiceReport.get(i).getCreatedBy());
						reportVo.setCreateTime(invoiceReport.get(i).getCreateTime());
						reportVo.setErrorStatus(invoiceReport.get(i).getErrorStatus());
						reportVo.setFormerName(invoiceReport.get(i).getFormerName());
						reportVo.setInvoiceId(invoiceReport.get(i).getInvoiceId());
						reportVo.setInvoiceLotNo(invoiceReport.get(i).getInvoiceLotNo());
						reportVo.setInvoiceRemoteId(invoiceReport.get(i).getInvoiceRemoteId());
						reportVo.setInvoiceStatus(invoiceReport.get(i).getInvoiceStatus());
						reportVo.setVoucherId(invoiceReport.get(i).getVoucherId());
						reportVo.setVoucherNumber(invoiceReport.get(i).getVoucherNumber());
						listWeighMent.add(reportVo);
					}
					
				return listWeighMent;
	}
	
	@RequestMapping(value ="/viewInvoice", method = RequestMethod.GET,produces="application/json")
		public  @ResponseBody WeighmentVo  searchInvoice(@RequestParam("lotNo") String lotNo,ModelMap model) {
			WeighmentVo weighmentObj=AppController.fetchWeighment(lotNo,userService);
			PurchageBillReport purchageBillReport=userService.findByPurchageLotId(Integer.parseInt(lotNo));
			weighmentObj.setTotalInvoiceAmt(purchageBillReport.getTotalInvoiceAmt());
			List<PurchagePayAmount> purchagePayAmountList=new ArrayList<PurchagePayAmount>();
			for(int i=0;i<purchageBillReport.getPurchagePayAmount().size();i++) {
				PurchagePayAmount purchagePayAmount=new PurchagePayAmount();
				purchagePayAmount.setBillCount(purchageBillReport.getPurchagePayAmount().get(i).getBillCount());
				purchagePayAmount.setBillLotNo(purchageBillReport.getPurchagePayAmount().get(i).getBillLotNo());
				purchagePayAmount.setBillPurchageQuantity(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity());
				purchagePayAmount.setBillPurchageRate(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate());
				purchagePayAmountList.add(purchagePayAmount);
			}
			weighmentObj.setPurchageAmounts(purchagePayAmountList);
					return weighmentObj;
	}
	@RequestMapping(value ="/findWeighmentStatus", method = RequestMethod.GET)
		public String  findWeighmentStatus(ModelMap model) {
			 List<Weighment> weighmentStatus= userService.findAllWeighmentWithStatus();
			 model.addAttribute("weighmentStatus", weighmentStatus);
			 
			 return null;
	}
	
	public InvoiceReport tallyXMLData(PurchageBillReport purchageBillReport) throws IOException,ConnectException,TallyException {
		
		Integer lotNo=purchageBillReport.getBillReportLotNo().getBillLotNo();
		
		String random=UUID.randomUUID().toString();
		LOGGER.info("Remarks text:::::"+purchageBillReport.getBillRemarks());
		String partyName="";
		String DATE_FORMAT = "yyyyMMdd";
	    SimpleDateFormat sdf =
	          new SimpleDateFormat(DATE_FORMAT);
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
	    String billReportDate="";
	    String strFormattedDateDate="";
	    if(purchageBillReport.getBillReportLotNo().getBillDate()!=null)
	    {
	    billReportDate=sdf.format(purchageBillReport.getBillReportLotNo().getBillDate().getTime());
	    strFormattedDateDate = formatter.format(purchageBillReport.getBillReportLotNo().getBillDate());
	    }
		
		
			partyName=purchageBillReport.getBillReportLotNo().getBillChequeName();
	 
		PurchagePlant purchagePlant= userService.findByPlantId(Integer.parseInt(purchageBillReport.getBillReportLotNo().getBillPlantId()));
		String customizedBillNumber=generateBillNumberByPlant(purchagePlant);
		System.out.println("BillNumber::::"+customizedBillNumber);
		BigDecimal invoiceAmt=purchageBillReport.getTotalInvoiceAmt().setScale(3, BigDecimal.ROUND_HALF_UP);
	
	TXML="<ENVELOPE>"+
    		" <HEADER>"+
    		"  <TALLYREQUEST>Import Data</TALLYREQUEST>"+
    		" </HEADER>"+
    		" <BODY>"+
    		"  <IMPORTDATA>"+
    		"   <REQUESTDESC>"+
    		"    <REPORTNAME>Vouchers</REPORTNAME>"+
    		"    <STATICVARIABLES>"+
 		"     <SVCURRENTCOMPANY>Jagadeesh Marine Exports 17-18</SVCURRENTCOMPANY>"+
   		
//"     <SVCURRENTCOMPANY>JME Dummy 2017-18</SVCURRENTCOMPANY>"+
		"    </STATICVARIABLES>"+
    		"   </REQUESTDESC>"+
    		"   <REQUESTDATA>"+
    		"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">"+
    		"     <VOUCHER REMOTEID=\""+random+"\" VCHKEY=\""+random+":"+lotNo.toString()+"\" VCHTYPE=\"R.M Purchase\" ACTION=\"Create\" OBJVIEW=\"Accounting Voucher View\">"+
		//"     <VOUCHER REMOTEID=\"87e16fab-cc61-4254-af6f-17f56868aa69-234087626\" VCHKEY=\"87e16fab-cc61-4254-af6f-17f54566868aa55-0000a7c3:00000110\" VCHTYPE=\"Purchase\" ACTION=\"Create\" OBJVIEW=\"Accounting Voucher View\">"+

    	"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">"+
    		"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>"+
    		"      </OLDAUDITENTRYIDS.LIST>"+
    		"      <DATE>"+billReportDate+"</DATE>"+
//"<DATE>20170801</DATE>"+
    		"      <REFERENCEDATE>"+billReportDate+"</REFERENCEDATE>"+
    		//"      <GUID>"+random+"</GUID>"+
    		"<GUID>"+random+"</GUID>"+
    		"      <STATENAME>Andhra Pradesh</STATENAME>"+
    		"	<NARRATION>"+purchageBillReport.getBillRemarks()+"</NARRATION>"+
    		"      <VATDEALERTYPE>Regular</VATDEALERTYPE>"+
    		"      <PARTYNAME>"+partyName+"</PARTYNAME>"+
    		"      <VOUCHERTYPENAME>Purchase</VOUCHERTYPENAME>"+
    		"      <REFERENCE>N0-"+lotNo+"</REFERENCE>"+
    		"      <VOUCHERNUMBER>N0-"+lotNo+"</VOUCHERNUMBER>"+
    		"      <PARTYLEDGERNAME>"+partyName+"</PARTYLEDGERNAME>"+
    		"      <BASICBASEPARTYNAME>"+partyName+"</BASICBASEPARTYNAME>"+
    		"      <FBTPAYMENTTYPE>Default</FBTPAYMENTTYPE>"+
    		"      <PERSISTEDVIEW>Accounting Voucher View</PERSISTEDVIEW>"+
    		"      <BASICDATETIMEOFINVOICE>"+strFormattedDateDate+" "+"at"+" "+new Date().getHours()+":"+new Date().getMinutes()+"</BASICDATETIMEOFINVOICE>"+
    	//"<BASICDATETIMEOFINVOICE>1-Aug-2017 at 09:10</BASICDATETIMEOFINVOICE>"+
    		"      <BASICDATETIMEOFREMOVAL>"+strFormattedDateDate+" "+"at"+" "+new Date().getHours()+":"+new Date().getMinutes()+"</BASICDATETIMEOFREMOVAL>"+
    		"      <ENTEREDBY>System</ENTEREDBY>"+
    		"      <DIFFACTUALQTY>No</DIFFACTUALQTY>"+
    		"      <ISMSTFROMSYNC>No</ISMSTFROMSYNC>"+
    		"      <ASORIGINAL>No</ASORIGINAL>"+
    		"      <AUDITED>No</AUDITED>"+
    		"      <FORJOBCOSTING>No</FORJOBCOSTING>"+
    		"      <ISOPTIONAL>No</ISOPTIONAL>"+
    		"      <EFFECTIVEDATE>"+billReportDate+"</EFFECTIVEDATE>"+
    		"      <USEFOREXCISE>No</USEFOREXCISE>"+
    		"      <ISFORJOBWORKIN>No</ISFORJOBWORKIN>"+
    		"      <ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>"+
    		"      <USEFORINTEREST>No</USEFORINTEREST>"+
    		"      <USEFORGAINLOSS>No</USEFORGAINLOSS>"+
    		"      <USEFORGODOWNTRANSFER>No</USEFORGODOWNTRANSFER>"+
    		"      <USEFORCOMPOUND>No</USEFORCOMPOUND>"+
    		"      <USEFORSERVICETAX>No</USEFORSERVICETAX>"+
    		"      <ISEXCISEVOUCHER>No</ISEXCISEVOUCHER>"+
    		"      <EXCISETAXOVERRIDE>No</EXCISETAXOVERRIDE>"+
    		"      <USEFORTAXUNITTRANSFER>No</USEFORTAXUNITTRANSFER>"+
    		"      <EXCISEOPENING>No</EXCISEOPENING>"+
    		"      <USEFORFINALPRODUCTION>No</USEFORFINALPRODUCTION>"+
    		"      <ISTDSOVERRIDDEN>No</ISTDSOVERRIDDEN>"+
    		"      <ISTCSOVERRIDDEN>No</ISTCSOVERRIDDEN>"+
    		"      <ISTDSTCSCASHVCH>No</ISTDSTCSCASHVCH>"+
    		"      <INCLUDEADVPYMTVCH>No</INCLUDEADVPYMTVCH>"+
    		"      <ISSUBWORKSCONTRACT>No</ISSUBWORKSCONTRACT>"+
    		"      <ISVATOVERRIDDEN>No</ISVATOVERRIDDEN>"+
    		"      <IGNOREORIGVCHDATE>No</IGNOREORIGVCHDATE>"+
    		"      <ISSERVICETAXOVERRIDDEN>No</ISSERVICETAXOVERRIDDEN>"+
    		"      <ISISDVOUCHER>No</ISISDVOUCHER>"+
    		"      <ISEXCISEOVERRIDDEN>No</ISEXCISEOVERRIDDEN>"+
    		"      <ISEXCISESUPPLYVCH>No</ISEXCISESUPPLYVCH>"+
    		"      <ISGSTOVERRIDDEN>No</ISGSTOVERRIDDEN>"+
    		"      <GSTNOTEXPORTED>No</GSTNOTEXPORTED>"+
    		"      <ISVATPRINCIPALACCOUNT>No</ISVATPRINCIPALACCOUNT>"+
    		"      <ISSHIPPINGWITHINSTATE>No</ISSHIPPINGWITHINSTATE>"+
    		"      <ISCANCELLED>No</ISCANCELLED>"+
    		"      <HASCASHFLOW>No</HASCASHFLOW>"+
    		"      <ISPOSTDATED>No</ISPOSTDATED>"+
    		"      <USETRACKINGNUMBER>No</USETRACKINGNUMBER>"+
    		"      <ISINVOICE>No</ISINVOICE>"+
    		"      <MFGJOURNAL>No</MFGJOURNAL>"+
    		"      <HASDISCOUNTS>No</HASDISCOUNTS>"+
    		"      <ASPAYSLIP>No</ASPAYSLIP>"+
    		"      <ISCOSTCENTRE>No</ISCOSTCENTRE>"+
    		"      <ISSTXNONREALIZEDVCH>No</ISSTXNONREALIZEDVCH>"+
    		"      <ISEXCISEMANUFACTURERON>Yes</ISEXCISEMANUFACTURERON>"+
    		"      <ISBLANKCHEQUE>No</ISBLANKCHEQUE>"+
    		"      <ISVOID>No</ISVOID>"+
    		"      <ISONHOLD>No</ISONHOLD>"+
    		"      <ORDERLINESTATUS>No</ORDERLINESTATUS>"+
    		"      <VATISAGNSTCANCSALES>No</VATISAGNSTCANCSALES>"+
    		"      <VATISPURCEXEMPTED>No</VATISPURCEXEMPTED>"+
    		"      <ISVATRESTAXINVOICE>No</ISVATRESTAXINVOICE>"+
    		"      <VATISASSESABLECALCVCH>No</VATISASSESABLECALCVCH>"+
    		"      <ISVATDUTYPAID>Yes</ISVATDUTYPAID>"+
    		"      <ISDELIVERYSAMEASCONSIGNEE>No</ISDELIVERYSAMEASCONSIGNEE>"+
    		"      <ISDISPATCHSAMEASCONSIGNOR>No</ISDISPATCHSAMEASCONSIGNOR>"+
    		"      <ISDELETED>No</ISDELETED>"+
    		"      <CHANGEVCHMODE>No</CHANGEVCHMODE>"+
    	/*	"      <ALTERID> 241497</ALTERID>"+
    		"      <MASTERID> 95781</MASTERID>"+
    		"      <VOUCHERKEY>184455960461584</VOUCHERKEY>"+*/
    		"      <ALLLEDGERENTRIES.LIST>"+
    		"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">"+
    		"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>"+
    		"       </OLDAUDITENTRYIDS.LIST>"+
    		"       <LEDGERNAME>"+partyName+"</LEDGERNAME>"+
    		"       <GSTCLASS/>"+
    		"       <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>"+
    		"       <LEDGERFROMITEM>No</LEDGERFROMITEM>"+
    		"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>"+
    		"       <ISPARTYLEDGER>Yes</ISPARTYLEDGER>"+
    		"       <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>"+
    		"       <AMOUNT>"+invoiceAmt+"</AMOUNT>"+
    		"       <VATEXPAMOUNT>"+invoiceAmt+"</VATEXPAMOUNT>"+
    		"       <BILLALLOCATIONS.LIST>"+
    		"        <NAME>N0-"+lotNo+"</NAME>"+
    		"        <BILLTYPE>New Ref</BILLTYPE>"+
    		"        <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>"+
    		"        <AMOUNT>"+invoiceAmt+"</AMOUNT>"+
    		"      </BILLALLOCATIONS.LIST>"+
    		"      </ALLLEDGERENTRIES.LIST>"+
    		"      <ALLLEDGERENTRIES.LIST>"+
    		"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">"+
    		"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>"+
    		"       </OLDAUDITENTRYIDS.LIST>"+
    		"       <LEDGERNAME>Prawn - Vannamei Purchases</LEDGERNAME>"+
    		"       <GSTCLASS/>"+
    		"       <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"+
    		"       <LEDGERFROMITEM>No</LEDGERFROMITEM>"+
    		"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>"+
    		"       <ISPARTYLEDGER>No</ISPARTYLEDGER>"+
    		"       <ISLASTDEEMEDPOSITIVE>Yes</ISLASTDEEMEDPOSITIVE>"+
    		"       <AMOUNT>-"+invoiceAmt+"</AMOUNT>"+
    		"       <VATEXPAMOUNT>-"+invoiceAmt+"</VATEXPAMOUNT>";
	
    		 for(int i=0;i<purchageBillReport.getPurchagePayAmount().size();i++) {
    			if(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()!=null && purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate()!=null)
    			{
    			 String xmlInvList="<INVENTORYALLOCATIONS.LIST>";
    			 xmlInvList=xmlInvList+"<STOCKITEMNAME>"+purchageBillReport.getPurchagePayAmount().get(i).getBillCount() +" "+"C"+"</STOCKITEMNAME>"+
    		"        <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"+
    		"        <ISLASTDEEMEDPOSITIVE>Yes</ISLASTDEEMEDPOSITIVE>"+
    		"        <ISAUTONEGATE>No</ISAUTONEGATE>"+
    		"        <ISCUSTOMSCLEARANCE>No</ISCUSTOMSCLEARANCE>"+
    		"        <ISTRACKCOMPONENT>No</ISTRACKCOMPONENT>"+
    		"        <ISTRACKPRODUCTION>No</ISTRACKPRODUCTION>"+
    		"        <ISPRIMARYITEM>No</ISPRIMARYITEM>"+
    		"        <ISSCRAP>No</ISSCRAP>"+
    		"        <RATE>"+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate()+"/kg.</RATE>"+
    		"        <AMOUNT>-"+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate().multiply(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()).setScale(3, BigDecimal.ROUND_HALF_UP)+"</AMOUNT>"+
    		"        <ACTUALQTY>"+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()+" kg.</ACTUALQTY>"+
    		"        <BILLEDQTY> "+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()+" kg.</BILLEDQTY>"+
    		"        <BATCHALLOCATIONS.LIST>"+
    		"         <GODOWNNAME>"+purchagePlant.getBillPlantShortName()+"</GODOWNNAME>"+
    		"         <BATCHNAME>Primary Batch</BATCHNAME>"+
    		"         <DESTINATIONGODOWNNAME>"+purchagePlant.getBillPlantShortName()+"</DESTINATIONGODOWNNAME>"+
    		"         <DYNAMICCSTISCLEARED>No</DYNAMICCSTISCLEARED>"+
    		"         <AMOUNT>-"+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageRate().multiply(purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()).setScale(3, BigDecimal.ROUND_HALF_UP)+"</AMOUNT>"+
    		"         <ACTUALQTY> "+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()+" kg.</ACTUALQTY>"+
    		"         <BILLEDQTY> "+purchageBillReport.getPurchagePayAmount().get(i).getBillPurchageQuantity()+" kg.</BILLEDQTY>"+
    		"        </BATCHALLOCATIONS.LIST>"+
    		"       </INVENTORYALLOCATIONS.LIST>";
    			 TXML=TXML+xmlInvList;
    			}
    		}
	
    		 TXML=TXML+"</ALLLEDGERENTRIES.LIST></VOUCHER></TALLYMESSAGE></REQUESTDATA></IMPORTDATA></BODY></ENVELOPE>";
    		 
    		 String Url = "http://172.16.1.1:9000/";      
    		 
    		// String Url = "http://172.16.1.59:9000/";      

    	        String SOAPAction = "";
    	       
    	        String Voucher = TXML;
    	        LOGGER.debug("XML..............."+Voucher);
    	        //System.out.println(Voucher);

    	// Create the connection where we're going to send the file.
    	        URL url = new URL(Url);
    	        URLConnection connection = url.openConnection();
    	        HttpURLConnection httpConn = (HttpURLConnection) connection;
    	        LOGGER.info("Tally connection........."+httpConn);
    	       
    	        ByteArrayInputStream bin = new ByteArrayInputStream(Voucher.getBytes());
    	        ByteArrayOutputStream bout = new ByteArrayOutputStream();

    	// Copy the SOAP file to the open connection.
    	       
    	        copy(bin, bout);     

    	        byte[] b = bout.toByteArray();

    	// Set the appropriate HTTP parameters.
    	        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
    	        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
    	        httpConn.setRequestProperty("SOAPAction", SOAPAction);
    	        httpConn.setRequestMethod("POST");
    	        httpConn.setDoOutput(true);
    	        httpConn.setDoInput(true);

    	// Everything's set up; send the XML that was read in to b.
    	        OutputStream out = null;
    	        try {
    	         out = httpConn.getOutputStream();
    	        }catch(java.net.ConnectException jnc) {
	    			plantList.get(purchagePlant.getBillPlantId()).setBillPlantCounter(plantList.get(purchagePlant.getBillPlantId()).getBillPlantCounter()-1);

    	        	LOGGER.error("Tally Server is not Responding...", jnc.getStackTrace());
    	        	
						throw new java.net.ConnectException();
				
    	        }
    	        finally{
    	        	
    	        	if(null !=out)
    	        	{
    	        		out.write(b);
    	        		out.close();
    	        	}
    	        }

    	// Read the response and write it to standard out.

    	        InputStreamReader isr =
    	                new InputStreamReader(httpConn.getInputStream());
    	        BufferedReader in = new BufferedReader(isr);

    	        String inputLine;
    	        
    	        InvoiceReport report=null;
    	        	String responseXml="";
    	        while ((inputLine = in.readLine()) != null) {
    	        	responseXml=responseXml+inputLine;
    	        	LOGGER.info(inputLine);
    	        	
    	        }
    	        	JAXBContext jaxbContext;
					try {
						jaxbContext = JAXBContext.newInstance(Response.class);
						StringReader rawXml=new StringReader(responseXml.trim().toLowerCase());
	    	        	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    	    		Response response = (Response) jaxbUnmarshaller.unmarshal(rawXml);
	    	    		if(response!=null && response.getErrors()!=null)
	    	    		{
	    	    		if(response.getErrors() == 0) {
	    	    			
	    	    			report=new InvoiceReport();
	    	    			
	    	    			report.setErrorStatus(response.getErrors().toString());
	    	    			report.setInvoiceRemoteId(random);
	    	    			report.setVoucherId(response.getLastvchid().toString());
	    	    			report.setVoucherNumber("N0-"+lotNo.toString());
	    	    			report.setInvoiceStatus("Success");
	    	    			report.setFormerName(partyName);
	    	    			report.setCreateDate(new Date());
	    	    			report.setCreateTime(new Date());
	    	    			report.setCreatedBy("System");
	    	    			report.setInvoiceLotNo(lotNo);
	    	    			userService.saveInvoiceReport(report);
	    	    		}else if(response.getErrors() == 1){
	    	    			plantList.get(purchagePlant.getBillPlantId()).setBillPlantCounter(plantList.get(purchagePlant.getBillPlantId()).getBillPlantCounter()-1);
	    	    			throw new TallyException(response.getLineerror());
	    	    		}
	    	    		}
	    	    		if(response.getLineerror()!=null)
	    	    		{
	    	    			plantList.get(purchagePlant.getBillPlantId()).setBillPlantCounter(plantList.get(purchagePlant.getBillPlantId()).getBillPlantCounter()-1);

	    	    			throw new TallyException(response.getLineerror());
	    	    		}
					} catch (JAXBException e) {
						e.printStackTrace();
					}

    	        	
    	        

    	        in.close();
    	        
    	        return report;
    	    }

  public String generateBillNumberByPlant(PurchagePlant purchagePlant) {
		
	 String billNumber=purchagePlant.getBillPlantPrefix()+sh.get(new SimpleDateFormat("MMMM").format(new Date()))+"-"+prepareBillNumber(purchagePlant);
	  
	  return billNumber;
	}

	public String prepareBillNumber(PurchagePlant billPalnt) {
		PurchagePlant countPlant=plantList.get(billPalnt.getBillPlantId());
		if(countPlant.getBillPlantMonth()!=null)
		{
		if(Integer.parseInt(sh.get(countPlant.getBillPlantMonth()))<Integer.parseInt(sh.get(new SimpleDateFormat("MMMM").format(new Date()))))
		{
			countPlant.setBillPlantCounter(0);
			countPlant.setBillPlantCounter(countPlant.getBillPlantCounter()+1);
			countPlant.setBillPlantMonth(new SimpleDateFormat("MMMM").format(new Date()));
			plantList.put(countPlant.getBillPlantId(), countPlant);
			return setThreedigits(countPlant);
		}
		else {
			countPlant.setBillPlantCounter(countPlant.getBillPlantCounter()+1);
			countPlant.setBillPlantMonth(new SimpleDateFormat("MMMM").format(new Date()));
			plantList.put(countPlant.getBillPlantId(), countPlant);
			return setThreedigits(countPlant);

		}
		}
		else {
			countPlant.setBillPlantCounter(0);
			countPlant.setBillPlantCounter(countPlant.getBillPlantCounter()+1);
			countPlant.setBillPlantMonth(new SimpleDateFormat("MMMM").format(new Date()));
			plantList.put(countPlant.getBillPlantId(), countPlant);
			return setThreedigits(countPlant);
		}
}

			private String setThreedigits(PurchagePlant countPlant) {
		
				if(countPlant.getBillPlantCounter()<10)
				{
					return "00"+countPlant.getBillPlantCounter();
					
				}
				else if(countPlant.getBillPlantCounter()>=10 && countPlant.getBillPlantCounter()<100)
				{
					return "0"+countPlant.getBillPlantCounter();
				}
				
				else {
					return String.valueOf(countPlant.getBillPlantCounter());
				}
		
	}

			public static void copy(InputStream in, OutputStream out)
    	            throws IOException {

    	// do not allow other threads to read from the
    	// input or write to the output while copying is
    	// taking place

    	        synchronized (in) {
    	            synchronized (out) {

    	                byte[] buffer = new byte[256];
    	                while (true) {
    	                    int bytesRead = in.read(buffer);
    	                    if (bytesRead == -1) {
    	                        break;
    	                    }
    	                    out.write(buffer, 0, bytesRead);
    	                }
    	            }
    	        }
	}
    	    
   
    	    
    	    
   /*
    * sync REST calls
    */
    	    
    	    @RequestMapping(value ="/createSyncData", method = RequestMethod.GET)
    		public String createSyncData(HttpServletRequest request,ModelMap model) {
    			
    			return "syncData";
    		}
	
    	    @RequestMapping(value = "/createSyncData", method = RequestMethod.POST,consumes="application/json",produces="application/json")
    		@ResponseBody
    		public  Employee createSyncData(HttpServletRequest request, @RequestBody Employee employee,@RequestBody TabSync tab,ModelMap model) 
    		{
    	    	Employee emp=new Employee();
    	    	emp.setDate(new Date());
    	    	emp.setEmpName("empName");
    	    	emp.setTabId("123456");
    	    	
    	    	userService.saveEmployee(emp);
    	    	
    	    	TabSync tabSync=new TabSync();
    	    	tabSync.setSyncTime(new Date());
    	    	tabSync.setTabId("123456");
    	    	
    	    	userService.saveTabSync(tabSync);
    	    	
    	    	return null;
    		}
    	    
    	    @RequestMapping(value ="/findByTabId", method = RequestMethod.GET)
    		public TabSync findByTabId(@RequestParam("tabId") Integer tabId,ModelMap model) {
    			
    	    	TabSync tabSync=userService.findByTabId(tabId.toString());
    			model.addAttribute("tabSyncData", tabSync);
    			LOGGER.info("Tab ID......." + tabSync.getTabId());
    					
    			return tabSync;
    		}
    	    
    @RequestMapping(value = "/createWeighmentSaveDraft", method = RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public  WeighmentTemp createWeighmentSaveDraft(HttpServletRequest request, @RequestBody WeighmentTemp weighment,ModelMap model) 
    {
    			
    			LOGGER.info("Cheque Name.........."+weighment.getBillAgentName());
    			
    			// ModelAndView mav = new ModelAndView("createWeighment");
    			
    			User user=(User)request.getSession().getAttribute("user");
    			
    			WeighmentTemp weighmentData = new WeighmentTemp();
    			weighmentData.setBillAgentName(weighment.getBillAgentName());
    			weighmentData.setBillAgentMobile(weighment.getBillAgentMobile());
    			weighmentData.setBillBt(weighment.getBillBt());
    			weighmentData.setBillChequeName(weighment.getBillChequeName());
    			weighmentData.setBillCount(weighment.getBillCount());
    			weighmentData.setBillCreDt(weighment.getBillCreDt());
    			//weighmentData.setBillCreDt(new Date());
    			weighmentData.setBillCreId(user.getId().toString());
    			//weighmentData.setBillDate(weighment.getBillDate());
    			weighmentData.setBillDate(new Date());
    			weighmentData.setBillFormerMobile(weighment.getBillFormerMobile());
    			weighmentData.setBillFormerName(weighment.getBillFormerName());
    			//weighmentData.setBillHalt(weighment.getBillHalt());
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
    			
    			weighmentData.setBillMaterialTubs(weighment.getBillMaterialTubs());
    			weighmentData.setBillEmpty(weighment.getBillEmpty());
    			weighmentData.setBillTotalTubs(weighment.getBillTotalTubs());
    			weighmentData.setBillSingleNetWeight(weighment.getBillSingleNetWeight());
    			
    			weighmentData.setBillSupervisorName(weighment.getBillSupervisorName());
    			
    			List<WeighmentDetailsTemp> purchageBillDetails =new ArrayList<WeighmentDetailsTemp>();
    			
    			for(int i=0;i<weighment.getPurchageBillDetails().size();i++) {
    			
    				WeighmentDetailsTemp weighmentDetails=new WeighmentDetailsTemp();
    					
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
    			
    		
    			    			
    			userService.savePurchageBillDraft(weighmentData);
    			
    			System.out.println("Lot Number created as........"+weighmentData.getBillLotNo());
    			weighment.setBillLotNo(weighmentData.getBillLotNo());
    				
    			return weighment;
    		}
    
	@RequestMapping(value ="/deletePurchageCountColumnData", method = RequestMethod.POST)
	public String findByLotNoAndId(@RequestParam("id") Integer id,ModelMap model) {
		userService.findByLotNoAndId(id);
		return "deletePurchageCountColumnData";
	}
	
	@RequestMapping(value ="/deleteWeighmentVariety", method = RequestMethod.POST)
	public  @ResponseBody String deleteWeighmentVariety(@RequestParam("id") Integer id,ModelMap model) {
		userService.deleteWeighmentVariety(id);
		return "deleteWeighmentVariety";
	}
	@RequestMapping(value ="/revokeSearchPurchageBill", method = RequestMethod.GET)
	public String revokeSearchPurchaseBill() {
		
		return "revokeSearchPage";
	}
	@RequestMapping(value ="/revokePurchageBill", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  String revokePurchaseBill(HttpServletRequest request,@RequestBody PurchageWorkflow purchageWorkflow,ModelMap model) {
		PurchageWorkflow puchageWorkFlow=userService.findByWorkFlowId(purchageWorkflow.getWorkflowId());
		puchageWorkFlow.setStatus("PURCHASE_WEIGHMENT");
		userService.updatePurchaseBill(puchageWorkFlow);
		PurchageWorkflowVo purchaseBillWFVo=new PurchageWorkflowVo();
		purchaseBillWFVo.setBilllotNo(puchageWorkFlow.getBilllotNo());
		purchaseBillWFVo.setStatus(puchageWorkFlow.getStatus());
		model.addAttribute("lotNo", puchageWorkFlow.getBilllotNo().getBillLotNo());
		return "success";
	}
	
	
	@PostConstruct
    public void init(){
		LOGGER.info("Tab ID......." );
		List<PurchagePlant> plantListCache=userService.findAllPlantDetails();
		for (PurchagePlant plant : plantListCache) {
			plantList.put(plant.getBillPlantId(), plant);
			}
		}
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Spring Container is destroy! Customer clean up"+plantList);
	  plantList.forEach((key, value) -> {
		  PurchagePlant dataBasePlant =userService.findByPlantId(key);
		  dataBasePlant.setBillPlantCounter(value.getBillPlantCounter());
		  dataBasePlant.setBillPlantMonth(value.getBillPlantMonth());
		  userService.updatePlantsWithCounter(dataBasePlant);
		});
	  }

}