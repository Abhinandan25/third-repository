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
import com.jme.springmvc.model.Employee;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageBillReport;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.TabSync;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("tabsyncDao")
public class TabSyncDaoImpl extends AbstractDao<Integer, TabSync> implements TabSyncDao {

	static final Logger logger = LoggerFactory.getLogger(TabSyncDaoImpl.class);

	@Override
	public void saveTabSync(TabSync tabSync) {
		
		Criteria crit = createEntityCriteria();		
		if(tabSync.getTabId()!=null) {
			crit.add(Restrictions.eq("tabId", tabSync.getTabId()));
		}
		TabSync tabSyncData= (TabSync) crit.uniqueResult();	
		
		if(tabSyncData==null) {
			save(tabSync);
		}else {
			tabSyncData.setSyncTime(tabSync.getSyncTime());
			update(tabSyncData);
		}
	}
	
	public TabSync findByTabId(String tabId) {
		Criteria crit = createEntityCriteria();		
		if(tabId!=null) {
			crit.add(Restrictions.eq("tabId", tabId));
		}
		TabSync tabSyncData= (TabSync) crit.uniqueResult();	
		return tabSyncData;
	}
}
