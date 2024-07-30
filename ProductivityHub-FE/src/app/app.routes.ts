import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
  {

      path: '', redirectTo: 'home', pathMatch: 'full'
    },
    {
      path: 'home',
      component:HomeComponent
    },
    {
      path: 'login',
      component:LoginComponent
    },
    {
      path: 'register',
      component:RegisterComponent
    },
    {
      path: 'layout',
      component:LayoutComponent,
      children:[
        {
          path:'dashboard',
          component:DashboardComponent
        }
      ]
    },

];
