package com.seed.dao;

import java.sql.Connection;
import java.util.List;

import com.seed.entity.User;

public class UserDao {
	
	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public User getUsername(String username) {
		return null;
	}
	
	public List<User> getAllUser(){
		return null;
	}
	
	public List<String> getFriends(String username){
		return null;
	}
	
	public List<String> getFriends(int userId){
		return null;
	}
	
	public void addUser(User user) {
		//add users
	}
	
	public void deleteUser(int userId) {
		
	}
	
	public void updateUser(User user) {
		
	}
	
	public void addFriend(String username, String friendName) {
		
	}
	
	public void addFriend(int userId, String friendName) {
		
	}

}
