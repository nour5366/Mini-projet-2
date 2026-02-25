package com.nour.series.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.nour.series.entites.Series;

public interface SeriesService {
    Series saveSeries(Series s);

    Series updateSeries(Series s);

    void deleteSeries(Series s);

    void deleteSeriesById(Long id);

    Series getSeries(Long id);

    List<Series> getAllSeries();

    Page<Series> getAllSeriesParPage(int page, int size);
}