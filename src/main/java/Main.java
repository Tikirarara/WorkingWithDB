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
            Statement stmt = connection.createStatement();
        } catch (Exception ex) {}


    }

    private static void createTables(Connection connection) throws SQLException {
        connection.createStatement().executeUpdate("CREATE TABLE Students" +
                "(id int," +
                "name varchar(255)," +
                "lastname varchar(255)," +
                "age int," +
                "cource int," +
                "primary key(id)" +
                ");");

        connection.createStatement().executeUpdate("CREATE TABLE Lessons" +
                "(id int," +
                "lessonname varchar(255)," +
                "date varchar(255)," +
                "primary key(id)" +
                ");");

        connection.createStatement().executeUpdate("CREATE TABLE Student_visits" +
                "(student_id int," +
                "lesson_id int," +
                "primary key(id)" +
                ");");
    }
}
