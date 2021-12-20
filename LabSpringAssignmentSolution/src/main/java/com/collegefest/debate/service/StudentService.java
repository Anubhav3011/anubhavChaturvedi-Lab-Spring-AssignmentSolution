package com.collegefest.debate.service;

import java.util.List;

import com.collegefest.debate.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);

	public List<Student> findByNameContainsAndDepartmentContainsAndCountryContainsAllIgnoreCase(String name, String department, String country);

}