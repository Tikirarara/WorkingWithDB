package dao.impl;

import dao.LessonDao;
import models.Lesson;

import java.sql.*;

import java.sql.Date;
import java.util.*;

public class LessonDaoImpl implements LessonDao {
    private Connection connection;

    public LessonDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void insert(Lesson lesson) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement studentStatement = connection.prepareStatement("" +
                    "insert into Lessons (id, lesson_name, lesson_date) values(?, ?, ?)");

            studentStatement.setLong(1, lesson.getId());
            studentStatement.setString(2, lesson.getLessonName());
            studentStatement.setDate(3, (Date) lesson.getDate());
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

    public Lesson findByLessonId(long lessonId) {
        return getOne(execute("select * from Lessons where id = ?", st -> st.setLong(1, lessonId)));
    }

    public List<Lesson> findByLessonName(String lessonName) {
        return execute("select * from Lessons where name = ?", st -> st.setString(1, lessonName));
    }

    private List<Lesson> execute(String sql, Consumer<PreparedStatement> consumer) {
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            consumer.accept(statement);
            ResultSet resultSet = statement.executeQuery();

            List<Lesson> lessons = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String lessonName = resultSet.getString("lessonName");
                Date lessonDate = resultSet.getDate("date");
                lessons.add(new Lesson(id, lessonName, lessonDate.toString()));
            }
            return lessons;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Lesson getOne(List<Lesson> lessons) {
        return lessons.isEmpty() ? null : lessons.get(0);
    }

    private interface Consumer<T> {
        void accept(T t) throws Exception;
    }
}
