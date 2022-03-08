import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { Lesson } from 'src/app/lesson';
import { LessonService } from 'src/app/lesson.service';
import { SocialAuthService } from 'angularx-social-login';

@Component({
  selector: 'app-add-lesson',
  templateUrl: './add-lesson.component.html',
  styleUrls: ['./add-lesson.component.css']
})
export class AddLessonComponent implements OnInit {

  lessons: Lesson[] = [];
  subscription!: Subscription;
  form!: FormGroup;

  constructor(private fb: FormBuilder, private lessonService: LessonService,
    private router: Router, public socialAuthService: SocialAuthService) { }

  ngOnInit(): void {
  }

  public getLessons(): void {
    document.getElementById('add-lesson-form')?.click();
    this.subscription = this.lessonService.getLessons().subscribe({
      next: (response: Lesson[]) => {
        this.lessons = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    }
    )
  }

  public onAddLesson(addForm: NgForm): void {
    document.getElementById('add-lesson-form')?.click();
    this.lessonService.addLesson(addForm.value).subscribe({
      next: (response: Lesson) => {
        console.log(response);
        this.getLessons();
        addForm.reset();
        this.router.navigate(['/calendar'])
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    });
  }
}
