package com.jme.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jme.springmvc.dao.PurchageBillDao;
import com.jme.springmvc.dao.UserProfileDao;
import com.jme.springmvc.model.Plant;
import com.jme.springmvc.model.UserProfile;
import com.jme.springmvc.model.Weighment;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	
	@Autowired
	PurchageBillDao purchaseDao;
	
	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
	
	public List<Weighment> findAllWeighment() {
		return purchaseDao.findAllWeighment();
	}
	
	public List<Plant> findAllPlant() {
		return purchaseDao.findAllPlant();
	}
}
