package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.User;


public interface PurchageWorkflowDao {
	
	void savePurchaseWorkflow(PurchageWorkflow purchageWorkflow);
	
	public PurchageWorkflow findById(Integer id);
	
	public void updatePurchaseBill(PurchageWorkflow purchaseBill);
	
	
	

}

