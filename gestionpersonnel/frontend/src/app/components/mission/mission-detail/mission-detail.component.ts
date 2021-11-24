import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/model/department.model';
import { Employee } from 'src/app/model/employee.model';
import { Manager } from 'src/app/model/manager.model';
import { Mission } from 'src/app/model/mission.model';
import { MissionService } from 'src/app/services/mission.service';
import { MissionListComponent } from '../mission-list/mission-list.component';

@Component({
  selector: 'app-mission-detail',
  templateUrl: './mission-detail.component.html',
  styleUrls: ['./mission-detail.component.scss']
})
export class MissionDetailComponent implements OnInit {

   
  selected?: Mission;
  currentManager=null;
  currentIndex: number = -1;
 
  missions:[];
  missionName: string;
  missionStartDate: string;
  missionEndDate: string;
	missionDescription: string;
  missionAssignedTo: Employee;
  missionIssuedBy: Department;

  departmentId: any;
  departmentName: string;

  employeeFirstName: string;
  employeeLastName: string;


  constructor(private missionService: MissionService, 
    private route: ActivatedRoute,
    private router: Router) {
    }

  ngOnInit(): void {

    this.retrieveMissions();


      }
    
    retrieveMissions(): void {
       this.missionService.getAll()
       .subscribe(
         data => {
           this.missions = data;
           console.log(data);
         },
         error => {
           console.log(error);
         });
      }
    
      refreshList(): void {
        this.refreshList();
        // this.currentMission = null;
        this.currentIndex = -1;
      }
    
      setActiveMission(mission,index): void {
        // this.currentMission = mission
        this.currentIndex = index;
      }
    
      delete(id:number): void {
        if (!this.selected) {
          return;
          // recup id du service
          // refreshList
        }
  }

}
