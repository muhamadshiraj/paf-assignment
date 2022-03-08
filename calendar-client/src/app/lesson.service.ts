import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lesson } from './lesson';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class LessonService {


  constructor(private http: HttpClient) { }

  public getLessons(): Observable<Lesson[]>{
    return this.http.get<Lesson[]>(`/lesson/all`);
  }

  // public getLessons(email: string): Observable<Lesson[]>{
  //   return this.http.get<Lesson[]>(`${this.serverUrl}/find/${email}`);
  // }

  public addLesson(lesson: Lesson): Observable<Lesson>{
    return this.http.post<Lesson>(`/lesson/add`, lesson);
  }

  public updateLesson(lesson: Lesson): Observable<Lesson>{
    return this.http.put<Lesson>(`/lesson/update`, lesson);
  }

  public deleteLesson(id: number): Observable<void>{
    return this.http.delete<void>(`/lesson/delete/${id}`);
  }
}
