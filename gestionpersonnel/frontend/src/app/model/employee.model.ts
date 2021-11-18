import { Department } from "./department.model";
import { Manager } from "./manager.model";
import { Mission } from "./mission.model";

export class Employee {
 
 
  	employeeId?: any;
    employeeFirstName?: string;
    employeeLastName?: string;
    employeeMail?: string;
    employeePosition?: string;
  	employeeManagerBy?: Manager;
    employeeMission?: Mission;
    employeeDepartment?: Department;
  }