import java.util.*;

public class Post {
    String message;
    int like=0;
    ArrayList<String> comment;
    public Post(String message)
    {
        this.message=message;
        comment = new ArrayList<>();
    }

}
