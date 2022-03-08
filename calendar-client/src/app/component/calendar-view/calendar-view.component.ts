import { HttpErrorResponse } from '@angular/common/http';
import { ChangeDetectorRef, Component, Inject, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Calendar } from '@syncfusion/ej2-angular-calendars';
import { SocialAuthService } from 'angularx-social-login';

import { Subscription } from 'rxjs';
// import { GoogleSigninService } from 'src/app/google-signin.service';
import { Lesson } from 'src/app/lesson';
import { LessonService } from 'src/app/lesson.service';

@Component({
  selector: 'app-calendar-view',
  templateUrl: './calendar-view.component.html',
  styleUrls: ['./calendar-view.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CalendarViewComponent implements OnInit {

  lessons!: Lesson[];
  selected?: Date | null;
  editLesson?: Lesson;
  deleteLesson?: Lesson| null;
  form!: FormGroup;
  subscription!: Subscription;
  // user!: gapi.auth2.GoogleUser

  constructor(
    private lessonService: LessonService,
    private router: Router,
    public socialAuthService: SocialAuthService,
    // private signInService: GoogleSigninService,
    // private ref: ChangeDetectorRef
    ) { }

  onValueChange(args:any):void{
    (<HTMLInputElement>document.getElementById('selected')).textContent = 'Selected Value: ' + args.value.toLocaleDateString();
  }


  ngOnInit(): void {
    this.getLessons();
    // this.signInService.observable().subscribe(user => {
    //   user.reloadAuthResponse().then( refreshed => {
    //   })

    //   this.user = user
    //   this.ref.detectChanges()
    // })
  }

  public getLessons(): void {
    // console.log(this.user.getAuthResponse().expires_at)
    // console.log(this.user.getBasicProfile().getName())
    this.lessonService.getLessons().subscribe(
      {
        next: (response: Lesson[]) => {
          this.lessons = response;
          console.log(this.lessons)
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  logout(){
    this.socialAuthService.signOut()
      .then(() => this.router.navigate(['/login']));
  }

  // signOutGoogle(){
  //   this.signInService.signout()
  //   this.router.navigate(['/login'])
  // }

  navigateToAdd(){
    this.router.navigate(['/add'])
  }

  public onUpdateLesson(lesson: Lesson): void {
    this.lessonService.updateLesson(lesson).subscribe({
      next: (response: Lesson) => {
        console.log(response);
        this.getLessons();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }


  public onDeleteLesson(id: number): void {
   this.lessonService.deleteLesson(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getLessons();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
    this.router.navigate(['/calendar']);
  }

  public searchLessons(key: string): void {
    const results: Lesson[] = [];
    for (const lesson of this.lessons){
      if (lesson.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || lesson.level.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || lesson.subject.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(lesson)
      }
    }
    this.lessons = results;
    if (results.length ===0 || !key) {
      this.getLessons();
    }
  }

  public onOpenModal(lesson: Lesson, mode: string): void {
    const container = document.getElementById('main-container')
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal')
    if (mode === 'add') {
      button.setAttribute('data-target', '#addLessonModal')
    }
    if (mode === 'edit') {
      this.editLesson = lesson;
      button.setAttribute('data-target', '#updateLessonModal')
    }
    if (mode === 'delete') {
      this.deleteLesson = lesson;
      button.setAttribute('data-target', '#deleteLessonModal')
    }
    container?.appendChild(button);
    button.click();
  }

}

