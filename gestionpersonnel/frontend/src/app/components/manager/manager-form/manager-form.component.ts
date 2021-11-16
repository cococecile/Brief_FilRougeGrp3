import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-manager-form',
  templateUrl: './manager-form.component.html',
  styleUrls: ['./manager-form.component.scss']
})
export class ManagerFormComponent implements OnInit {

  validateForm!: FormGroup;

  submitForm(): void {
    console.log('submit', this.validateForm);
    console.log(this.validateForm.value);
    if (this.validateForm.valid) {
      console.log('form valid');
    } else {
      Object.values(this.validateForm.controls).forEach((control) => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      firsname: [null, [Validators.required]],
      lastname: [null, [Validators.required]],
      ail: [null, [Validators.required]],
    });
  }
}
