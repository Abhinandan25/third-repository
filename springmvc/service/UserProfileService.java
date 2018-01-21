package com.jme.springmvc.service;

import java.util.List;

import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.UserProfile;
import com.jme.springmvc.model.Weighment;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
	List<Weighment> findAllWeighment();
	
    List<Plant> findAllPlant();
	
}
