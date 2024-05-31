import { Component, OnInit } from '@angular/core';
import { Profesor } from '../entity/profesor';
import { Router } from '@angular/router';
import { ServiceTeacherService } from '../services/service-teacher.service';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrls: ['./create-teacher.component.css'],
})
export class CreateTeacherComponent  implements OnInit {
  nuevoProfesor: Profesor = {
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  };

  constructor(
    private router: Router,
    private estudianteService: ServiceTeacherService
  ) {}

  ngOnInit() {}

  onCreate(): void {
    this.estudianteService.create(this.nuevoProfesor).subscribe(
      (data: Profesor) => {
        console.log('Profesor creado exitosamente:', data);
        this.router.navigate(['list-teacher']);
      },
      err => {
        console.error('Error al crear profesor:', err);
      }
    );
  }
}
