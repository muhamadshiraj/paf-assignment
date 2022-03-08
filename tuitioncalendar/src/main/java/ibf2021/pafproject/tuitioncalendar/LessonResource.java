package ibf2021.pafproject.tuitioncalendar;

import java.text.ParseException;
import java.util.List;
// import java.util.logging.Logger;

// import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.pafproject.tuitioncalendar.model.Lesson;
import ibf2021.pafproject.tuitioncalendar.service.EmailSenderService;
import ibf2021.pafproject.tuitioncalendar.service.LessonService;

@RestController
@RequestMapping("/lesson")
public class LessonResource {
    
    @Autowired
	private EmailSenderService senderService;
    // private JavaMailSender mailSender;
    
        
    // private Logger logger = Logger.getLogger(LessonResource.class.getName());

    
    private final LessonService lessonService;

    public LessonResource(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lesson>> getAllLessons(){
        List<Lesson> lessons = lessonService.findAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    // @GetMapping("/get/{email}")
    // public ResponseEntity<String> getLessonByEmail(@PathVariable String email){
    //     List<Lesson> lesson = lessonService.findLessonByEmail(email);
    //     logger.info(">>>  " + lesson);
    //     Gson gson = new Gson();

    //     String result = gson.toJson(lesson);
    //     return ResponseEntity.ok(result);
    // }  

    //  @GetMapping("/find/{email}")
    // public ResponseEntity<String> getLessonByEmail(@PathVariable("email")String email){
    //     logger.info(email);
    //     // Lesson lesson = lessonService.findLessonByEmail(email);
    //     List<Lesson> lessons = lessonService.findLessonByEmail(email);
    //     Gson gson = new Gson();
    //     String result = gson.toJson(lessons);
    //     // return new ResponseEntity<>(lesson, HttpStatus.OK);
    //     return ResponseEntity.ok(result);
    // }    

    // @GetMapping("/find/{email}")
    // public ResponseEntity<Lesson> getLessonByEmail(@PathVariable("email")String email){
    //     Lesson[] lesson = lessonService.findLessonByEmail(email);

    //     return new ResponseEntity<>(lesson, HttpStatus.OK);
    // }   

    // @GetMapping("/find/{id}")
    // public ResponseEntity<Lesson> getLessonById(@PathVariable("id")Long id){
    //     Lesson lesson = lessonService.findLessonById(id);
    //     return new ResponseEntity<>(lesson, HttpStatus.OK);
    // }    
    

    // public void sendMail() {
    // 	senderService.sendEmail("muhamadshirajj@gmail.com",
    // 		"This is a test subject", "come on. faster finish the project");
    // }

    @PostMapping("/add")
    public ResponseEntity<Lesson> addLesson(@RequestBody Lesson lesson){
        Lesson newLesson = lessonService.addLesson(lesson);
        try {
            senderService.sendEmail(lesson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(newLesson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson){
        Lesson updateLesson = lessonService.addLesson(lesson);
        return new ResponseEntity<>(updateLesson, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable("id")Long id){
        lessonService.deleteLesson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
