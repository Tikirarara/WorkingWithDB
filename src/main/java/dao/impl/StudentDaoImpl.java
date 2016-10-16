package dao.impl;

import dao.StudentDao;
import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insert(Student student) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement studentStatement = connection.prepareStatement("" +
                    "insert into Students (id, name, lastname, age, course) values(?, ?, ?, ?, ?)");

            studentStatement.setLong(1, student.getId());
            studentStatement.setString(2, student.getName());
            studentStatement.setString(3, student.getLastName());
            studentStatement.setInt(4, student.getAge());
            studentStatement.setInt(5, student.getCource());
            studentStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
            throw new RuntimeException();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }

    public Student findByStudentId(long studentId) {
        return getOne(execute("select * from Student where id = ?", st -> st.setLong(1, studentId)));
    }

    public List<Student> findByStudentName(String studentName) {
        return execute("select * from Student where name = ?", st -> st.setString(1, studentName));
    }

    private List<Student> execute(String sql, Consumer<PreparedStatement> consumer) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            consumer.accept(statement);
            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String studentName = resultSet.getString("name");
                String studentLastname = resultSet.getString("lastname");
                int studentAge = resultSet.getInt("age");
                int studentCource = resultSet.getInt("cource");
                students.add(new Student(id, studentName, studentLastname, studentAge, studentCource));
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Student getOne(List<Student> students) {
        return students.isEmpty() ? null : students.get(0);
    }

    private interface Consumer<T> {
        void accept(T t) throws Exception;
    }
}
