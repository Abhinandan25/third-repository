package com.jme.springmvc.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("purchaseBillDraftDao")
public class PurchageBillDraftDaoImpl extends AbstractDao<Integer, WeighmentTemp> implements PurchageBillDraftDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillDraftDaoImpl.class);
	
	@Override
	public void savePurchaseBillDraft(WeighmentTemp purchaseBill) {

		save(purchaseBill);		
	}
	
	public void deleteWeighmentDraftData(WeighmentTemp weighmentTemp) {
		
		WeighmentTemp purchaseBill = getByKey(weighmentTemp.getBillLotNo().intValue());
			if(purchaseBill!=null){
				Hibernate.initialize(purchaseBill.getPurchageBillDetails());
			
			}
		if(purchaseBill!=null) {
		 delete(purchaseBill);
		}
	}
	
}
