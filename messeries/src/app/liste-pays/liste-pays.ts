import { Component, OnInit } from '@angular/core';
import { Pays } from '../model/pays.model';
import { SeriesService } from '../services/series.service';
import { CommonModule } from '@angular/common';
import { UpdatePaysComponent } from '../update-pays/update-pays';

@Component({
  selector: 'app-liste-pays',
  standalone: true,
  imports: [CommonModule, UpdatePaysComponent],
  templateUrl: './liste-pays.html',
  styles: ``,
})
export class ListePaysComponent implements OnInit {
  pays! : Pays[];
  updatedPays:Pays = {"codePays":0,"nomPays":"","continent":""};
  ajout:boolean=true;

  constructor(private seriesService : SeriesService) { }

  ngOnInit(): void {
    this.chargerPays();
  }

  chargerPays() {
    this.seriesService.listePays().
      subscribe(p => {
        this.pays = p as any;
        console.log(p);
      });
  }

  paysUpdated(p: Pays) {
    console.log("Pays updated event", p);
    this.seriesService.ajouterPays(p).subscribe(() => this.chargerPays());
  }

  updatePays(p: Pays) {
    this.updatedPays = p;
    this.ajout = false;
  }
}
