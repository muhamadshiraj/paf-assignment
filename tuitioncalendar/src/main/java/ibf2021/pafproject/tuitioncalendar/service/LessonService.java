package ibf2021.pafproject.tuitioncalendar.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2021.pafproject.tuitioncalendar.exception.UserNotFoundException;
import ibf2021.pafproject.tuitioncalendar.model.Lesson;
import ibf2021.pafproject.tuitioncalendar.repo.LessonRepo;

@Service
public class LessonService {
    private final LessonRepo lessonRepo;
    
    @Autowired
    public LessonService(LessonRepo lessonRepo, EmailSenderService emailSenderService){
        this.lessonRepo = lessonRepo;
    }
    
    public Lesson addLesson(Lesson lesson){
        lesson.setLessonId(UUID.randomUUID().toString());
        return lessonRepo.save(lesson);
    }

    public List<Lesson> findAllLessons(){
        return lessonRepo.findAll();
    }

    public Lesson updateLesson(Lesson lesson){
        return lessonRepo.save(lesson);
    }

    public Lesson findLessonById(Long id){
        return lessonRepo.findLessonById(id)
        .orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found" ));
    }

    public Lesson[] findLessonByEmail(String email){
        return lessonRepo.findLessonByEmail(email);
        // .orElseThrow(()-> new UserNotFoundException("No lessons for " + email ));
    }

    @Transactional
    public void deleteLesson(Long id){
        lessonRepo.deleteLessonById(id);
    }

    // @EventListener(ApplicationReadyEvent.class)
	// public void sendMail() {
	// 	senderService.sendEmail("muhamadshirajj@gmail.com",
	// 		"This is a test subject", "come on. faster finish the project");
	// }
}
