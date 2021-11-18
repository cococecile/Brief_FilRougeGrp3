import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/model/department.model';
import { Employee } from 'src/app/model/employee.model';
import { Mission } from 'src/app/model/mission.model';
import { MissionService } from 'src/app/services/mission.service';
import { MissionListComponent } from '../mission-list/mission-list.component';

@Component({
  selector: 'app-mission-detail',
  templateUrl: './mission-detail.component.html',
  styleUrls: ['./mission-detail.component.scss']
})
export class MissionDetailComponent implements OnInit {

   
  mission:Mission[];
  selected?: MissionListComponent;
  currentIndex: number = -1;

  missionId: any;
  missionName: string;
  employeeLastName: string;
  missionStartDate: string;
  missionEndDate: string;
	missionDescription: string;
  missionAssignedTo: Employee;
  mmissionIssuedBy: Department;

  constructor(private missionService: MissionService, 
    private route: ActivatedRoute,
    private router: Router) {
    }
  ngOnInit(): void {
  
  }

}
