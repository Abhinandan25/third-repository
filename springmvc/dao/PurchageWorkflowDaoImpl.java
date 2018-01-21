package com.jme.springmvc.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("purchaseWorkflowDao")
public class PurchageWorkflowDaoImpl extends AbstractDao<Integer, PurchageWorkflow> implements PurchageWorkflowDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageWorkflowDaoImpl.class);


	@Override
	public void savePurchaseWorkflow(PurchageWorkflow purchageWorkflow) {
		save(purchageWorkflow);				
	}
	
	public PurchageWorkflow findById(Integer lotNo) {
		
		Criteria crit = createEntityCriteria();		
		if(lotNo!=null) {
			crit.add(Restrictions.eq("workflowId", lotNo));
		}
		return (PurchageWorkflow) crit.uniqueResult();
	}
	
	@Override
	public void updatePurchaseBill(PurchageWorkflow purchaseBill) {
		update(purchaseBill);
	}
	
}
