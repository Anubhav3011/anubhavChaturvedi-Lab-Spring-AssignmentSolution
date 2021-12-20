package com.collegefest.debate.service;

import java.util.List;

import com.collegefest.debate.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findById(int id);

	public void save(User role);

	public void deleteById(int id);

	public User getUserByUsername(String username);

}
