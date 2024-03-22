import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/models/Reservation';
import { ReservationService } from 'src/app/service/reservation.service';
import { ConfirmationService, MessageService, ConfirmEventType } from 'primeng/api';

@Component({
  selector: 'app-myrooms',
  templateUrl: './myrooms.component.html',
  styleUrls: ['./myrooms.component.css']
})
export class MyroomsComponent implements OnInit {
  reservations !: Reservation[];
  public constructor(
    private reservationService: ReservationService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.reservationService.getUserReservations().subscribe(
      res => {
        this.reservations = <Reservation[]>res
      }
    )
  }

  dropReservation(id: number) {
    this.confirmationService.confirm({
      message: 'Êtes-vous sûr de vouloir annuler la reservation ?',
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.messageService.add({ severity: 'success', summary: 'Confirmer', detail: "la réservation est bien supprimée" });
        this.reservationService.dropReservation(id).subscribe(
          (response) => {
            window.location.reload()
          },
          (error) => {
            console.error('Error', error);
          }
        );
      },
      reject: (type: any) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            this.messageService.add({ severity: 'error', summary: 'Refusé', detail: "Aucune réservation n'a été supprimé" });
            break;
          case ConfirmEventType.CANCEL:
            this.messageService.add({ severity: 'warn', summary: 'Annulé', detail: "Oppération annulée" });
            break;
        }
      }
    });
  }
}
