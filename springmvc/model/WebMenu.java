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
@Table(name="M_WEB_MENU")
public class WebMenu implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer wmMenuId;
	private String wmMenuName;
	private String wmMenuLabel;
	private String wmMenuPMenuId;
	private String wmMenuPrgmId;
	private String wmMenuPrgmDesc; 
	private Integer wmMenuOrder;
	private String wmCreId;
	private Date wmCreDt;
	private String wmUpdId;
	private Date wmUpdDt;
	
	private Set<WgmpPriv> wgmpPriv =new HashSet<WgmpPriv>(0);
	
	public WebMenu() {}
	
	public WebMenu(Integer wmMenuId, String wmMenuName, String wmMenuLabel, String wmMenuPMenuId, String wmMenuPrgmId,
			String wmMenuPrgmDesc, Integer wmMenuOrder, String wmCreId, Date wmCreDt, String wmUpdId, Date wmUpdDt) {
		super();
		this.wmMenuId = wmMenuId;
		this.wmMenuName = wmMenuName;
		this.wmMenuLabel = wmMenuLabel;
		this.wmMenuPMenuId = wmMenuPMenuId;
		this.wmMenuPrgmId = wmMenuPrgmId;
		this.wmMenuPrgmDesc = wmMenuPrgmDesc;
		this.wmMenuOrder = wmMenuOrder;
		this.wmCreId = wmCreId;
		this.wmCreDt = wmCreDt;
		this.wmUpdId = wmUpdId;
		this.wmUpdDt = wmUpdDt;
	}
	
	public WebMenu(Integer wmMenuId, String wmMenuName, String wmMenuLabel, String wmMenuPMenuId, String wmMenuPrgmId,
			String wmMenuPrgmDesc, Integer wmMenuOrder, String wmCreId, Date wmCreDt, String wmUpdId, Date wmUpdDt,
			Set<WgmpPriv> wgmpPriv) {
		super();
		this.wmMenuId = wmMenuId;
		this.wmMenuName = wmMenuName;
		this.wmMenuLabel = wmMenuLabel;
		this.wmMenuPMenuId = wmMenuPMenuId;
		this.wmMenuPrgmId = wmMenuPrgmId;
		this.wmMenuPrgmDesc = wmMenuPrgmDesc;
		this.wmMenuOrder = wmMenuOrder;
		this.wmCreId = wmCreId;
		this.wmCreDt = wmCreDt;
		this.wmUpdId = wmUpdId;
		this.wmUpdDt = wmUpdDt;
		this.wgmpPriv = wgmpPriv;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WM_MENU_ID",unique=true,nullable=false,length=30,insertable = false)
	public Integer getWmMenuId() {
		return wmMenuId;
	}

	public void setWmMenuId(Integer wmMenuId) {
		this.wmMenuId = wmMenuId;
	}
	
	@Column(name="WM_MENU_NAME",length=100,nullable=false)
	public String getWmMenuName() {
		return wmMenuName;
	}

	public void setWmMenuName(String wmMenuName) {
		this.wmMenuName = wmMenuName;
	}
	
	@Column(name="WM_MENU_LABEL",length=100,nullable=false)
	public String getWmMenuLabel() {
		return wmMenuLabel;
	}

	public void setWmMenuLabel(String wmMenuLabel) {
		this.wmMenuLabel = wmMenuLabel;
	}
	
	@Column(name="WM_MENU_PMENU_ID)",length=30)
	public String getWmMenuPMenuId() {
		return wmMenuPMenuId;
	}

	public void setWmMenuPMenuId(String wmMenuPMenuId) {
		this.wmMenuPMenuId = wmMenuPMenuId;
	}
	
	@Column(name="WM_MENU_PRGM_ID)",length=1000)
	public String getWmMenuPrgmId() {
		return wmMenuPrgmId;
	}

	public void setWmMenuPrgmId(String wmMenuPrgmId) {
		this.wmMenuPrgmId = wmMenuPrgmId;
	}
	
	@Column(name="WM_MENU_PRGM_DESC)",length=100)
	public String getWmMenuPrgmDesc() {
		return wmMenuPrgmDesc;
	}

	public void setWmMenuPrgmDesc(String wmMenuPrgmDesc) {
		this.wmMenuPrgmDesc = wmMenuPrgmDesc;
	}
	
	@Column(name="WM_MENU_ORDER)",length=100)
	public Integer getWmMenuOrder() {
		return wmMenuOrder;
	}

	public void setWmMenuOrder(Integer wmMenuOrder) {
		this.wmMenuOrder = wmMenuOrder;
	}

	@Column(name="WM_CRE_ID)",length=10)
	public String getWmCreId() {
		return wmCreId;
	}

	public void setWmCreId(String wmCreId) {
		this.wmCreId = wmCreId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="WM_CRE_DT",nullable=false)
	public Date getWmCreDt() {
		return wmCreDt;
	}

	public void setWmCreDt(Date wmCreDt) {
		this.wmCreDt = wmCreDt;
	}
	
	@Column(name="WM_UPD_ID)",length=10)
	public String getWmUpdId() {
		return wmUpdId;
	}

	public void setWmUpdId(String wmUpdId) {
		this.wmUpdId = wmUpdId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="WM_UPD_DT",nullable=false)
	public Date getWmUpdDt() {
		return wmUpdDt;
	}

	public void setWmUpdDt(Date wmUpdDt) {
		this.wmUpdDt = wmUpdDt;
	}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="wgmpWmMenuId")
	public Set<WgmpPriv> getWgmpPriv() {
		return wgmpPriv;
	}

	public void setWgmpPriv(Set<WgmpPriv> wgmpPriv) {
		this.wgmpPriv = wgmpPriv;
	}
	
	
	
	
}
