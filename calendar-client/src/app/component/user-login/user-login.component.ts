import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { GoogleLoginProvider, SocialAuthService } from 'angularx-social-login';
// import { GoogleSigninService } from 'src/app/google-signin.service';
// import { GoogleUser } from 'src/app/GoogleUser';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  // user!: gapi.auth2.GoogleUser

  constructor(
    private router: Router,
    private fb: FormBuilder,
    // private signInService: GoogleSigninService,
    // private ref: ChangeDetectorRef,
    private socialAuthService: SocialAuthService) {
    }

  ngOnInit(): void {
  }

  loginWithGoogle(){
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID)
      .then(() => this.router.navigate(['/calendar']));
  }

  // signIn() {
  //   this.signInService.signin()
  //   .then(() => this.router.navigate(['calendar']));
  // }

  // signOut(){
  //   this.signInService.signout()
  // }
  navigateToCalendar(){
    this.router.navigate(['/calendar'])
  }
}
