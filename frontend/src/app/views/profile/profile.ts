import { Component, inject } from '@angular/core';
import { Persona } from '../../models/Persona';
import { Auth } from '../../services/auth';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-profile',
  imports: [RouterModule],
  templateUrl: './profile.html',
  styleUrl: './profile.css'
})
export class Profile {
  public tab: string = "general";
  public authService = inject(Auth);

  user: Persona | null = this.authService.getUserData();

  editProfile() {
    // Logic to edit the profile
    console.log('Edit profile clicked');
  }
  logout() {
    this.authService.logout();
  }

}
