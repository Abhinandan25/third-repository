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
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.User;
import com.sun.scenario.effect.Merge;



@Repository("purchaseBillDetailsDao")
public class PurchageBillDetailsDaoImpl extends AbstractDao<Integer, WeighmentDetails> implements PurchageBillDetailsDao {

	static final Logger logger = LoggerFactory.getLogger(PurchageBillDetailsDaoImpl.class);

	@Override
	public void savePurchaseBillDetails(WeighmentDetails purchaseBillDetails) {
		persist(purchaseBillDetails);
	}
	
	public List<Integer> findBillCount(Integer lotNo){
		
		Criteria crit = createEntityCriteria();
		crit.setProjection( Projections.distinct( Projections.property( "billedBillCount" ) ) );
		
		if(lotNo!=null) {
			crit.add(Restrictions.eq("billedBillLotNo.billLotNo", lotNo));
		}
		
		return (List<Integer>)crit.list();
	}
	
	public void findByLotNoAndId(Integer id) {
				
		String hql = "delete from WeighmentDetails where id = :id";
	    Query query = getSession().createQuery(hql);
	    query.setInteger("id",id);
	    //query.setInteger("lotNo",lotNo);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
		
	}
	
	public void savePurchagebillDetails(WeighmentDetails weighmentDetails) {
		String hql = "INSERT INTO JME_WEIGHMENT_DTL (BILLD_BILL_LOT_NO,BILLD_BILL_COUNT,BILLD_WGT_KGS,BILLD_NO_OF_NETS,BILLD_CRE_ID,BILLD_UPD_ID) VALUES (?,?,?,?,?,?) ";
	    Query query = getSession().createSQLQuery(hql);
	    		
	    		query.setParameter(0,weighmentDetails.getBilledBillLotNo().getBillLotNo());
			    query.setParameter(1,weighmentDetails.getBilledBillCount().intValue());
			    query.setParameter(2,weighmentDetails.getBilledWgtKgs().intValue());
			    query.setParameter(3,weighmentDetails.getBilledNoOfNets());
			    query.setParameter(4,weighmentDetails.getBilledCreId());
			    //query.setString(5,weighmentDetails.getBilledCreId());
			    query.setParameter(5,weighmentDetails.getBilledUpdId());
			    //query.setString(7,weighmentDetails.getBilledUpdDt().toString());
	    
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	}

}
