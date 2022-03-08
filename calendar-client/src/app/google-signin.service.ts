import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, ReplaySubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GoogleSigninService {

  private auth2!: gapi.auth2.GoogleAuth
  private subject = new ReplaySubject<gapi.auth2.GoogleUser>(1)

  constructor( private router: Router) {
    gapi.load('auth2', () => {
      this.auth2 = gapi.auth2.init({
        client_id: '418020914422-q9nrklmvi2ak8c65vt7r7dv5gdgenkmv.apps.googleusercontent.com'
      })
    })
  }

  public signin(){
    this.auth2.signIn({

      scope: 'https://www.googleapis.com/auth/calendar.events'
    }).then( user => {
      this.subject.next(user);
      this.router.navigate(['calendar'])
    }).catch(()=>{
      this.subject.next(null!)
    })
  }

  public signout(){
    this.auth2.signOut()
      .then(()=> {

      })
  }

  public observable(): Observable<gapi.auth2.GoogleUser>{
    return this.subject.asObservable()
  }
}
