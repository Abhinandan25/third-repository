package com.jme.springmvc.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentTemp;
import com.jme.springmvc.model.WeighmentVarietyDetails;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.User;
import com.sun.scenario.effect.Merge;



@Repository("weighmentVarietyDetailsDao")
public class WeighmentVarietyDetailsDaoImpl extends AbstractDao<Integer, WeighmentVarietyDetails> implements WeighmentVarietyDetailsDao {

	static final Logger logger = LoggerFactory.getLogger(WeighmentVarietyDetailsDaoImpl.class);

	
		
	public void saveWeighmentVarietyDetails(WeighmentVarietyDetails weighmentVarietyDetails) {
		String hql = "INSERT INTO jme_weighment_variety_type (BILLD_BILL_VARIETY_LOT_NO,BILLD_VARIETY_NAME,BILLD_VARIETY_WGT_KGS,BILLD_BILL__VARIETY_COUNT,BILLD_CRE_ID,BILLD_CRE_DT,BILLD_UPD_ID,BILLD_UPD_DT) VALUES (?,?,?,?,?,?,?,?) ";
	    Query query = getSession().createSQLQuery(hql);
	    		
	    		query.setParameter(0,weighmentVarietyDetails.getBilledBillLotNo().getBillLotNo());
			    query.setParameter(1,weighmentVarietyDetails.getBilledVarietyName());
			    query.setParameter(2,weighmentVarietyDetails.getBilledVarietyWgtKgs());
			    query.setParameter(3,weighmentVarietyDetails.getBilledBillVarietyCount());
			    query.setParameter(4,weighmentVarietyDetails.getBilledCreId());
			    //query.setString(5,weighmentDetails.getBilledCreId());
			    query.setParameter(5,weighmentVarietyDetails.getBilledCreDt());
			    query.setParameter(6,weighmentVarietyDetails.getBilledUpdId());
			    query.setParameter(7,weighmentVarietyDetails.getBilledUpdDt());
			    //query.setString(7,weighmentDetails.getBilledUpdDt().toString());
	    
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	}

	@Override
	public void deleteWeighmentVariety(Integer id) {
		String hql = "delete from WeighmentVarietyDetails where id = :id";
	    Query query = getSession().createQuery(hql);
	    query.setInteger("id",id);
	    //query.setInteger("lotNo",lotNo);
	    int rowCount = query.executeUpdate();
	    logger.info("Rows affected: ",rowCount);
		
	}

}
