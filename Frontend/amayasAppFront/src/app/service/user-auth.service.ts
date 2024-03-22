import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setToken(jwtToken: string) {
    localStorage.setItem("jwtToken", jwtToken);
  }


  
  public setUserName(userName: string) {
    localStorage.setItem("userName", userName);
  }



  public getToken(): string {
    return <string>localStorage.getItem("jwtToken");
  }
  public getUserName(): string {
    return <string>localStorage.getItem("userName");
  }


  public clear() {
    localStorage.clear();
  }

  public isLoggedIn() {
    return this.getToken() != null;
  }


}
