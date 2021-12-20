package com.collegefest.debate.service;

import java.util.List;

import com.collegefest.debate.entity.Role;

public interface RoleService {

	public List<Role> findAll();

	public Role findById(int id);

	public void save(Role role);

	public void deleteById(int id);

	public Role getRoleByName(String name);

}
