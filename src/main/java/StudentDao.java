public interface StudentDao {
    public void insert(Student student);
    public Student findByStudentId(long studentId);
}
