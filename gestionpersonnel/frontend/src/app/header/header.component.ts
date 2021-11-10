import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { 
    afficherRecherche() {
      //Affichage de l'élément
      this.show = !this.show;  
      setTimeout(()=>{ // On attend que le booléen ait bien été modifié avant de faire le focus
        this.searchElement.nativeElement.focus();
      },0);  
    }
  }

  ngOnInit(): void {
  }

}
