package com.nour.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.series.entites.Pays;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pays")
public interface PaysRepository extends JpaRepository<Pays, Long> {
}
