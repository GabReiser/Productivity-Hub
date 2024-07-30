import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule , HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginObj: Login;

  constructor(private http: HttpClient){
    this.loginObj = new Login();
  }
  onLogin(){
    this.http.post('',this.loginObj),subscribe((res:any)=>{
      if(res.result){
        alert("login sucess")
      }else{
        alert(res.message)
      }
    })
  }
}

export class Login {
  UserName: string;
  Password: string;

  constructor(){
    this.UserName= '';
    this.Password= '';
  }

}
function subscribe(arg0: (res: any) => void) {
  throw new Error('Function not implemented.');
}

