import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/model/department.model';
import { Employee } from 'src/app/model/employee.model';
import { Manager } from 'src/app/model/manager.model';
import { Mission } from 'src/app/model/mission.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { EmployeeListComponent } from '../employee-list/employee-list.component';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.scss']
})
export class EmployeeDetailComponent implements OnInit {

 
  
  selected?: Employee;
  currentEmployee =null;
  currentIndex: number = -1;

  employees:[];
  employeeFirstName: string;
  employeeLastName: string;
  employeeMail: string;
  employeePosition: string;
	employeeManagerBy: Manager;
  employeeMission: Mission;
  employeeDepartment: Department;

  manager:[];
  managerFirstName: string;
  managerLastName: string;

  department:[];
  departmentName: string;

  mission: [];
  missionName: string;

  
  

  constructor(private employeeService: EmployeeService) {
    }

      ngOnInit(): void {
        this.retrieveEmployees();
      }
    
      retrieveEmployees(): void {
       this.employeeService.getAll()
       .subscribe(
         data => {
           this.employees = data;
           console.log(data);
         },
         error => {
           console.log(error);
         });
      }
    
      refreshList(): void {
        this.refreshList();
        this.currentEmployee = null;
        this.currentIndex = -1;
      }
    
      setActiveEmployee(employee,index): void {
        this.currentEmployee = employee;
        this.currentIndex = index;
      }
    
      delete(): void {
        if (!this.selected) {
          return;
        }
    }
    
    }
    