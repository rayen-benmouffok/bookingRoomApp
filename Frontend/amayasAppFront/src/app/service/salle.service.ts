import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class SalleService {

  PATH_OF_API = "http://localhost:8080/salles"


  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) { }



  public getAllSalles() {

    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + this.userAuthService.getToken(),
      'Content-Type': 'application/json'
    });

    return this.httpClient.get(this.PATH_OF_API, { headers: headers });
  }

}
