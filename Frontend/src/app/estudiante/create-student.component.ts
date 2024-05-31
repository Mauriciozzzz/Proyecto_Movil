import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../entity/estudiante';
import { Router } from '@angular/router';
import { ServiceStudentService } from '../services/service-student.service';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css'],
})
export class CreateStudentComponent  implements OnInit {
  nuevoEstudiante: Estudiante = {
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  };

  constructor(
    private router: Router,
    private estudianteService: ServiceStudentService
  ) {}

  ngOnInit() {}

  onCreate(): void {
    this.estudianteService.create(this.nuevoEstudiante).subscribe(
      (data: Estudiante) => {
        console.log('Estudiante creado exitosamente:', data);
        this.router.navigate(['list-student']);
      },
      err => {
        console.error('Error al crear estudiante:', err);
      }
    );
  }
}