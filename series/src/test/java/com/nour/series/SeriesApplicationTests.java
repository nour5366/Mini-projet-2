package com.nour.series;

import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import com.nour.series.entites.Series;
import com.nour.series.repos.SeriesRepository;
import com.nour.series.service.SeriesService;

@SpringBootTest
class SeriesApplicationTests {

    @Autowired
    private SeriesRepository serieRepository;

    @Autowired
    private SeriesService seriesService;

    @Test
    public void testCreateSerie() {

        Series serie = new Series("Breaking Code", 24L, new Date());

        serieRepository.save(serie);
    }

    @Test
    public void testFindSerie() {
        Series s = serieRepository.findById(1L).get();
        System.out.println(s);
    }

    @Test
    public void testUpdateSerie() {
        Series s = serieRepository.findById(1L).get();
        s.setNombreEpisodes(30L);
        serieRepository.save(s);
    }

    @Test
    public void testDeleteSerie() {
        serieRepository.deleteById(1L);
    }

    @Test
    public void testListerToutesSeries() {
        List<Series> list = serieRepository.findAll();
        for (Series s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testGetAllSeriesParPage() {
        Page<Series> page = seriesService.getAllSeriesParPage(0, 2);
        System.out.println("Taille de la page : " + page.getSize());
        System.out.println("Total éléments   : " + page.getTotalElements());
        System.out.println("Total pages      : " + page.getTotalPages());
        page.getContent().forEach(s -> {
            System.out.println(s.toString());
        });
      
    }
}