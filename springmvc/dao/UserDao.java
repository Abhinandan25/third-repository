package com.jme.springmvc.dao;

import java.util.List;

import com.jme.springmvc.model.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();
	
	Boolean findCredentails(String sso,String password);
	
	public User findUserDetails(String sso,String password);
	
	public User findUserObjectByUserNameAndCheck(String sso,String password);
}

