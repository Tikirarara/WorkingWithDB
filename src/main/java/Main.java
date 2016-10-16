import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        final String connect = "jdbc:h2:~/test";
        final String user = "admin";
        final String password = "test";


        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection connection = DriverManager.getConnection(connect, user, password);
            createTables(connection);
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
        }

    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE Students" +
                    "(id INTEGER ," +
                    "name VARCHAR (255)," +
                    "lastname VARCHAR (255)," +
                    "age INTEGER ," +
                    "cource INTEGER ," +
                    "primary key(id)" +
                    ");");

            statement.executeUpdate("CREATE TABLE Lessons" +
                    "(id INTEGER ," +
                    "lesson_name VARCHAR (255)," +
                    "lesson_date DATE," +
                    "primary key(id)" +
                    ");");

            statement.executeUpdate("CREATE TABLE Student_visits" +
                    "(student_id INTEGER ," +
                    "lesson_id INTEGER ," +
                    "primary key(id)" +
                    ");");
        }
    }
}
