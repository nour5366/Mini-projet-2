package com.nour.series.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.nour.series.entites.Pays;
import com.nour.series.entites.Series;
import com.nour.series.repos.PaysRepository;
import com.nour.series.repos.SeriesRepository;

@Service
public class SeriesServiceImpl implements SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private PaysRepository paysRepository;

    @Override
    public Series saveSeries(Series s) {
        return seriesRepository.save(s);
    }

    @Override
    public Series updateSeries(Series s) {
        return seriesRepository.save(s);
    }

    @Override
    public void deleteSeries(Series s) {
        seriesRepository.delete(s);
    }

    @Override
    public void deleteSeriesById(Long id) {
        seriesRepository.deleteById(id);
    }

    @Override
    public Series getSeries(Long id) {
        return seriesRepository.findById(id).get();
    }

    @Override
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public Page<Series> getAllSeriesParPage(int page, int size) {
        return seriesRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Series> findByTitreSerie(String titre) {
        return seriesRepository.findByTitreSerie(titre);
    }

    @Override
    public List<Series> findByTitreSerieContains(String titre) {
        return seriesRepository.findByTitreSerieContains(titre);
    }

    @Override
    public List<Series> findByTitreSerieAndNombreEpisodes(String titre, Long nb) {
        return seriesRepository.findByTitreSerieAndNombreEpisodes(titre, nb);
    }

    @Override
    public List<Series> findByPays(Pays pays) {
        return seriesRepository.findByPays(pays);
    }

    @Override
    public List<Series> findByPaysCodePays(Long id) {
        return seriesRepository.findByPaysCodePays(id);
    }

    @Override
    public List<Series> findByOrderByTitreSerieAsc() {
        return seriesRepository.findByOrderByTitreSerieAsc();
    }

    @Override
    public List<Series> trierSeriesTitresEpisodes() {
        return seriesRepository.trierSeriesTitresEpisodes();
    }

    @Override
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }
}