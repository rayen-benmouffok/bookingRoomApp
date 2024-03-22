import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { ToolbarModule } from 'primeng/toolbar';
import { ButtonModule } from 'primeng/button';
import { RoomsComponent } from './rooms/rooms.component';
import { TableModule } from 'primeng/table';
import { LoginComponent } from './login/login.component';
import { MyroomsComponent } from './myrooms/myrooms.component';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputNumberModule } from 'primeng/inputnumber';
import { ConfirmationService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
@NgModule({
  declarations: [
    HeaderComponent,
    RoomsComponent,
    LoginComponent,
    MyroomsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ToolbarModule,
    ButtonModule,
    TableModule,
    FormsModule,
    DialogModule,
    BrowserAnimationsModule,
    InputNumberModule,
    ToastModule,
    ConfirmDialogModule
  ],
  providers: [
    ConfirmationService
  ],
  exports: [
    HeaderComponent,
    RoomsComponent,
    LoginComponent,
    MyroomsComponent,
    RouterModule
  ]
})
export class ComponentModule { }
