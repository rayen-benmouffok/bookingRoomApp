import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  PATH_OF_API = "http://localhost:8080"

  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  );

  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) { }


  public login(loginData: any) {
    return this.httpClient.post(this.PATH_OF_API + "/authenticate", loginData, { headers: this.requestHeader });
  }

  public createUser(userData: any) {

    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + this.userAuthService.getToken(),
      'Content-Type': 'application/json'
    });
    return this.httpClient.post(this.PATH_OF_API + "/registerNewUser", userData, { headers: headers });
  }

}
