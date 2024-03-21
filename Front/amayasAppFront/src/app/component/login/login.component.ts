import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { UserAuthService } from '../../service/user-auth.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userName !: string
  userPassword !: string


  credentialsIncorrect = false;

  constructor(private userService: UserService,
    private userAuthService: UserAuthService,
    private route: Router) { }
  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response: any) => {
        this.userAuthService.setToken(response.jwtToken)
        this.userAuthService.setUserName(loginForm.value.userName)
        this.route.navigate(['/rooms'])
      },
      (error) => {
        this.credentialsIncorrect = true
      }
    );
  }


}
