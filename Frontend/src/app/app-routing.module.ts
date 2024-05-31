import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { ListStudentComponent } from './estudiante/list-student.component';
import { ViewStudentComponent } from './estudiante/view-student.component';
import { CreateStudentComponent } from './estudiante/create-student.component';
import { UpdateStudentComponent } from './estudiante/update-student.component';
import { ListTeacherComponent } from './profesor/list-teacher.component';
import { ViewTeacherComponent } from './profesor/view-teacher.component';
import { CreateTeacherComponent } from './profesor/create-teacher.component';
import { UpdateTeacherComponent } from './profesor/update-teacher.component';

const routes: Routes = [
  {path:'menu', component: MenuComponent},
  {path:'list-student', component: ListStudentComponent},
  {path:'view-student/:id', component: ViewStudentComponent },
  {path: 'create-student', component: CreateStudentComponent},
  {path: 'update-student/:id', component: UpdateStudentComponent},

  {path:'list-teacher', component: ListTeacherComponent},
  {path:'view-teacher/:id', component: ViewTeacherComponent },
  {path: 'create-teacher', component: CreateTeacherComponent},
  {path: 'update-teacher/:id', component: UpdateTeacherComponent},

  {path: '**', redirectTo: 'menu', pathMatch: 'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
