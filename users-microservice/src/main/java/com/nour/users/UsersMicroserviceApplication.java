package com.nour.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import com.nour.users.service.UserService;
import com.nour.users.entities.Role;
import com.nour.users.entities.User;

@SpringBootApplication
public class UsersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}

	@Autowired
	UserService userService;

	@PostConstruct
	void init_users() {
		//ajouter les rôles
		if (userService.findRoleByName("ADMIN") == null)
			userService.addRole(new Role(null, "ADMIN"));
		if (userService.findRoleByName("USER") == null)
			userService.addRole(new Role(null, "USER"));
		if (userService.findRoleByName("AGENT") == null)
			userService.addRole(new Role(null, "AGENT"));

		//ajouter les users
		if (userService.findUserByUsername("admin") == null)
			userService.saveUser(new User(null, "admin", "123", true, new java.util.ArrayList<>()));
		if (userService.findUserByUsername("nour") == null)
			userService.saveUser(new User(null, "nour", "123", true, new java.util.ArrayList<>()));
		if (userService.findUserByUsername("yassine") == null)
			userService.saveUser(new User(null, "yassine", "123", true, new java.util.ArrayList<>()));

		//ajouter les rôles aux users
		User admin = userService.findUserByUsername("admin");
		if (admin != null && admin.getRoles().isEmpty()) {
			userService.addRoleToUser("admin", "ADMIN");
			userService.addRoleToUser("admin", "USER");
		}
		
		User nour = userService.findUserByUsername("nour");
		if (nour != null && nour.getRoles().isEmpty()) {
			userService.addRoleToUser("nour", "AGENT");
		}
		
		User yassine = userService.findUserByUsername("yassine");
		if (yassine != null && yassine.getRoles().isEmpty()) {
			userService.addRoleToUser("yassine", "USER");
		}
	}
}
