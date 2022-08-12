package h8me.CrudSpringBoot.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Course")
public class Lesson {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "поле Курс не должно быть пустым")
    @Size(min = 2, max = 100, message = "поле Курс не должно быть не менее 2х символов и не более 100")
    @Column(name = "course")
    private String lesson;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Lesson() {

    }

    public Lesson(String lesson) {
        this.lesson = lesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
