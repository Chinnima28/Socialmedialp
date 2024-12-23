import java.util.*;

public class Operations  {
    public User finduserbyid(int id)
    {
        for(User use : Main.users)
        {
            if(use.id==id)
            return use;
        }
        return null;
    }
    public void postnewpost(User user)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the message you want to post");
        String msg=sc.nextLine();
        Post post=new Post(msg);
        user.posts.add(post);
    }
    public void showfeed(User user)
    {
        Scanner sc=new Scanner(System.in);
        if(!user.follower.isEmpty())
        {
        for(Follow fol : user.follower)
        {
            int uid=fol.id;
            for (User use : Main.users) {
                if (use.id == uid) {
                    if(use.posts.size()!=0)
                    {
                        for(Post post:use.posts)
                        {
                            System.out.println(post.message);
                            System.out.println("To like on this post enter 1 \n To comment on this post enter 2");
                            int choice=sc.nextInt();
                            if(choice==1)
                            {
                                post.like+=1;
                            }
                            else if(choice==2)
                            {
                                System.out.println("Enter your comment");
                                String msg=sc.nextLine();
                                post.comment.add(msg);
                            }
                        }
                    }
                }
            }
        }
    }
    else{
        if (Main.users.isEmpty()) {
            System.out.println("No feed to show");
        }
        else
        {
            for (User use : Main.users) {
                if(!use.posts.isEmpty())
                    {
                        for(Post post:use.posts)
                        {
                            System.out.println(post.message);
                            System.out.println("To like on this post enter 1 \n To comment on this post enter 2");
                            int choice=sc.nextInt();
                            if(choice==1)
                            {
                                post.like+=1;
                            }
                            else if(choice==2)
                            {
                                System.out.println("Enter your comment");
                                String msg=sc.nextLine();
                                post.comment.add(msg);
                            }
                        }
                    }
            }
        }
    }
    }
    public ArrayList<String> mutuals(User use1, User use2)
    {
        ArrayList<String> names = new ArrayList<>();
        if(use1 != null && use2 != null)
        {
            for(Follow f1 : use1.follower)
            {
                for(Follow f2 : use2.follower)
                {
                    if(f1.getid() == f2.getid())
                    {
                        names.add(f1.getname());
                    }
                }
            }
        }
        return names;
    }
}
