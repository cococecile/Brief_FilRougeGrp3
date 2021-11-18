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

 
  employee:Employee[];
  selected?: EmployeeListComponent;
  currentIndex: number = -1;

  employeeId: any;
  employeeFirstName: string;
  employeeLastName: string;
  employeeMail: string;
  employeePosition: string;
	employeeManagerBy: Manager;
  employeeMission: Mission;
  employeeDepartment: Department;
  
  

  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) {
    }

      ngOnInit(): void {
       
      }
    }