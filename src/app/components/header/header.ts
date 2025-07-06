import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterModule], //El RouterModule hacer que la página no se recargue
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {

}
