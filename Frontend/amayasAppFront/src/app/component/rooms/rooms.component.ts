import { Component, OnInit } from '@angular/core';
import { SalleService } from './../../service/salle.service';
import { Room } from 'src/app/models/Room';
import { Reservation } from 'src/app/models/Reservation';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { User } from 'src/app/models/Utilisateur';
import { MessageService } from 'primeng/api';
@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  constructor(private salleService: SalleService,
    private userAuthService: UserAuthService,
    private reservationService: ReservationService,
    private messageService: MessageService) { }

  rooms !: Room[];
  newReservation = new Reservation();

  roomToBookName !: string
  reservationDialogueVisibility !: boolean;
  date!: Date
  isFormValid: boolean = false;

  ngOnInit(): void {
    this.newReservation.utilisateur = new User()
    this.newReservation.salle = new Room()

    this.salleService.getAllSalles().subscribe(
      res =>
        this.rooms = <Room[]>res
    )
  }

  showDialog(id: number, nom: string) {
    this.roomToBookName = nom
    this.newReservation.salle.id = id
    this.newReservation.salle.nom = nom
    this.reservationDialogueVisibility = true;
  }

  checkForm(): void {
    if (this.newReservation.duree && this.newReservation.dateDebut) {
      this.isFormValid = true;
    } else {
      this.isFormValid = false;
    }
  }

  showSuccess() {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Réservation réussie' });
  }

  showFail() {
    this.messageService.add({ severity: 'error', summary: 'error', detail: 'La salle est indisponible pour ce créneau' });
  }

  saveReservation() {
    this.newReservation.utilisateur.userName = this.userAuthService.getUserName()
    console.log(JSON.stringify(this.newReservation))
    this.reservationService.createReservation(this.newReservation).subscribe(
      (response) => {

        this.showSuccess()
        this.reservationDialogueVisibility = !this.reservationDialogueVisibility

      },
      (error) => {
        if (error.status === 409) {
          this.showFail();
        } else {
          console.error("Une erreur inattendue s'est produite :", error);
        }
      }
    )
  }
}
