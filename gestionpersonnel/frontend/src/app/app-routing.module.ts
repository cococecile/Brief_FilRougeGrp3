import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingComponent } from './components/landing/landing.component';
import { DepartmentDetailComponent } from './components/department/department-detail/department-detail.component';
import { DepartmentFormComponent } from './components/department/department-form/department-form.component';
import { DepartmentListComponent } from './components/department/department-list/department-list.component';
import { EmployeeDetailComponent } from './components/employee/employee-detail/employee-detail.component';
import { EmployeeFormComponent } from './components/employee/employee-form/employee-form.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { ManagerDetailComponent } from './components/manager/manager-detail/manager-detail.component';
import { ManagerFormComponent } from './components/manager/manager-form/manager-form.component';
import { ManagerListComponent } from './components/manager/manager-list/manager-list.component';
import { MissionDetailComponent } from './components/mission/mission-detail/mission-detail.component';
import { MissionFormComponent } from './components/mission/mission-form/mission-form.component';
import { MissionListComponent } from './components/mission/mission-list/mission-list.component';



const routes: Routes = [
  { path: '', component: LandingComponent },
  { path: 'landing', component: LandingComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' },

  { path: 'department-detail', component: DepartmentDetailComponent },

  { path: 'department-form', component: DepartmentFormComponent },

  { path: 'department-list', component: DepartmentListComponent },

  { path: 'employee-detail', component: EmployeeDetailComponent },

  { path: 'employee-form', component: EmployeeFormComponent },

  { path: 'employee-list', component: EmployeeListComponent },

  { path: 'manager-detail', component: ManagerDetailComponent },

  { path: 'manager-form', component: ManagerFormComponent },

  { path: 'manager-list', component: ManagerListComponent},
  
  { path: 'mission-detail', component: MissionDetailComponent },

  { path: 'mission-form', component: MissionFormComponent },

  { path: 'mission-list', component: MissionListComponent },

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
