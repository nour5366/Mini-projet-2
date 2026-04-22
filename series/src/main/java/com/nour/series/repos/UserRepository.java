package com.nour.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.series.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
