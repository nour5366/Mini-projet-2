import { Routes } from '@angular/router';
import { serieGuard } from './serie-guard';
import { adminGuard } from './admin-guard';
import { SeriesComponent } from './series/series';
import { AddSerieComponent } from './add-serie/add-serie';
import { UpdateSerieComponent } from './update-serie/update-serie';
import { RechercheParPaysComponent } from './recherche-par-pays/recherche-par-pays';
import { RechercheParTitreComponent } from './recherche-par-titre/recherche-par-titre';
import { ListePaysComponent } from './liste-pays/liste-pays';
import { LoginComponent } from './login/login';
import { ForbiddenComponent } from './forbidden/forbidden';

export const routes: Routes = [
  { path: 'series', component: SeriesComponent },
  { path: 'add-serie', component: AddSerieComponent, canActivate: [serieGuard, adminGuard] },
  { path: 'updateSerie/:id', component: UpdateSerieComponent, canActivate: [serieGuard, adminGuard] },
  { path: 'rechercheParPays', component: RechercheParPaysComponent, canActivate: [serieGuard] },
  { path: 'rechercheParTitre', component: RechercheParTitreComponent, canActivate: [serieGuard] },
  { path: 'listePays', component: ListePaysComponent, canActivate: [serieGuard, adminGuard] },
  { path: 'app-forbidden', component: ForbiddenComponent },
  { path: '', redirectTo: 'series', pathMatch: 'full' },
  { path: 'login', component: LoginComponent }
];
