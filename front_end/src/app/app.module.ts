import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { GetServiceService } from './_services/get-service.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GetServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
