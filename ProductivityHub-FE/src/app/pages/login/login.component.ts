import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginObj: Login;

  constructor(private http: HttpClient, private router: Router) {
    this.loginObj = new Login();
  }

  onLogin() {
    this.http.post(`${environment.apiUrl}/auth/login`, this.loginObj).subscribe((res: any) => {
      if (res.token) {
        alert("Login successful");
        localStorage.setItem('loginToken', res.token);
        this.router.navigateByUrl('/dashboard');
      } else {
        alert(res.message);
      }
    }, (error) => {
      console.error('Error during login:', error);
      alert('An error occurred during login.');
    });
  }
}

export class Login {
  email: string;
  password: string;

  constructor() {
    this.email = '';
    this.password = '';
  }
}
