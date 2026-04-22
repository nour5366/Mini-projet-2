package com.nour.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nour.series.entites.Role;
import com.nour.series.entites.User;
import com.nour.series.service.SeriesService;
import com.nour.series.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SeriesApplication implements CommandLineRunner {

	@Autowired
	SeriesService seriesService;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

	@Autowired
	org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

	@Autowired
	private com.nour.series.repos.PaysRepository paysRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));

		if (paysRepository.findAll().isEmpty()) {
			paysRepository.save(new com.nour.series.entites.Pays(null, "USA", "Amérique", null));
			paysRepository.save(new com.nour.series.entites.Pays(null, "France", "Europe", null));
			paysRepository.save(new com.nour.series.entites.Pays(null, "Espagne", "Europe", null));
		}
	}

	@PostConstruct
	void init_users() {
		/*
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));

		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "nour", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));

		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("nour", "USER");
		userService.addRoleToUser("nour", "AGENT");
		userService.addRoleToUser("user1", "USER");
		*/
	}
}
