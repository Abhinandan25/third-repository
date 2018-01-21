package com.jme.springmvc.dao;

import java.util.List;

import com.jme.springmvc.model.PurchagePlant;



public interface PurchageBillPlantDao {
	
	List<PurchagePlant> findAllPlantDetails();
	public PurchagePlant findByPlantId(Integer id);
	public void updatePlantsWithCounter(PurchagePlant purchagePlant);
	

}

