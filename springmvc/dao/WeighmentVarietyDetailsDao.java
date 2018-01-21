package com.jme.springmvc.dao;

import java.util.List;

import com.jme.springmvc.model.WeighmentDetails;
import com.jme.springmvc.model.WeighmentVarietyDetails;
import com.jme.springmvc.model.Weighment;
import com.jme.springmvc.model.User;


public interface WeighmentVarietyDetailsDao {

	void deleteWeighmentVariety(Integer id);

	void saveWeighmentVarietyDetails(WeighmentVarietyDetails weighmentVarietyDetails);
	
	

}

