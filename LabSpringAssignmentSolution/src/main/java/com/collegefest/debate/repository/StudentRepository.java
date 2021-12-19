package com.collegefest.debate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegefest.debate.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameContainsAndDepartmentContainsAndCountryContainsAllIgnoreCase(String name, String department,
			String country);

}
