import { Component } from '@angular/core';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(private userAuthService: UserAuthService, private route: Router) { }
  logout() {
    this.userAuthService.clear()
    this.route.navigate(["/login"])
  }

}
