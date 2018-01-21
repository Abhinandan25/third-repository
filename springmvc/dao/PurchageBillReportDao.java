package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.User;


public interface PurchageBillReportDao {
	
	void savePurchaseBillReport(PurchageBillReport purchageBillReport);
	public PurchageBillReport findByPurchageLotId(Integer id);
	void updatePurchageBillReport(PurchageBillReport purchageBillReport);
}

