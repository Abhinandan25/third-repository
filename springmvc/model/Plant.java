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
@Table(name="M_PLANT")
public class Plant implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer PlantId;
	private String plantName;
	private String plantAddress1;
	private String plantAddress2;
	private String plantActv;
	private String plantCreId; 
	private Date plantCreDt;
	private String plantUpdId;
	private Date plantUpdDt;
	
	public Plant() {}
			
	public Plant(Integer plantId, String plantName, String plantAddress1, String plantAddress2, String plantActv,
			String plantCreId, Date plantCreDt, String plantUpdId, Date plantUpdDt) {
		super();
		PlantId = plantId;
		this.plantName = plantName;
		this.plantAddress1 = plantAddress1;
		this.plantAddress2 = plantAddress2;
		this.plantActv = plantActv;
		this.plantCreId = plantCreId;
		this.plantCreDt = plantCreDt;
		this.plantUpdId = plantUpdId;
		this.plantUpdDt = plantUpdDt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLANT_ID",unique=true,nullable=false,length=20,insertable = false)
	public Integer getPlantId() {
		return PlantId;
	}

	public void setPlantId(Integer plantId) {
		PlantId = plantId;
	}

	@Column(name="PLANT_NAME",nullable=false)
	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	@Column(name="PLANT_ADDR1")
	public String getPlantAddress1() {
		return plantAddress1;
	}

	public void setPlantAddress1(String plantAddress1) {
		this.plantAddress1 = plantAddress1;
	}

	@Column(name="PLANT_ADDR2")
	public String getPlantAddress2() {
		return plantAddress2;
	}

	public void setPlantAddress2(String plantAddress2) {
		this.plantAddress2 = plantAddress2;
	}
	
	@Column(name="PLANT_ACTV",nullable=false)
	public String getPlantActv() {
		return plantActv;
	}

	public void setPlantActv(String plantActv) {
		this.plantActv = plantActv;
	}

	@Column(name="PLANT_CRE_ID")
	public String getPlantCreId() {
		return plantCreId;
	}

	public void setPlantCreId(String plantCreId) {
		this.plantCreId = plantCreId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLANT_CRE_DT")
	public Date getPlantCreDt() {
		return plantCreDt;
	}

	public void setPlantCreDt(Date plantCreDt) {
		this.plantCreDt = plantCreDt;
	}

	@Column(name="PLANT_UPD_ID")
	public String getPlantUpdId() {
		return plantUpdId;
	}

	public void setPlantUpdId(String plantUpdId) {
		this.plantUpdId = plantUpdId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PLANT_UPD_DT")
	public Date getPlantUpdDt() {
		return plantUpdDt;
	}

	public void setPlantUpdDt(Date plantUpdDt) {
		this.plantUpdDt = plantUpdDt;
	}
	
}
