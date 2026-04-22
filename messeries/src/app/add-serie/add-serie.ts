import { Component, OnInit } from '@angular/core';
import { Series } from '../model/series.model';
import { SeriesService } from '../services/series.service';
import { Router } from '@angular/router';
import { Pays } from '../model/pays.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-serie',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-serie.html',
  styleUrl: './add-serie.css'
})
export class AddSerieComponent implements OnInit {
  newSerie = new Series();
  pays: Pays[] = [];
  newIdPays!: number;

  constructor(private seriesService: SeriesService, private router: Router) { }

  ngOnInit(): void {
    this.seriesService.listePays().
      subscribe((p: any) => {
        this.pays = p;
        console.log(p);
      });
  }

  ajouterSerie() {
    this.newSerie.pays = this.pays.find(p => p.codePays == this.newIdPays)!;
    this.seriesService.ajouterSerie(this.newSerie).subscribe({
      next: (serie) => {
        console.log(serie);
        this.router.navigate(['series']);
      },
      error: (err) => {
        console.error("Erreur lors de l'ajout de la série:", err);
      }
    });
  }
}
