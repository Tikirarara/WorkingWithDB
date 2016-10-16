package dao;

import models.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student student);
    public Student findByStudentId(long studentId);
    public List<Student> findByStudentName(String studentName);
}
