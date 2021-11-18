import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Mission } from 'src/app/model/mission.model';
import { MissionService } from 'src/app/services/mission.service';

@Component({
  selector: 'app-mission-list',
  templateUrl: './mission-list.component.html',
  styleUrls: ['./mission-list.component.scss']
})
export class MissionListComponent implements OnInit {

  mission: [];
  selected?: Mission;
  missionName?: string;
  missionDescription?: string;
  missionStartDate?: '';
  missionEndDate?: '';
  missionType?: '';
  missionAssignedTo?: '';
  currentMission: any;
  currentIndex: number;


  constructor(private missionService: MissionService) { }

  ngOnInit(): void {
    this.retrieveEmployees();
  }

  retrieveEmployees(): void {
   this.missionService.getAll()
   .subscribe(
     data => {
       this.mission = data;
       console.log(data);
     },
     error => {
       console.log(error);
     });
  }

  refreshList(): void {
    this.refreshList();
    this.currentMission = null;
    this.currentIndex = -1;
  }

  setActiveEmployee(mission,index): void {
    this.currentMission = mission;
    this.currentIndex = index;
  }

  delete(): void {
    if (!this.selected) {
      return;
    }
  }

}
