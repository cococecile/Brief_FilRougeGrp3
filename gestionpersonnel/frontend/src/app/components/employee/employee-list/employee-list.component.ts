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
 
//   employees?:Employee[];
//   selected?: EmployeeListComponent;
//   currentIndex: number = -1;
 
//   id: any;
//   employeeFirstName: string ='';
//   employeeLastName: string ='';
//   employeeMission: string=''
//   employeeMail: string ='';
//   employeeDepartement : string ='';

//   constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { 
//   }

//   ngOnInit(): void {
//     this.route.queryParams
//       .subscribe(params => {
//         this.getAllEmployees()
//         }
//        );
//   }
//   getAllEmployees(): void  {
//     this.employeeService.getAll()
//     .subscribe(
//       data => {
//         this.employees = data;
//       },
//       error => {
//         console.error(error);
//       });
//   }

//   refreshList(): void {
//     this.getAllEmployees();
//     this.selected = undefined;
//     this.currentIndex = -1;
//   }
  
//   delete(): void {
//     if (!this.selected) {
//       return;
//     }

//     this.employeeService.delete(this.selected.id)
//       .subscribe(
//         response => {
//           this.refreshList();
//         },
//         error => {
//           console.error(error);
//         });
//   }
 