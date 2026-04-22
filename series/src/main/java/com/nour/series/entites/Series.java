package com.nour.series.entites;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeSerie;

    @NotNull
    @Size(min = 4, max = 25)
    private String titreSerie;

    @Min(value = 10)
    @Max(value = 10000)
    private Long nombreEpisodes;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateLancement;

    @ManyToOne
    private Pays pays;
}