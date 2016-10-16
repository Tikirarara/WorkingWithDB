package dao;
import models.Lesson;

public interface LessonDao {
    public void insert(Lesson lesson);
    public Lesson findByLessonId(long lessonId);
}
