import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { data } from 'jquery';
import { Department } from 'src/app/model/department.model';
import { Employee } from 'src/app/model/employee.model';
import { Manager } from 'src/app/model/manager.model';
import { Mission } from 'src/app/model/mission.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { ManagerService } from 'src/app/services/manager.service';


@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {

  employee = {
  employeeFirsName:'',
  employeeLastName:'',
  employeeMail:'',
  employeePosition:'',
  employeeDepartment:'',
  employeeManagerBy:'',
  employeeMission:'',
  published: false
  }
  submitted = false;
  editMode = false;
 
  managers: Manager[];
  validateForm!: FormGroup;
  paramId: string;
 
  constructor(private EmployeeService: EmployeeService) { }

  ngOnInit(): void {
  }

  saveEmployee(): void {
   const data = {
    employeeFirsName:this.employee.employeeFirsName,
    employeeLastName:this.employee.employeeLastName,
    employeeMail:this.employee.employeeMail,
    employeePosition:this.employee.employeePosition,
    employeeDepartment:this.employee. employeeDepartment,
    employeeManagerBy:this.employee.employeeManagerBy,
    employeeMission:this.employee.employeeMission
    };

    this.EmployeeService.create(data)
      .subscribe(
      response => {
      console.log(response);
      this.submitted = true;
    },
    error => {
      console.log(error);
    });
  }

     newEployee(): void {
      this.submitted = false;
      this.employee = {
       employeeFirsName:'',
       employeeLastName:'',
       employeeMail:'',
        employeePosition:'',
       employeeDepartment:'',
       employeeManagerBy:'',
       employeeMission:'',
       published: false
       };
    }
  }

  
  

//   submitForm(): void {
//     if (this.validateForm.valid) {
//       console.log('form valid');
//       if (this.editMode) {
//         let employee: Employee = this.validateForm.value;
//         employee.employeeId = this.route.snapshot.paramMap.get('id');
//         this.employeeService
//           .createOrUpdate(employee)
//           .subscribe((res: HttpResponse<Employee>) => {
//             if (res.status === 200) {
//               this.router.navigate(['/employee']);
//             }
//           });
//       } else {
//         this.employeeService
//           .createOrUpdate(this.validateForm.value)
//           .subscribe((res: HttpResponse<Employee>) => {
//             if (res.status === 200) {
//               this.router.navigate(['/employee']);
//             }
//           });
//       }
//     } else {
//       Object.values(this.validateForm.controls).forEach((control) => {
//         if (control.invalid) {
//           control.markAsDirty();
//           control.updateValueAndValidity({ onlySelf: true });
//         }
//       });
//     }
//   }




//  {
 
//   this.getManagers();
//   this.getDepartements();
//   this.getMissions();


//   console.log(this.route.snapshot.paramMap.get('id'));
//   this.paramId = this.route.snapshot.paramMap.get('id');
//   if (this.paramId != null) {
//     this.editMode = true;
//     this.employeeService
//       .find(this.paramId)
//       .subscribe((res: HttpResponse<Employee>) => {
//         if (res.status === 200) {
//           const employee = res.body;
//           this.validateForm.controls['employeeFirsName'].setValue(
//             employee.employeeFirstName
//           );
//           this.validateForm.controls['employeeLastName'].setValue(
//             employee.employeeLastName
//           );
//           this.validateForm.controls['employeeMail'].setValue(
//             employee.employeeMail
//           );
//           this.validateForm.controls['employeePosition'].setValue(
//             employee.employeePosition
//           );
//           this.validateForm.controls['employeeManagerBy'].setValue(
//             employee.employeeManagerBy.managerFirstName
//           );
//           this.validateForm.controls['departmentName'].setValue(
//             employee.employeeDepartment.departmentName

//           );
//           //  this.validateForm.controls['missionName'].setValue(
//           //   employee.employeeMission.missionName
//           // );
//         }
//       });
//   }
// }
//   getMissions() {
//     throw new Error('Method not implemented.');
//   }
//   getDepartements() {
//     throw new Error('Method not implemented.');
//   }
 
// getManagers(): void {
//   this.managerService.findAll().subscribe((res: HttpResponse<Manager[]>) => {
//     this.managers = res.body;
//   });
// }
