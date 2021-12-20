package com.collegefest.debate;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.collegefest.debate.entity.Role;
import com.collegefest.debate.entity.Student;
import com.collegefest.debate.entity.User;
import com.collegefest.debate.service.RoleService;
import com.collegefest.debate.service.StudentService;
import com.collegefest.debate.service.UserService;

@SpringBootApplication(scanBasePackages = "com.collegefest.debate")
public class LabSpringAssignmentSolutionApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LabSpringAssignmentSolutionApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LabSpringAssignmentSolutionApplication.class, args);
	}

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		// Adding 2 roles - ADMIN, USER
		roleService.save(Role.builder().name("ADMIN").build());
		roleService.save(Role.builder().name("USER").build());

		// Adding 2 users - admin, user having password & role same as their username
		userService.save(User.builder().username("admin").password(passwordEncoder().encode("admin"))
				.roles(new ArrayList<Role>(Arrays.asList(roleService.getRoleByName("ADMIN")))).build());
		userService.save(User.builder().username("user").password(passwordEncoder().encode("user"))
				.roles(new ArrayList<Role>(Arrays.asList(roleService.getRoleByName("USER")))).build());

		// Adding 4 records as mentioned in the problem statement
		studentService.save(Student.builder().name("Suresh").department("B.Tech").country("India").build());
		studentService.save(Student.builder().name("Muri").department("B.Arch").country("India").build());
		studentService.save(Student.builder().name("Daniel").department("B.Tech").country("New Zealand").build());
		studentService.save(Student.builder().name("Tanya").department("B.Com").country("USA").build());

	}

}
