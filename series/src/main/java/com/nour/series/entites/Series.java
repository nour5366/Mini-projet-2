package com.nour.series.entites;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeSerie;

    private String titreSerie;

    private Long nombreEpisodes;

    private Date dateLancement;

    public Series() {
        super();
    }

    public Series(String titreSerie, Long nombreEpisodes, Date dateLancement) {
        super();
        this.titreSerie = titreSerie;
        this.nombreEpisodes = nombreEpisodes;
        this.dateLancement = dateLancement;
    }

    public Long getCodeSerie() {
        return codeSerie;
    }

    public void setCodeSerie(Long codeSerie) {
        this.codeSerie = codeSerie;
    }

    public String getTitreSerie() {
        return titreSerie;
    }

    public void setTitreSerie(String titreSerie) {
        this.titreSerie = titreSerie;
    }

    public Long getNombreEpisodes() {
        return nombreEpisodes;
    }

    public void setNombreEpisodes(Long nombreEpisodes) {
        this.nombreEpisodes = nombreEpisodes;
    }

    public Date getDateLancement() {
        return dateLancement;
    }

    public void setDateLancement(Date dateLancement) {
        this.dateLancement = dateLancement;
    }

    @Override
    public String toString() {
        return "Serie [codeSerie=" + codeSerie +
                ", titreSerie=" + titreSerie +
                ", nombreEpisodes=" + nombreEpisodes +
                ", dateLancement=" + dateLancement + "]";
    }
}