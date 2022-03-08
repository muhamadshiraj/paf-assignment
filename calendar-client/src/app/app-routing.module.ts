import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './component/user-login/user-login.component';
import { AddLessonComponent } from './component/add-lesson/add-lesson.component';
import { CalendarViewComponent } from './component/calendar-view/calendar-view.component';
import { AuthGuardService } from './auth-guard.service';

const appRoutes: Routes = [
  { path: '', component:UserLoginComponent },
  { path: 'add', component:AddLessonComponent },
  { path: 'calendar', component:CalendarViewComponent, canActivate:
    [AuthGuardService] },
  { path: '**', redirectTo: '/', pathMatch:'full' }
  ]


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
