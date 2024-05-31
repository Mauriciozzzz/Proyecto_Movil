import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../entity/estudiante';
import { ServiceStudentService } from '../services/service-student.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css'],
})
export class UpdateStudentComponent  implements OnInit {
  id!: number;
  estudiante!: Estudiante;

  constructor(
    private router: Router,
    private estudianteService: ServiceStudentService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    // Obtener el ID del estudiante de la ruta
    const idParam = this.activatedRoute.snapshot.paramMap.get('id');
    // Verificar si idParam no es null antes de convertirlo a número
    if (idParam !== null) {
      this.id = +idParam;
      this.getEstudiante();
    } else {
      console.error('El parámetro ID no está presente en la ruta.');
    }
  }

  onUpdate(): void {
    this.estudianteService.update(this.id, this.estudiante).subscribe(
      (data: Estudiante) => {
        this.router.navigate(['list-student']);
      },
      err => {
        console.error(err);
      }
    );
  }

  getEstudiante(): void {
    this.estudianteService.detail(this.id).subscribe(
      (data: Estudiante) => {
        this.estudiante = data;
      },
      err => {
        console.error(err);
      }
    );
  }
}