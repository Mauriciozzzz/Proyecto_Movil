import { Component, OnInit } from '@angular/core';
import { Profesor } from '../entity/profesor';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceTeacherService } from '../services/service-teacher.service';

@Component({
  selector: 'app-update-teacher',
  templateUrl: './update-teacher.component.html',
  styleUrls: ['./update-teacher.component.css'],
})
export class UpdateTeacherComponent  implements OnInit {
  id!: number;
  estudiante!: Profesor;

  constructor(
    private router: Router,
    private estudianteService: ServiceTeacherService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    // Obtener el ID del estudiante de la ruta
    const idParam = this.activatedRoute.snapshot.paramMap.get('id');
    // Verificar si idParam no es null antes de convertirlo a número
    if (idParam !== null) {
      this.id = +idParam;
      this.getProfesor();
    } else {
      console.error('El parámetro ID no está presente en la ruta.');
    }
  }

  onUpdate(): void {
    this.estudianteService.update(this.id, this.estudiante).subscribe(
      (data: Profesor) => {
        this.router.navigate(['list-teacher']);
      },
      err => {
        console.error(err);
      }
    );
  }

  getProfesor(): void {
    this.estudianteService.detail(this.id).subscribe(
      (data: Profesor) => {
        this.estudiante = data;
      },
      err => {
        console.error(err);
      }
    );
  }
}
