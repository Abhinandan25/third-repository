package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.vo.WeighmentVo;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.User;


public interface PurchageBillDao {
	
	void savePurchaseBill(Weighment purchaseBill);
	
	void updatePurchaseBill(Weighment purchaseBill);
	
	List<Weighment> findAllWeighment();
	
	public Weighment findByLotId(int id);
	
	public List<Weighment> findByType(String chequeName,String farmer,String place,Integer lotNo,String agentName,String date);

	public List<Plant> findAllPlant();
	
	public List<Weighment> findAllWeighmentWithStatus();
	
	public void mergePurchaseBill(Weighment purchaseBill);
}

