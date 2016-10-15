import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson {
    private final long id;
    private final String lessonName;
    private final Date date;

    public Lesson(long id, String lessonName, String date) throws ParseException {
        this.id = id;
        this.lessonName = lessonName;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        this.date = sdf.parse(date);
    }

    public long getId() {
        return id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Lesson: " +
                "\n id: " + id +
                "\n lessonName: " + lessonName +
                "\n date: " + date;
    }
}
