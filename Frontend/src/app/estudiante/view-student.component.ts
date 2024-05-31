import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../entity/estudiante';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceStudentService } from '../services/service-student.service';

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css'],
})
export class ViewStudentComponent  implements OnInit {
  student: Estudiante | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private estudianteService: ServiceStudentService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const studentId = params.get('id');
      if (studentId) {
        this.loadStudent(Number(studentId));
      }
    });
  }

  loadStudent(id: number) {
    this.estudianteService.detail(id).subscribe((data: Estudiante) => {
      this.student = data;
    });
  }

  goBack() {
    this.router.navigate(['/list-student']);
  }
}
