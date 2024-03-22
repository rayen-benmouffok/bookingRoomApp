import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { RoomsComponent } from './component/rooms/rooms.component';
import { MyroomsComponent } from './component/myrooms/myrooms.component';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  { path: "rooms", component: RoomsComponent, canActivate: [AuthGuard] },
  { path: "myRooms", component: MyroomsComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
