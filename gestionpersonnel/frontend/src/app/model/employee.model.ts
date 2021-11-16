import { Manager } from "./manager.model";

export class Employee {

	employeeId?: any;
    employeeFirstname?: string;
    employeeLastname?: string;
    employeeEmail?: string;
    employeeStatus?: string;
	employeeManager?: Manager;
    //employeeDepartement?: Departement;
    //employeeMission?: Mission;
  }