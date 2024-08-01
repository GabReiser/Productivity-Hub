import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerObj: Register;

  constructor(private http: HttpClient, private router: Router){
    this.registerObj = new Register();
  }

  onRegister(){
    //Colocar o endPoint no ''
    this.http.post(`${environment.apiUrl}/login`, this.registerObj).subscribe((res: any) => {
      if(res.result){
        alert("Register sucessful!");
        this.router.navigateByUrl('/login');
      } else {
        alert(res.message);
      }
    },(error) => {
      console.error('Error during register:', error);
      alert('An error occurred during register.');
  });
  }
}

export class Register {
  UserName: string;
  Password: string;
  Email: string;

  constructor(){
    this.UserName = '';
    this.Password = '';
    this.Email = '';
  }
}
function subscribe(arg0: (res: any) => void) {
  throw new Error('Function not implemented.');
}

