package h8me.CrudSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

public class Writer {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts = new ArrayList<>();
}
