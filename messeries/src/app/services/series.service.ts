import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Series } from '../model/series.model';
import { Pays, PaysWrapper } from '../model/pays.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SeriesService {
  apiURL: string = environment.apiURL;
  apiURLPays: string = environment.apiURL + "/pays";

  constructor(private http: HttpClient) { }

  listeSeries(): Observable<Series[]> {
    return this.http.get<Series[]>(this.apiURL + "/all");
  }

  consulterSerie(id: number): Observable<Series> {
    const url = `${this.apiURL}/getbyid/${id}`;
    return this.http.get<Series>(url);
  }

  ajouterSerie(serie: Series): Observable<Series> {
    return this.http.post<Series>(this.apiURL + "/addserie", serie);
  }

  updateSerie(serie: Series): Observable<Series> {
    return this.http.put<Series>(this.apiURL + "/updateserie", serie);
  }

  supprimerSerie(id: number) {
    const url = `${this.apiURL}/delserie/${id}`;
    return this.http.delete(url);
  }

  listePays(): Observable<Pays[]> {
    return this.http.get<Pays[]>(this.apiURLPays);
  }

  ajouterPays(pays: Pays): Observable<Pays> {
    return this.http.post<Pays>(this.apiURLPays, pays);
  }

  rechercherParPays(idPays: number): Observable<Series[]> {
    const url = `${this.apiURL}/seriespays/${idPays}`;
    return this.http.get<Series[]>(url);
  }

  rechercherParTitre(titre: string): Observable<Series[]> {
    const url = `${this.apiURL}/seriesByTitre/${titre}`;
    return this.http.get<Series[]>(url);
  }
}
