import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit } from '@angular/core';
import { HeaderComponent } from "../header/header.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [HeaderComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent{}
