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
  selected?: Manager;
  currentManager =null;
  currentIndex: number = -1;
  managerFirstName = '';
  managerLastName ='';

  
  constructor(private managerService: ManagerService, private route: ActivatedRoute) { 
  }

  ngOnInit(): void {  
    this.retrieveManagers()
      }
    
  retrieveManagers(): void {
    this.managerService.getAll()
    .subscribe(
      data => {
        this.managers = data;
        console.log(data);
      },
      erreur => {
        console.log(erreur);
      });
   }
 
   refreshList(): void {
     this.refreshList();
     this.currentManager = null;
     this.currentIndex = -1;
   }
 
   setActivemanager(manager,index): void {
     this.currentManager = manager;
     this.currentIndex = index;
   }
 
   delete(): void {
     if (!this.selected) {
       return;
     }
 }
 
 }
