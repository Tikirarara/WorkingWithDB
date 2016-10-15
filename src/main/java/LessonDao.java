public interface LessonDao {
    public void insert(Lesson lesson);
    public Student findByLessonId(long lessonId);
}
