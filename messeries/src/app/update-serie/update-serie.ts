import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SeriesService } from '../services/series.service';
import { Series } from '../model/series.model';
import { Pays } from '../model/pays.model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-serie',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-serie.html',
  styleUrl: './update-serie.css'
})
export class UpdateSerieComponent implements OnInit {
  currentSerie = new Series();
  pays: Pays[] = [];
  updatedIdPays!: number;

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private seriesService: SeriesService) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];

    this.seriesService.listePays().
      subscribe((p: any) => {
        this.pays = p;
        console.log(p);
      });

    this.seriesService.consulterSerie(id).
      subscribe(s => {
        this.currentSerie = s;
        this.updatedIdPays = s.pays?.codePays;
      });
  }

  updateSerie() {
    this.currentSerie.pays = this.pays.
      find(p => p.codePays == this.updatedIdPays)!;
    this.seriesService.updateSerie(this.currentSerie).subscribe(s => {
      this.router.navigate(['series']);
    });
  }

}
