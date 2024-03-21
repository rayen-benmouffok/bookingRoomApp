import { Room } from "./Room";
import { User } from "./Utilisateur";

export class Reservation {
    salle !: Room;
    utilisateur !: User;
    dateDebut !: Date;
    duree !: number;

}

