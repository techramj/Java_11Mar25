package com.seed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seed.entity.User;

public class UserDao {
	
	private Connection connection;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public User getUserDetail(String username) throws SQLException {
		String sql ="select * from users where username = ?";
		try(PreparedStatement ps  =  connection.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return getUser(rs);
			}
		}
		return null;
	}
	
	public List<User> getAllUser() throws SQLException{
		List<User> users = new ArrayList<>();
;		String sql ="select * from users where username = ?";
		try(PreparedStatement ps  =  connection.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 User user = getUser(rs);
				 users.add(user);
			}
		}
		return users;
	}
	
	public List<String> getFriends(String username) throws SQLException{
		String sql = "select f.name from friends f join users u on f.user_id = u.user_id where u.username = ?";
		List<String> friends = new ArrayList<>();
		try(PreparedStatement ps  =  connection.prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 friends.add(rs.getString(1));
			}
		}
		
		return friends;
	}
	
	public List<String> getFriends(int userId) throws SQLException{
		String sql = "select name from friends where user_id = ? ";
		
		List<String> friends = new ArrayList<>();
		try(PreparedStatement ps  =  connection.prepareStatement(sql)){
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 friends.add(rs.getString(1));
			}
		}
		
		return friends;
	}
	
	public void addUser(User user) throws SQLException{
		//add users
	}
	
	public void deleteUser(int userId) throws SQLException {
		
	}
	
	public void updateUser(User user) throws SQLException {
		
	}
	
	public void addFriend(String username, String friendName) {
		
	}
	
	public void addFriend(int userId, String friendName) {
		
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setFirstName(rs.getString(4));
		user.setLastName(rs.getString(5));
		return user;
	}

}
