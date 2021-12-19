package com.collegefest.debate.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.collegefest.debate.entity.Student;
import com.collegefest.debate.repository.StudentRepository;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("Students", students);
		return "list-students";
	}

	@RequestMapping("/show-add-form")
	public String showAddForm(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "edit-student";
	}

	@RequestMapping("/show-update-form")
	public String showUpdateForm(@RequestParam("studentId") int id, Model model) {
		Student student = studentRepository.findById(id).get();
		model.addAttribute("Student", student);
		return "edit-student";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student;
		if (id != 0) {
			student = studentRepository.findById(id).get();
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else {
			student = new Student();
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		studentRepository.save(student);
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentRepository.deleteById(theId);
		return "redirect:/students/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("department") String department,
			@RequestParam("country") String country, Model model) {
		if (name.trim().isEmpty() && department.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/students/list";
		} else {
			List<Student> student = studentRepository
					.findByNameContainsAndDepartmentContainsAndCountryContainsAllIgnoreCase(name, department, country);
			model.addAttribute("Students", student);
			model.addAttribute("Name", name);
			model.addAttribute("Department", department);
			model.addAttribute("Country", country);
			return "list-students";
		}
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}

}
