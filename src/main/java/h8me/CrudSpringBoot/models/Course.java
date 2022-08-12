package h8me.CrudSpringBoot.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "поле Курс не должно быть пустым")
    @Size(min = 2, max = 100, message = "поле Курс не должно быть не менее 2х символов и не более 100")
    @Column(name = "corse")
    private String corse;

    public Course() {

    }
    public Course(String corse) {
        this.corse = corse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorse() {
        return corse;
    }

    public void setCorse(String corse) {
        this.corse = corse;
    }
}
