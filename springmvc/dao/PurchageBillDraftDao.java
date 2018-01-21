package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.vo.WeighmentVo;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.User;


public interface PurchageBillDraftDao {
	
	public void savePurchaseBillDraft(WeighmentTemp purchaseBill);
	
	public void deleteWeighmentDraftData(WeighmentTemp weighmentTemp);

}

