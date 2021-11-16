import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.scss']
})
export class ManagerListComponent implements OnInit {


  managers = [
  
      {
        id: '1',
        firsname: 'Wendy',
        lastname: 'Vandenberghe',
        session: {
          name: 'POEI JAVA',
          former: {
            name: 'yassen',
            surname: 'abarji',
          },
        },
        program: {
          title: 'programme java angular',
          description:
            'ceci est un program java fort interessant Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eleifend velit nulla, non maximus erat dictum in. Donec auctor porta dolor, eu egestas mi facilisis vitae. Maecenas in imperdiet eros. Ut nec eros neque. Phasellus dictum dolor magna, nec scelerisque nibh rhoncus non. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris eget magna a sem maximus vulputate. Proin quam massa, eleifend eu ultricies luctus, tristique in neque.',
        },
      },
  ]
  constructor() { }

  ngOnInit(): void {}

  filterManager($event: KeyboardEvent): void {
    const filter = ($event.target as HTMLTextAreaElement).value.toLowerCase();
    this.managers = this.managers.filter((manager) =>
      manager.firsname.toLowerCase().includes(filter)
    );
  }

}
