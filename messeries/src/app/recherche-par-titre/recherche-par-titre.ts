import { Component, OnInit } from '@angular/core';
import { SeriesService } from '../services/series.service';
import { Series } from '../model/series.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SearchFilterPipe } from '../search-filter-pipe';

@Component({
  selector: 'app-recherche-par-titre',
  standalone: true,
  imports: [CommonModule, FormsModule, SearchFilterPipe],
  templateUrl: './recherche-par-titre.html',
  styles: ``,
})
export class RechercheParTitreComponent implements OnInit {
  series! : Series[];
  titreSerie! : string;
  allSeries! : Series[];
  searchTerm!: string;

  constructor(private seriesService: SeriesService) { }

  ngOnInit(): void {
    this.seriesService.listeSeries().subscribe(prods => {
        console.log(prods);
        this.allSeries = prods;
        this.series = prods;
    });
  }

  rechercherSeries() {
    if (this.titreSerie) {
      this.seriesService.rechercherParTitre(this.titreSerie).subscribe((s: any) => {
        this.series = s;
        console.log(s);
      });
    } else {
      this.seriesService.listeSeries().subscribe(prods => {
        this.series = prods;
      });
    }
  }

  onKeyUp(filterText: string) {
    this.series = this.allSeries.filter(item =>
      item.titreSerie.toLowerCase().includes(filterText.toLowerCase()));
  }
}
