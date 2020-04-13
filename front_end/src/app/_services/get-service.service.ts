import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Email } from './__model/email';

@Injectable({
  providedIn: 'root'
})
export class GetServiceService {
  public url = environment.core_url + '/mail';

  constructor(private http: HttpClient) { }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getMail(): Observable<Email> {
    return this.http.get<Email>(
      this.url + '/get_all_mails')
      .pipe(
        retry(1),
        catchError(this.errorHandl)
        );
  }

  sendMail(data: Email): Observable<Email> {
    return this.http.post<Email>(
      this.url + '/send_mail', JSON.stringify(data), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

  errorHandl(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
 }
}
