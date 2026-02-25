package com.nour.series.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.nour.series.entites.Series;
import com.nour.series.repos.SeriesRepository;

@Service
public class SeriesServiceImpl implements SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

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
}