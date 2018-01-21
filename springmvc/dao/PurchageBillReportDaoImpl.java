package com.jme.springmvc.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("purchaseBillReportDao")
public class PurchageBillReportDaoImpl extends AbstractDao<Integer, PurchageBillReport> implements PurchageBillReportDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillReportDaoImpl.class);
	

	@Override
	public void savePurchaseBillReport(PurchageBillReport purchageBillReport) {

		save(purchageBillReport);		
	}
	
public PurchageBillReport findByPurchageLotId(Integer id) {
		
		Criteria crit = createEntityCriteria();		
		if(id!=null) {
			crit.add(Restrictions.eq("billReportLotNo.billLotNo", id));
		}
		PurchageBillReport purchaseBillReport= (PurchageBillReport) crit.uniqueResult();	
		
		if(purchaseBillReport!=null){
			Hibernate.initialize(purchaseBillReport.getPurchagePayAmount());
			Hibernate.initialize(purchaseBillReport.getPurchageCompCountDetail());
			Hibernate.initialize(purchaseBillReport.getPurchageBillTubs());
			Hibernate.initialize(purchaseBillReport.getBillReportLotNo());
		}
		return purchaseBillReport;
	}

public void updatePurchageBillReport(PurchageBillReport purchageBillReport)
{
	//getSession().evict(purchageBillReport);
	//getSession().evict(purchageBillReport.getBillReportLotNo());
	//getSession().evict(purchageBillReport.get);
	save(purchageBillReport);
	
}
}
