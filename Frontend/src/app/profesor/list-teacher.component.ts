import { Component, OnInit } from '@angular/core';
import { ServiceTeacherService } from '../services/service-teacher.service';
import { Profesor } from '../entity/profesor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-teacher',
  templateUrl: './list-teacher.component.html',
  styleUrls: ['./list-teacher.component.css'],
})
export class ListTeacherComponent  implements OnInit {
  profesor: Profesor[] = [];

  constructor(
    private serviceTeacher: ServiceTeacherService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadStudents();
  }

  loadStudents() {
    this.serviceTeacher.getAll().subscribe((data: Profesor[]) => {
      this.profesor = data;
    });
  }

  viewStudent(id: number) {
    this.router.navigate(['/view-teacher/', id]);
  }

  updateStudent(id: number) {
    this.router.navigate(['/update-teacher/', id]);
  }

  deleteStudent(id: number) {
    this.serviceTeacher.delete(id).subscribe(() => {
      this.loadStudents();
    });
  }
}
