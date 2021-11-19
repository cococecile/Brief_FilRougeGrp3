import { Employee } from "./employee.model";

export class Mission {
    missionId?: any;
    missionName?: string;
    missionDescription?: string;
    missionStartDate?: string;
    missionEndDate?: string;
    missionType?: string;
    missionAssignedTo?: Employee;
  }
