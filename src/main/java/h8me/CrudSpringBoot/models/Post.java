package h8me.CrudSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts = new ArrayList<>();
}
