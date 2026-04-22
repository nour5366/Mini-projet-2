package com.nour.series.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nour.series.entites.Pays;
import com.nour.series.entites.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    List<Series> findByTitreSerie(String titre);

    List<Series> findByTitreSerieContains(String titre);

    @Query("select s from Series s where s.titreSerie like %:titre and s.nombreEpisodes > :nb")
    List<Series> findByTitreSerieAndNombreEpisodes(@Param("titre") String titre, @Param("nb") Long nb);
    @Query("select s from Series s where s.pays = ?1")
    List<Series> findByPays(Pays pays);

    List<Series> findByPaysCodePays(Long id);

    List<Series> findByOrderByTitreSerieAsc();
    @Query("select s from Series s order by s.titreSerie ASC, s.nombreEpisodes DESC")
    List<Series> trierSeriesTitresEpisodes();

}