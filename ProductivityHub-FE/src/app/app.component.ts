import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA }      from '@angular/core';
import { HeaderComponent } from './pages/header/header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, RouterOutlet, HeaderComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProductivityHub-FE';
}


