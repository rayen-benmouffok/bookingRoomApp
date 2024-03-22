import { Component } from '@angular/core';
import { UserAuthService } from './service/user-auth.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'amayasAppFront';

  constructor( public userAuthService:UserAuthService){}
}
