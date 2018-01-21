package com.jme.springmvc.dao;

import java.util.List;

import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.User;


public interface PurchageBillDetailsDao {
	
	void savePurchaseBillDetails(WeighmentDetails purchaseBillDetails);
	
	public List<Integer> findBillCount(Integer lotNo);
	
	public void findByLotNoAndId(Integer id);
	
	public void savePurchagebillDetails(WeighmentDetails weighmentDetails);


}

