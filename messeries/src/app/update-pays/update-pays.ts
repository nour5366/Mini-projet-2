import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Pays } from '../model/pays.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-pays',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './update-pays.html',
  styles: ``,
})
export class UpdatePaysComponent implements OnInit {
  @Input()
  pays! : Pays;

  @Input()
  ajout!: boolean;

  @Output()
  paysUpdated = new EventEmitter<Pays>();

  ngOnInit(): void {
    console.log("ngOnInit du composant UpdatePays ", this.pays);
  }

  savePays() {
    this.paysUpdated.emit(this.pays);
  }
}
