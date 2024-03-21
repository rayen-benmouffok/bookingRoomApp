import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  PATH_OF_API = "http://localhost:8080/reservations" 

  constructor(private userAuthService: UserAuthService, private httpClient: HttpClient) { }

  public createReservation(reservationData: any) {

    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + this.userAuthService.getToken(),
      'Content-Type': 'application/json'
    });
    return this.httpClient.post(this.PATH_OF_API, reservationData, { headers: headers, responseType: 'text' });
  }

  public dropReservation(reservationId: number) {
    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + this.userAuthService.getToken(),
      'Content-Type': 'application/json'
    });
    return this.httpClient.delete(this.PATH_OF_API + "/" + reservationId, { headers: headers })
  }


  public getUserReservations() {
    const currentUserName = new String(this.userAuthService.getUserName())
    const headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Bearer ' + this.userAuthService.getToken(),
      'Content-Type': 'application/json'
    });

    return this.httpClient.get(this.PATH_OF_API + "/user/" + currentUserName, { headers: headers });
  }
}
