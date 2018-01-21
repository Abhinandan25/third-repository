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
import com.jme.springmvc.model.PurchagePlant;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("purchaseBillPlantDao")
public class PurchageBillPlantDaoImpl extends AbstractDao<Integer, PurchagePlant> implements PurchageBillPlantDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillPlantDaoImpl.class);
	

	@SuppressWarnings("unchecked")
	public List<PurchagePlant> findAllPlantDetails(){
		Criteria crit = createEntityCriteria();
		//crit.addOrder(Order.asc("type"));
		return (List<PurchagePlant>)crit.list();
	}
	
public PurchagePlant findByPlantId(Integer id) {
		
		Criteria crit = createEntityCriteria();		
		if(id!=null) {
			crit.add(Restrictions.eq("billPlantId", id));
		}
		return (PurchagePlant) crit.uniqueResult();		
	}
public void updatePlantsWithCounter(PurchagePlant purchagePlant)
{
	update(purchagePlant);
}

}
