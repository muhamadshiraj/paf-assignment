package ibf2021.pafproject.tuitioncalendar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.jdbc.support.rowset.SqlRowSet;

@Entity
public class Lesson implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String level;
    private String subject;
    private Date date;
    private int duration;
    private String email;
    @Column(nullable = false, updatable = false)
    private String lessonId;
    
    public Lesson() {
    }
    
    public Lesson(Long id, String name, String level, String subject, Date date, int duration, String lessonId, String email) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.subject = subject;
        this.date = date;
        this.duration = duration;
        this.lessonId = lessonId;
        this.email = email;
    }
    
    public static Lesson populate(SqlRowSet rs) {
        final Lesson lesson = new Lesson();
        lesson.setName(rs.getString("name"));
        lesson.setLevel(rs.getString("level"));
        lesson.setSubject(rs.getString("subject"));
        lesson.setDate(rs.getDate("date"));
        lesson.setDuration(rs.getInt("duration"));
        return lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Lesson [date=" + date + ", duration=" + duration + ", email=" + email + ", id=" + id + ", lessonId="
                + lessonId + ", level=" + level + ", name=" + name + ", subject=" + subject + "]";
    }



}

 