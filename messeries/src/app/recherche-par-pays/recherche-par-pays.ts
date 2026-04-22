import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../services/series.service';
import { Series } from '../model/series.model';
import { Pays } from '../model/pays.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-recherche-par-pays',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './recherche-par-pays.html',
  styles: ``,
})
export class RechercheParPaysComponent implements OnInit {
  series! : Series[];
  idPays! : number;
  pays! : Pays[];

  constructor(private seriesService: SeriesService) { }

  ngOnInit(): void {
    this.seriesService.listePays().
      subscribe((p: any) => {
        this.pays = p;
        console.log(p);
      });
  }

  onChange() {
    this.seriesService.rechercherParPays(this.idPays).
      subscribe((s: any) => {
        this.series = s;
      });
  }
}
