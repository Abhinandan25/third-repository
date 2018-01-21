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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="M_USER_GROUP")
public class UserGroup implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer grpId;
	private String grpName;
	private String grpActv;
	private String grpCreId;
	private Date grpCreDt;
	private String grpUpdId; 
	private Date grpUpdDt;
	
	private Set<Users> users =new HashSet<Users>(0);
	
	public UserGroup() {}
	
	public UserGroup(Integer grpId, String grpName, String grpActv, String grpCreId, Date grpCreDt, String grpUpdId,
			Date grpUpdDt) {
		super();
		this.grpId = grpId;
		this.grpName = grpName;
		this.grpActv = grpActv;
		this.grpCreId = grpCreId;
		this.grpCreDt = grpCreDt;
		this.grpUpdId = grpUpdId;
		this.grpUpdDt = grpUpdDt;
	}
	
	public UserGroup(Integer grpId, String grpName, String grpActv, String grpCreId, Date grpCreDt, String grpUpdId,
			Date grpUpdDt, Set<Users> users) {
		super();
		this.grpId = grpId;
		this.grpName = grpName;
		this.grpActv = grpActv;
		this.grpCreId = grpCreId;
		this.grpCreDt = grpCreDt;
		this.grpUpdId = grpUpdId;
		this.grpUpdDt = grpUpdDt;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GRP_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getGrpId() {
		return grpId;
	}
	public void setGrpId(Integer grpId) {
		this.grpId = grpId;
	}
	
	@Column(name="GRP_NAME",nullable=false)
	public String getGrpName() {
		return grpName;
	}
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}
	
	@Column(name="GRP_ACTV",length=1,nullable=false)
	public String getGrpActv() {
		return grpActv;
	}
	public void setGrpActv(String grpActv) {
		this.grpActv = grpActv;
	}
	
	@Column(name="GRP_CRE_ID")
	public String getGrpCreId() {
		return grpCreId;
	}
	public void setGrpCreId(String grpCreId) {
		this.grpCreId = grpCreId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GRP_CRE_DT",nullable=false)
	public Date getGrpCreDt() {
		return grpCreDt;
	}
	public void setGrpCreDt(Date grpCreDt) {
		this.grpCreDt = grpCreDt;
	}
	
	@Column(name="GRP_UPD_ID")
	public String getGrpUpdId() {
		return grpUpdId;
	}
	public void setGrpUpdId(String grpUpdId) {
		this.grpUpdId = grpUpdId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GRP_UPD_DT",nullable=false)
	public Date getGrpUpdDt() {
		return grpUpdDt;
	}
	public void setGrpUpdDt(Date grpUpdDt) {
		this.grpUpdDt = grpUpdDt;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="userGrpId")
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
}
