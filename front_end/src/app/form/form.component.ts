import { Component, OnInit, NgZone} from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { GetServiceService } from '../_services/get-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  constructor(
    public fb: FormBuilder,
    private getService: GetServiceService,
    private ngZone: NgZone,
    private router: Router ) { }
  emailList: any = [];

  emailForm = new FormGroup({
    subject: new FormControl(''),
    address: new FormControl(''),
    body: new FormControl(''),
  });

  ngOnInit(): void {
    this.getEmailsList();
  }

  // addMail() {
  //   this.emailForm = this.fb.group({
  //     issue_name: [''],
  //     issue_message: ['']
  //   });
  // }

  getEmailsList() {
    return this.getService.getMail().subscribe((data: {}) => {
      this.emailList = data;
    });
  }


  onSubmit() {
    console.log('\nCHEGUEI NO SUBMIT');
    this.getService.sendMail(this.emailForm.value).subscribe(item => {
      console.log('Sent mail!');
      this.ngZone.run(() => this.router.navigateByUrl('/mails-list'));
    });
  }
}
