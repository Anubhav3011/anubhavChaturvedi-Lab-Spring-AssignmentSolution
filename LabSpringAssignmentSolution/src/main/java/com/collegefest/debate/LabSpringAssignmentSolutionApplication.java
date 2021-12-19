package com.collegefest.debate;

import java.util.ArrayList;
import java.util.Arrays;

//import java.util.ArrayList;
//import java.util.Arrays;

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
import com.collegefest.debate.repository.RoleRepository;
import com.collegefest.debate.repository.StudentRepository;
import com.collegefest.debate.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.collegefest.debate")
public class LabSpringAssignmentSolutionApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

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
		roleRepository.save(Role.builder().name("ADMIN").build());
		roleRepository.save(Role.builder().name("USER").build());

		// Adding 2 users - admin, user having password & role same as their username
		userRepository.save(User.builder().username("admin").password(passwordEncoder().encode("admin"))
				.roles(new ArrayList<Role>(Arrays.asList(roleRepository.getRoleByName("ADMIN")))).build());
		userRepository.save(User.builder().username("user").password(passwordEncoder().encode("user"))
				.roles(new ArrayList<Role>(Arrays.asList(roleRepository.getRoleByName("USER")))).build());

		// Adding 4 records as mentioned in the problem statement
		studentRepository.save(Student.builder().name("Suresh").department("B.Tech").country("India").build());
		studentRepository.save(Student.builder().name("Muri").department("B.Arch").country("India").build());
		studentRepository.save(Student.builder().name("Daniel").department("B.Tech").country("New Zealand").build());
		studentRepository.save(Student.builder().name("Tanya").department("B.Com").country("USA").build());

	}

}
