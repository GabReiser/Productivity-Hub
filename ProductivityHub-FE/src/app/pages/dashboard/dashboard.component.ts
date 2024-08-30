import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{

  users:any[]=[];
  constructor(private http:HttpClient){

  }
  ngOnInit(): void {
    this.getAllusers();
  }

  getAllusers(){
    //Nesse get deve se receber todos os usuários, para assim verificar o token, inserir BreakPoint
    this.http.get('').subscribe((res:any)=>{
      this.users=res.token;
    }, error=>{
      alert("Error !From API")
    })
  }
}
