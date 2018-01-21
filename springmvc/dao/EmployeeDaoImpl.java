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
import com.jme.springmvc.model.PurchageWorkflow;
import com.jme.springmvc.model.User;
import com.jme.springmvc.model.UserProfile;
import com.sun.scenario.effect.Merge;



@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Override
	public void saveEmployee(Employee employee) {
		save(employee);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findEmployee(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("empId"));
		return (List<Employee>)crit.list();
	}
}
