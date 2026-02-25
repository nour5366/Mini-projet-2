package com.nour.series;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nour.series.entites.Series;
import com.nour.series.service.SeriesService;

@SpringBootApplication
public class SeriesApplication implements CommandLineRunner {

	@Autowired
	SeriesService seriesService;

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		seriesService.saveSeries(new Series("Breaking Bad", 62L, new Date()));
		seriesService.saveSeries(new Series("The Wire", 60L, new Date()));
		seriesService.saveSeries(new Series("Game of Thrones", 73L, new Date()));
	}

}
