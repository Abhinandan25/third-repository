package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.User;


public interface TabSyncDao {
	
	void saveTabSync(TabSync tabSync);
	
	public TabSync findByTabId(String tabId) ;
	
}

