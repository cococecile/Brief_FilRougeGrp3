import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/model/employee.model';
import { EmployeeService } from 'src/app/services/employee.service';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  
  employees: [];
  selected?: Employee;
  currentEmployee =null;
  currentIndex = -1;
  employeeFirstName = '';
  employeeLastName ='';


  constructor(private employeeService: EmployeeService) { }

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