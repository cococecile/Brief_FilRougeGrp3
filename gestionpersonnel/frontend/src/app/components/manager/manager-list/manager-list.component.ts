import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Manager } from 'src/app/model/manager.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.scss']
})
export class ManagerListComponent implements OnInit {

  managers?:Manager[];
  selected?: ManagerListComponent;
  currentIndex: number = -1;

  id: any;
  managerFirstName: string ='';
  managerLastName: string ='';
  managerMail: string ='';
  managerMission: string ="";
  managerDepartement : string ='';

  // managers = [
  
  //     {
  //       id: "",
  //       firsname: '',
  //       lastname: '',
  //       departement: {
  //         name: '',
  //         mission: {
  //           name: '',
  //         },
  //       },
        
  //     },
  // ]
  

  constructor(private managerService: ManagerService, private route: ActivatedRoute) { 
  }

  ngOnInit(): void {  
    this.route.queryParams
    .subscribe(params => {
      this.getAllManagers()
      }
     );}
  getAllManagers():  void  {
    this.managerService.list()
    .subscribe(
      data => {
        this.managers = data;
      },
      error => {
        console.error(error);
      });
  }
  delete(): void {
    if (!this.selected) {
      return;
    }
  }
}
