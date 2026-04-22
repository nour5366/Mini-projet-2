package com.nour.series.entites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "titreSerie", types = { Series.class })
public interface SeriesProjection {
    public String getTitreSerie();
}
