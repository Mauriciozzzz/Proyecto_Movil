import { Component, OnInit } from '@angular/core';
import { ServiceStudentService } from '../services/service-student.service';
import { Router } from '@angular/router';
import { Estudiante } from '../entity/estudiante';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css'],
})
export class ListStudentComponent  implements OnInit {
  students: Estudiante[] = [];

  constructor(
    private estudianteService: ServiceStudentService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadStudents();
  }

  loadStudents() {
    this.estudianteService.getAll().subscribe((data: Estudiante[]) => {
      this.students = data;
    });
  }

  viewStudent(id: number) {
    this.router.navigate(['/view-student/', id]);
  }

  updateStudent(id: number) {
    this.router.navigate(['/update-student/', id]);
  }

  deleteStudent(id: number) {
    this.estudianteService.delete(id).subscribe(() => {
      this.loadStudents();
    });
  }
}
