import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './components/landing/landing.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { EmployeeDetailComponent } from './components/employee/employee-detail/employee-detail.component';
import { EmployeeFormComponent } from './components/employee/employee-form/employee-form.component';
import { ManagerListComponent } from './components/manager/manager-list/manager-list.component';
import { ManagerDetailComponent } from './components/manager/manager-detail/manager-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    EmployeeListComponent,
    EmployeeDetailComponent,
    EmployeeFormComponent,
    ManagerListComponent,
    ManagerDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
