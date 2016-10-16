package dao;

import models.Student;

public interface StudentDao {
    public void insert(Student student);
    public Student findByStudentId(long studentId);
}
