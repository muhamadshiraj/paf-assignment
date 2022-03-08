package ibf2021.pafproject.tuitioncalendar.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import static ibf2021.pafproject.tuitioncalendar.constants.SQL.*;

import ibf2021.pafproject.tuitioncalendar.model.Lesson;

@Repository
public class LessonByEmail {
   
	@Autowired
    private static JdbcTemplate template;

    
    public static List<Lesson> getLessonByEmail(String email) {
        final List<Lesson> lessonList = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(
            SQL_GET_GAMES_BY_EMAIL, email);

        // loop thru row set 
        while (rs.next()) {
            // Process a row
            final Lesson lesson = Lesson.populate(rs);
            lessonList.add(lesson);
        }
        return lessonList;
    }

}
