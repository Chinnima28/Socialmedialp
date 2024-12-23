import java.util.*;

public class User {
    int id;
    String name;
    ArrayList<Follow> follower;
    ArrayList<Post> posts;
    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
        follower = new ArrayList<>();
        posts=new ArrayList<>();
    }
    
}
