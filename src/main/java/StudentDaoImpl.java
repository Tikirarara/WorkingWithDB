import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDao{
    private DataSource dataSource;

    public StudentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Student student) {
        String sql = "insert into students (id, name, lastname, age, cource) values('" +
                student.getId()+"', '" +
                student.getName() + "', '" +
                student.getLastName() + "', '" +
                student.getAge() + "', '" +
                student.getCource() + "')";

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.prepareStatement(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public Student findByStudentId(long studentId) {
        return null;
    }
}
