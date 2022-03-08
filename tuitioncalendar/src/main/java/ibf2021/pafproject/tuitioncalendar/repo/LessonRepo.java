package ibf2021.pafproject.tuitioncalendar.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ibf2021.pafproject.tuitioncalendar.model.Lesson;

public interface LessonRepo extends JpaRepository<Lesson, Long>  {

    

    void deleteLessonById(Long id);

    Optional<Lesson> findLessonById(Long id);


    Optional<List<Lesson>> findAllByEmail(String email);

    Lesson[] findLessonByEmail(String email);

    // public static List<Lesson> getLessonByEmail(String email) {
    //     final List<Lesson> lessonList = new LinkedList<>();

    //     final SqlRowSet rs = template.queryForRowSet(
    //         SQL_GET_GAMES_BY_EMAIL, email);

    //     // loop thru row set 
    //     while (rs.next()) {
    //         // Process a row
    //         final Lesson lesson = Lesson.populate(rs);
    //         wishlist.add(lesson);
    //     }
    //     return lessonList;
    // }

    
}
