package dao.impl;

import dao.StudentDao;
import models.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insert(Student student) {
        String sql = "insert into students (id, name, lastname, age, cource) values('" +
                student.getId()+"', '" +
                student.getName() + "', '" +
                student.getLastName() + "', '" +
                student.getAge() + "', '" +
                student.getCource() + "')";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public Student findByStudentId(long studentId) {
        return null;
    }
}
