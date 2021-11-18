import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/model/department.model';
import { Employee } from 'src/app/model/employee.model';
import { Manager } from 'src/app/model/manager.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-detail',
  templateUrl: './manager-detail.component.html',
  styleUrls: ['./manager-detail.component.scss']
})
export class ManagerDetailComponent implements OnInit {

   
  selected?: Manager;
  currentManager=null;
  currentIndex: number = -1;

  managers:[];
  managerFirstName: string;
  managerLastName: string;
  managerEmail: string;
  managerDepartment: Department;

  department:[];
  departmentName: string;

  managedEmployee: Employee;
  employee: [];
  employeeFirsName: string;



  constructor(private employeeService: ManagerService) {
  }

  ngOnInit(): void {
     this.retrieveManagers();
      }
    
      retrieveManagers(): void {
       this.employeeService.getAll()
       .subscribe(
         data => {
           this.managers = data;
           console.log(data);
         },
         error => {
           console.log(error);
         });
      }
    
      refreshList(): void {
        this.refreshList();
        this.currentManager = null;
        this.currentIndex = -1;
      }
    
      setActiveManager(employee,index): void {
        this.currentManager = employee;
        this.currentIndex = index;
      }
    
      delete(): void {
        if (!this.selected) {
          return;
        }
    }
    
    }