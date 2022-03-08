import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CalendarModule,DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns'
import { AppComponent } from './app.component';
import { AddLessonComponent } from './component/add-lesson/add-lesson.component';
import { UserLoginComponent } from './component/user-login/user-login.component';
import { CalendarViewComponent } from './component/calendar-view/calendar-view.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LessonService } from './lesson.service';
import { GoogleLoginProvider, SocialLoginModule } from 'angularx-social-login';
import { ScheduleModule, RecurrenceEditorModule, DayService, WeekService,
        MonthService, MonthAgendaService, WorkWeekService,
        ScheduleAllModule } from '@syncfusion/ej2-angular-schedule';


@NgModule({
  declarations: [
    AppComponent,
    AddLessonComponent,
    UserLoginComponent,
    CalendarViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, ReactiveFormsModule,
    CalendarModule, ScheduleModule,
    RecurrenceEditorModule, ScheduleAllModule,
    SocialLoginModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
  ],

  providers: [LessonService,DayService, WeekService, WorkWeekService, MonthService, MonthAgendaService, {
    provide: 'SocialAuthServiceConfig',
    useValue: {
      autoLogin: true,
      providers: [
        {
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider('418020914422-q9nrklmvi2ak8c65vt7r7dv5gdgenkmv.apps.googleusercontent.com')
        }
      ]
    }
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
