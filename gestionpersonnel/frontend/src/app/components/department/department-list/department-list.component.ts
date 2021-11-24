import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/model/department.model';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.scss']
})
export class DepartmentListComponent implements OnInit {

  departments: [];

  constructor(private departmentService: DepartmentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.retrieveDepartments();
  }

  retrieveDepartments(): void {
    this.departmentService.getAll()
      .subscribe(
        data => {
          this.departments = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  
  delete(): void {

    }

  // fonction récupération object department pour afficher détails //
  recupObject(department: Department) {
    this.router.navigate(['/department-detail', Department]);
  }

}


