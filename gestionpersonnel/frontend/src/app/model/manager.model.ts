import { Department } from "./department.model";
import { Employee } from "./employee.model";
import { Mission } from "./mission.model";

export class Manager {
    managerId?: any;
    managerFirstName?: string;
    managerLastName?: string;
    managerEmail?: string;
    managerDepartment?: Department;
    managerEmployees?: [Employee];
  }