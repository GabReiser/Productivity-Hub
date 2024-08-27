import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { NgModule, CUSTOM_ELEMENTS_SCHEMA }      from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
