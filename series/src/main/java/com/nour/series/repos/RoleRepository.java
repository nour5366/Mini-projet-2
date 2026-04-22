package com.nour.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.series.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
