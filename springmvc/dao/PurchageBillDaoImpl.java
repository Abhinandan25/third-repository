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



@Repository("purchaseBillDao")
public class PurchageBillDaoImpl extends AbstractDao<Integer, Weighment> implements PurchageBillDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillDaoImpl.class);
	

	@Override
	public void savePurchaseBill(Weighment purchaseBill) {

		save(purchaseBill);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Weighment> findAllWeighment(){
		Criteria crit = createEntityCriteria();
		//crit.addOrder(Order.asc("type"));
		return (List<Weighment>)crit.list();
	}
	
	
	public Weighment findByLotId(int id) {
		Weighment purchaseBill = getByKey(id);
		if(purchaseBill!=null){
			Hibernate.initialize(purchaseBill.getPurchageBillDetails());
		}
		return purchaseBill;
	}
	
	public List<Weighment> findByType(String chequeName,String farmer,String place,Integer lotNo,String agentName,String date) {
		
		Date journeyDate=null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
		try {
			if(date!=null && !date.isEmpty())
			{
			 journeyDate = df.parse(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Criteria crit = createEntityCriteria();
		if(!chequeName.equals("")) {
		crit.add(Restrictions.eq("billChequeName", chequeName));
		}
		if(!farmer.equals("")) {
		crit.add(Restrictions.eq("billFormerName", farmer));
		}
		if(!place.equals("")) {
		crit.add(Restrictions.eq("billPlace", place));
		}
		if(lotNo!=null) {
		crit.add(Restrictions.eq("billLotNo", lotNo));
		}
		if(!agentName.equals("")) {
		crit.add(Restrictions.eq("billAgentName", agentName));
		}
		if(!date.equals("")) {
		crit.add(Restrictions.eq("billDate", journeyDate));
		}
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return (List<Weighment>) crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Plant> findAllPlant(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("plantName"));
		return (List<Plant>)crit.list();
	}

	@Override
	public void updatePurchaseBill(Weighment purchaseBill) {
		update(purchaseBill);
	}
	
	@Override
	public void mergePurchaseBill(Weighment purchaseBill) {
		merge(purchaseBill);
	}
	
	@SuppressWarnings("unchecked")
	public List<Weighment> findAllWeighmentWithStatus(){
		Criteria crit = createEntityCriteria();
		crit.setFetchMode("purchageWorkflow", FetchMode.JOIN);
		crit.createAlias("client", "c");
		crit.createAlias("c.server", "s");
		crit.add(Restrictions.eq("purchageWorkflow.status", "WEIGHMENT_APPROVED"));
		return (List<Weighment>)crit.list();
	}
	
	}
