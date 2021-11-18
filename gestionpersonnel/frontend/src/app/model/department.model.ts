import { Employee } from "./employee.model";
import { Manager } from "./manager.model";
import { Mission } from "./mission.model";


export class Department {
  
   departmentId?: any;
    departmentName?: string;
    departmentEmployees?: [Employee];
    departmentMissions?: [Mission];
    departmentChief?: Manager;
  }