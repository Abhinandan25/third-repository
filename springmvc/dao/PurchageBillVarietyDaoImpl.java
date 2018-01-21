package com.jme.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.PurchageShrimpVariety;





@Repository("purchaseBillVarietyDao")
public class PurchageBillVarietyDaoImpl extends AbstractDao<Integer, PurchageShrimpVariety> implements PurchageBillVarietyDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillVarietyDaoImpl.class);

	@Override
	public List<PurchageShrimpVariety> findAllPlantVarietyDetails() {
		Criteria crit = createEntityCriteria();
		return (List<PurchageShrimpVariety>)crit.list();
	}

	@Override
	public PurchageShrimpVariety findByVarietyId(Integer id) {
		Criteria crit = createEntityCriteria();		
		if(id!=null) {
			crit.add(Restrictions.eq("billVarietyId", id));
		}
		return (PurchageShrimpVariety) crit.uniqueResult();	
	}

}
