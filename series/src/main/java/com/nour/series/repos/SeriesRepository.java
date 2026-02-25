package com.nour.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nour.series.entites.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {

}