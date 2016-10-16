package dao;
import models.Lesson;

import java.util.List;

public interface LessonDao {
    public void insert(Lesson lesson);
    public Lesson findByLessonId(long lessonId);
    public List<Lesson> findByLessonName(String lessonName);
}
