package com.collegefest.debate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegefest.debate.entity.Role;
import com.collegefest.debate.repository.RoleRepository;
import com.collegefest.debate.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void save(Role student) {
		roleRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role getRoleByName(String name) {
		return roleRepository.getRoleByName(name);
	}

}
