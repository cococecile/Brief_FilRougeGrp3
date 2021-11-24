import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Mission } from 'src/app/model/mission.model';
import { MissionService } from 'src/app/services/mission.service';

@Component({
  selector: 'app-mission-list',
  templateUrl: './mission-list.component.html',
  styleUrls: ['./mission-list.component.scss']
})
export class MissionListComponent implements OnInit {

  missions: [];

  missionId: any;
  selected?: Mission;
  missionName?: string;
  missionDescription?: string;
  missionStartDate?: '';
  missionEndDate?: '';
  missionType?: '';
  missionAssignedTo?: '';

  constructor(private missionService: MissionService,
    private router: Router) { }

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

  // refreshList(): void {
  //   this.refreshList();
  //   this.currentMission = null;
  //   this.currentIndex = -1;
  // }

  // setActiveEmployee(mission,index): void {
  //   this.currentMission = mission;
  //   this.currentIndex = index;
  // }

  delete(): void {
    if (!this.selected) {
      return;
    }
  }
  // fonction récupération object mission pour afficher détails //
  recupObject(mission: Mission) {
    this.router.navigate(['/mission-detail', mission]);
  }

}
