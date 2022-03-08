package ibf2021.pafproject.tuitioncalendar.service;

import java.text.ParseException;
// import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2021.pafproject.tuitioncalendar.model.Lesson;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    
    // private Logger logger = Logger.getLogger(EmailSenderService.class.getName());

    public void sendEmail(Lesson lesson) throws ParseException{
       
      
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("educatedfool90@hotmail.com");
        message.setTo(lesson.getEmail());
        message.setText("New tuition has been scheduled with " 
            + lesson.getName() + " on " + 
            lesson.getDate());
        message.setSubject("Tuition Scheduler App Notification");

        mailSender.send(message);

        System.out.println("Email sent successfully");
    }
}
