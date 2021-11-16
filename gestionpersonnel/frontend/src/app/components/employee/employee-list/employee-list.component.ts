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

  employees?:Employee[];
  selected?: EmployeeListComponent;
  currentIndex: number = -1;
 
  id: any;
  employeeFirstName: string ='';
  employeeLastName: string ='';
  employeeMail: string ='';
  employeePosition : string ='';

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { 
  }

  ngOnInit(): void {
    this.route.queryParams
      .subscribe(params => {
        this.getAllEmployees()
        }
       );
  }
  getAllEmployees(): void  {
    this.employeeService.list()
    .subscribe(
      data => {
        this.employees = data;
      },
      error => {
        console.error(error);
      });
  }

  refreshList(): void {
    this.getAllEmployees();
    this.selected = undefined;
    this.currentIndex = -1;
  }
  
  delete(): void {
    if (!this.selected) {
      return;
    }

    this.employeeService.delete(this.selected.id)
      .subscribe(
        response => {
          this.refreshList();
        },
        error => {
          console.error(error);
        });
  }
 

}
