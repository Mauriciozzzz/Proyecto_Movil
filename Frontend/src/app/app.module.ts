import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ListStudentComponent } from './estudiante/list-student.component';
import { CreateStudentComponent } from './estudiante/create-student.component';
import { UpdateStudentComponent } from './estudiante/update-student.component';
import { ViewStudentComponent } from './estudiante/view-student.component';
import { ListTeacherComponent } from './profesor/list-teacher.component';
import { CreateTeacherComponent } from './profesor/create-teacher.component';
import { UpdateTeacherComponent } from './profesor/update-teacher.component';
import { ViewTeacherComponent } from './profesor/view-teacher.component';

//Librerias para trabajar el formulario
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MenuComponent } from './menu/menu.component';

@NgModule({
  declarations: [AppComponent, ListStudentComponent, CreateStudentComponent, UpdateStudentComponent, ViewStudentComponent,
    ListTeacherComponent, CreateTeacherComponent, UpdateTeacherComponent, ViewTeacherComponent, MenuComponent
  ],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule, FormsModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }],
  bootstrap: [AppComponent],
})
export class AppModule {}
