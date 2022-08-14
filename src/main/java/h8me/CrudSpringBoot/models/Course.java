package h8me.CrudSpringBoot.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "поле Курс не должно быть пустым")
    @Size(min = 2, max = 100, message = "поле Курс не должно быть не менее 2х символов и не более 100")
    @Column(name = "course")
    private String lesson;

    @NotEmpty(message = "поле Преподаватель не должно быть пустым")
    @Size(min = 2, max = 100, message = "поле Преподаватель не должно быть не менее 2х символов и не более 100")
    @Column(name = "teacher")
    private String teacher;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {

    }

    public Course(String lesson, String teacher) {
        this.lesson = lesson;
        this.teacher = teacher;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static void main(String[] args) {

    }
}
