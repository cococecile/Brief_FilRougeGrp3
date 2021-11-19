import { HttpResponse } from '@angular/common/http';
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

  managerId:any;
  managerFirstName = '';
  managerLastName ='';

  
  

  
  constructor(private managerService: ManagerService) { 

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
 
  //  delete(managerId:any): void {
  //    if (!this.selected) {
  //      return;
  //    }
     
  //  getManagers():  void {
  //     this.managerService.findAll().subscribe((res: HttpResponse<Manager[]>) => {
  //       this.managers = res.body;
  //       this.managersOriginal = this.managers;
  //     });
  //   }
    // delete(managerId: any): void {
    //   this.managerService.delete(managerId).subscribe((res: HttpResponse<any>) => {
    //     console.log(res.status);
    //     if (res.status === 200) {
    //       this.getManagers();
    //     }
    //   });
  
  //}
}
