package com.jme.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="M_USER")
public class Users implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userName;
	private String userPassword;
	private UserGroup userGrpId;
	private String userPlantId;
	private Date userExpyDate; 
	private String userType;
	private String userencrPass;
	private String userAddress;
	private String userAddress1;
	private String userIdtyDoc;
	private String userOffTel;
	private String userMobileNo;
	private String userEmail;
	private String userActv;
	private String userCreId;
	private Date userCreDt;
	private String userUpdId;
	private Date userUpdDt;
	
	public Users() {}
	
	public Users(Integer userId, String userName, String userPassword, UserGroup userGrpId, String userPlantId,
			Date userExpyDate, String userType, String userencrPass, String userAddress, String userAddress1,
			String userIdtyDoc, String userOffTel, String userMobileNo, String userEmail, String userActv,
			String userCreId, Date userCreDt, String userUpdId, Date userUpdDt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGrpId = userGrpId;
		this.userPlantId = userPlantId;
		this.userExpyDate = userExpyDate;
		this.userType = userType;
		this.userencrPass = userencrPass;
		this.userAddress = userAddress;
		this.userAddress1 = userAddress1;
		this.userIdtyDoc = userIdtyDoc;
		this.userOffTel = userOffTel;
		this.userMobileNo = userMobileNo;
		this.userEmail = userEmail;
		this.userActv = userActv;
		this.userCreId = userCreId;
		this.userCreDt = userCreDt;
		this.userUpdId = userUpdId;
		this.userUpdDt = userUpdDt;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID",unique=true,nullable=false,length=10,insertable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="USER_NAME",length=100,nullable=false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="USER_PASSWORD",length=50,nullable=false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_GRP_ID",nullable=false)
	public UserGroup getUserGrpId() {
		return userGrpId;
	}

	public void setUserGrpId(UserGroup userGrpId) {
		this.userGrpId = userGrpId;
	}
	
	@Column(name="USER_PLANT_ID",length=20)
	public String getUserPlantId() {
		return userPlantId;
	}

	public void setUserPlantId(String userPlantId) {
		this.userPlantId = userPlantId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="USER_EXPY_DATE")
	public Date getUserExpyDate() {
		return userExpyDate;
	}

	public void setUserExpyDate(Date userExpyDate) {
		this.userExpyDate = userExpyDate;
	}
	
	@Column(name="USER_TYPE",length=1)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Column(name="USER_ENCR_PASS",length=100)
	public String getUserencrPass() {
		return userencrPass;
	}

	public void setUserencrPass(String userencrPass) {
		this.userencrPass = userencrPass;
	}
	
	@Column(name="USER_ADRESS",length=200)
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	@Column(name="USER_ADRESS_1",length=200)
	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}
	
	@Column(name="USER_IDTY_DOC",length=30)
	public String getUserIdtyDoc() {
		return userIdtyDoc;
	}

	public void setUserIdtyDoc(String userIdtyDoc) {
		this.userIdtyDoc = userIdtyDoc;
	}
	
	@Column(name="USER_OFF_TEL",length=15)
	public String getUserOffTel() {
		return userOffTel;
	}

	public void setUserOffTel(String userOffTel) {
		this.userOffTel = userOffTel;
	}
	
	@Column(name="USER_MOBILE_NO",length=15)
	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
	@Column(name="USER_EMAIL",length=100)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Column(name="USER_ACTV",length=1,nullable=false)
	public String getUserActv() {
		return userActv;
	}

	public void setUserActv(String userActv) {
		this.userActv = userActv;
	}
	
	@Column(name="USER_CRE_ID",length=10)
	public String getUserCreId() {
		return userCreId;
	}

	public void setUserCreId(String userCreId) {
		this.userCreId = userCreId;
	}
	
	@Column(name="USER_CRE_DT")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUserCreDt() {
		return userCreDt;
	}

	public void setUserCreDt(Date userCreDt) {
		this.userCreDt = userCreDt;
	}
	
	@Column(name="USER_UPD_ID",length=10)
	public String getUserUpdId() {
		return userUpdId;
	}

	public void setUserUpdId(String userUpdId) {
		this.userUpdId = userUpdId;
	}
	
	@Column(name="USER_UPD_DT")
	@Temporal(TemporalType.TIMESTAMP)

	public Date getUserUpdDt() {
		return userUpdDt;
	}

	public void setUserUpdDt(Date userUpdDt) {
		this.userUpdDt = userUpdDt;
	}
	
}
