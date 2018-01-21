package com.jme.springmvc.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jme.springmvc.model.InvoiceReport;
import com.jme.springmvc.model.Weighment;

@Repository("invoiceReportDao")
public class InvoiceReportDaoImpl extends AbstractDao<Integer, InvoiceReport> implements InvoiceReportDao {

	static final Logger logger = LoggerFactory.getLogger(InvoiceReportDaoImpl.class);

	@Override
	public void saveInvoiceReport(InvoiceReport invoiceReport) {

		save(invoiceReport);
	}
	
public List<InvoiceReport> findByType(String voucherNumber,String farmer,Integer lotNo,String invoiceFromDate,String invoiceToDate) {
		
		Date invoiceDate=null;
		Date invToDate=null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
		try {
			if(invoiceFromDate!=null && !invoiceFromDate.isEmpty())
			{
			 invoiceDate = df.parse(invoiceFromDate);
			}
			
			if(invoiceToDate!=null && !invoiceToDate.isEmpty())
			{
				invToDate = df.parse(invoiceToDate);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Criteria crit = createEntityCriteria();
		if(!voucherNumber.equals("")) {
		crit.add(Restrictions.eq("voucherNumber", voucherNumber));
		}
		if(farmer!=null && !farmer.equals("")) {
		crit.add(Restrictions.eq("formerName", farmer));
		}
		if(lotNo!=null) {
		crit.add(Restrictions.eq("invoiceLotNo", lotNo));
		}
		if(invoiceFromDate!=null && !invoiceFromDate.equals("") && !invoiceToDate.equals("")) {
			crit.add(Restrictions.ge("createDate", invoiceDate));
			crit.add(Restrictions.lt("createDate", invToDate));
		}
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return (List<InvoiceReport>) crit.list();
	}
	
}
