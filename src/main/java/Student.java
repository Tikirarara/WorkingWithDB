
public class Student {
    private final long id;
    private final String name;
    private final String lastName;
    private final int age;
    private final int cource;

    public Student(long id, String name, String lastName, int age, int cource) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cource = cource;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getCource() {
        return cource;
    }

    @Override
    public String toString() {
        return "Student: " +
                "\n id: " + id +
                "\n name: " + name +
                "\n lastName: " + lastName +
                "\n age: " + age +
                "\n cource: " + cource;
    }
}
