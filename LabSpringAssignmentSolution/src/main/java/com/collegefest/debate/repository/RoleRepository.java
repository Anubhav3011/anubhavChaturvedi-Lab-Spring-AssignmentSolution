package com.collegefest.debate.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.collegefest.debate.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "SELECT * FROM Roles r WHERE r.role_name = :name", nativeQuery = true)
	public Role getRoleByName(String name);

}
