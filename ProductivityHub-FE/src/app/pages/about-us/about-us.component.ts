import { Component } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { NgModule, CUSTOM_ELEMENTS_SCHEMA }      from '@angular/core';

@Component({
  selector: 'app-about-us',
  standalone: true,
  imports: [HeaderComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './about-us.component.html',
  styleUrl: './about-us.component.css'
})
export class AboutUsComponent {

}
