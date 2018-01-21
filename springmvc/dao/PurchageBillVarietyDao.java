package com.jme.springmvc.dao;

import java.util.List;

import com.jme.springmvc.model.PurchageShrimpVariety;


public interface PurchageBillVarietyDao {
	
	List<PurchageShrimpVariety> findAllPlantVarietyDetails();
	
	public PurchageShrimpVariety findByVarietyId(Integer id);

}

