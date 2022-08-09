package h8me.CrudSpringBoot.models;

public class Label {

    private int id;

    private String name;

    public Label() {
    }

    public Label(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
