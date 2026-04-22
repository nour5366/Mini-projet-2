import { Component, OnInit } from '@angular/core';
import { Series } from '../model/series.model';
import { SeriesService } from '../services/series.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AuthService } from '../services/auth';

@Component({
  selector: 'app-series',
  imports: [CommonModule, RouterLink],
  templateUrl: './series.html',
  styleUrl: './series.css'
})
export class SeriesComponent implements OnInit {
  series: Series[] = [];

  constructor(private seriesService: SeriesService,
              public authService: AuthService) { }

  ngOnInit(): void {
    this.chargerSeries();
  }

chargerSeries() {
  this.seriesService.listeSeries().subscribe(series => {
    console.log(series);
    this.series = series;
  });
}
supprimerSerie(s: Series) {
  let conf = confirm('Etes-vous sûr ?');
  if (conf) {
    this.seriesService.supprimerSerie(s.codeSerie).subscribe(() => {
      console.log("Série supprimée");
      this.chargerSeries(); // Recharge la liste depuis l'API
    });
  }
}}
