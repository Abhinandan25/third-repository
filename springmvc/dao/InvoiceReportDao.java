package com.jme.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.InvoiceReport;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.User;


public interface InvoiceReportDao {
	
	void saveInvoiceReport(InvoiceReport invoiceReport);
	
	public List<InvoiceReport> findByType(String voucherNumber,String farmer,Integer lotNo,String invoiceFromDate,String invoiceToDate);
}

