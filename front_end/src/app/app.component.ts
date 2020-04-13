import { Component } from '@angular/core';
// import { GetBackEndService } from './_services/get_back_end.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})

export class AppComponent {
  title = 'App';

  constructor(
    // private getBackEndService: GetBackEndService,
  ) { }

  emailForm = new FormGroup({
    subject: new FormControl(''),
    adress: new FormControl(''),
    body: new FormControl(''),
  });

  // getBackEnd() {
  //   console.log(this.getBackEndService.getMessage());
  // }

}
