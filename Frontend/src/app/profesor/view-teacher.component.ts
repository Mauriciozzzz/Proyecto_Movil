import { Component, OnInit } from '@angular/core';
import { Profesor } from '../entity/profesor';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceTeacherService } from '../services/service-teacher.service';

@Component({
  selector: 'app-view-teacher',
  templateUrl: './view-teacher.component.html',
  styleUrls: ['./view-teacher.component.css'],
})
export class ViewTeacherComponent  implements OnInit {
  profesor: Profesor | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private estudianteService: ServiceTeacherService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const profesorId = params.get('id');
      if (profesorId) {
        this.loadProfesor(Number(profesorId));
      }
    });
  }

  loadProfesor(id: number) {
    this.estudianteService.detail(id).subscribe((data: Profesor) => {
      this.profesor = data;
    });
  }

  goBack() {
    this.router.navigate(['/list-teacher']);
  }
}