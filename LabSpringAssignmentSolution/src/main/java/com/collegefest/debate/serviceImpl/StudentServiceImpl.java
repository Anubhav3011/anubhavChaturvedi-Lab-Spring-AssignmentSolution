package com.collegefest.debate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegefest.debate.entity.Student;
import com.collegefest.debate.repository.StudentRepository;
import com.collegefest.debate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> searchBy(String name, String department, String country) {
		return studentRepository.findByNameContainsAndDepartmentContainsAndCountryContainsAllIgnoreCase(name,
				department, country);
	}

}
