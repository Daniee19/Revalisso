import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule, FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-pruebamaterial',
  standalone: true,
  imports: [MatInputModule, MatButtonModule, ReactiveFormsModule],
  templateUrl: './pruebamaterial.html',
  styleUrls: ['./pruebamaterial.css']
})
export class Pruebamaterial {
  contributionForm: FormGroup;

  constructor(fb: FormBuilder) {
    this.contributionForm = fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
    });

  }
  insertar(){
    
  }
}
