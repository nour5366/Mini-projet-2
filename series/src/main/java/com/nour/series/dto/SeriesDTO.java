package com.nour.series.dto;

import java.util.Date;
import com.nour.series.entites.Pays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesDTO {
    private Long codeSerie;
    private String titreSerie;
    private Long nombreEpisodes;
    private Date dateLancement;
    private Pays pays;
    private String nomPays;
}
