package com.jme.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="M_WGMP_PRIV")
public class WgmpPriv implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer wgmpGrpId;
	private WebMenu wgmpWmMenuId;
	private String wgmpActv;
	private String wgmpCreId;
	private Date wgmpCreDt;
	private String wgmpUpdId;
	private Date wgmpUpdDt;
	
	public WgmpPriv() {}
	
	public WgmpPriv(Integer wgmpGrpId, WebMenu wgmpWmMenuId, String wgmpActv, String wgmpCreId, Date wgmpCreDt,
			String wgmpUpdId, Date wgmpUpdDt) {
		super();
		this.wgmpGrpId = wgmpGrpId;
		this.wgmpWmMenuId = wgmpWmMenuId;
		this.wgmpActv = wgmpActv;
		this.wgmpCreId = wgmpCreId;
		this.wgmpCreDt = wgmpCreDt;
		this.wgmpUpdId = wgmpUpdId;
		this.wgmpUpdDt = wgmpUpdDt;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WGMP_GRP_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getWgmpGrpId() {
		return wgmpGrpId;
	}

	public void setWgmpGrpId(Integer wgmpGrpId) {
		this.wgmpGrpId = wgmpGrpId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="WGMP_WM_MENU_ID",nullable=false)
	public WebMenu getWgmpWmMenuId() {
		return wgmpWmMenuId;
	}

	public void setWgmpWmMenuId(WebMenu wgmpWmMenuId) {
		this.wgmpWmMenuId = wgmpWmMenuId;
	}
	
	@Column(name="WGMP_ACTV",length=1,nullable=false)
	public String getWgmpActv() {
		return wgmpActv;
	}

	public void setWgmpActv(String wgmpActv) {
		this.wgmpActv = wgmpActv;
	}

	@Column(name="WGMP_CRE_ID",length=10)
	public String getWgmpCreId() {
		return wgmpCreId;
	}

	public void setWgmpCreId(String wgmpCreId) {
		this.wgmpCreId = wgmpCreId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="WGMP_CRE_DT")
	public Date getWgmpCreDt() {
		return wgmpCreDt;
	}

	public void setWgmpCreDt(Date wgmpCreDt) {
		this.wgmpCreDt = wgmpCreDt;
	}
	
	@Column(name="WGMP_UPD_ID",length=10)
	public String getWgmpUpdId() {
		return wgmpUpdId;
	}

	public void setWgmpUpdId(String wgmpUpdId) {
		this.wgmpUpdId = wgmpUpdId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="WGMP_UPD_DT")
	public Date getWgmpUpdDt() {
		return wgmpUpdDt;
	}

	public void setWgmpUpdDt(Date wgmpUpdDt) {
		this.wgmpUpdDt = wgmpUpdDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
