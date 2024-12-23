import java.util.*;

public class Main {
    static int id = 1;
    static ArrayList<User> users = new ArrayList<>();
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. New user \n2. Login \n3. See Mutuals \n0. To exit");
            int c = sc.nextInt();
            sc.nextLine();

            if (c == 1) {
                System.out.print("Enter your name please: ");
                String name = sc.nextLine();
                User user = new User(id++, name);
                users.add(user);
                System.out.printf("this is your user id %d",id-1);
                System.out.println();
                System.out.println("Enter the id of a person you know to follow them: ");
                int fid = sc.nextInt();
                
                if (users.isEmpty() || !isUserExist(fid)) {
                    System.out.println("No users to follow or invalid user ID.");
                } else {
                    for (User use : users) {
                        if (use.id == fid) {
                            Follow f1 = new Follow(user.id, user.name);
                            Follow f2 = new Follow(fid, use.name);
                            use.follower.add(f1);
                            user.follower.add(f2);
                            System.out.println(user.name + " is now following " + use.name);
                        }
                    }
                }
            
            }
            else if(c==2)
            {
                System.out.print("Enter your user id");
                int uid=sc.nextInt();
                if (users.isEmpty() || !isUserExist(uid)) {
                    System.out.println("No such id exists");
                }
                else{
                    System.out.print("1. Post something \n 2. view posts");
                    int option=sc.nextInt();
                    Operations op=new Operations();
                    if(option==1)
                    {
                        for (User use : users) {
                            if (use.id == uid) {
                        op.postnewpost(use);
                            }
                        }
                    } 
                    else if(option==2)
                    {
                        for (User use : users) {
                            if (use.id == uid) {
                        op.showfeed(use);
                            }
                        }
                    }
                }
            } 
            else if (c == 3) {
                System.out.print("Enter your user Id: ");
                int uid = sc.nextInt();
                System.out.println("Enter the person's id to see their mutuals: ");
                int fid = sc.nextInt();
                
                Operations op = new Operations();
                User use1 = op.finduserbyid(uid);
                User use2 = op.finduserbyid(fid);

                if (use1 == null || use2 == null) {
                    System.out.println("One or both users not found.");
                } else {
                    ArrayList<String> mutuals = op.mutuals(use1, use2);
                    if (mutuals.isEmpty()) {
                        System.out.println("No mutuals found.");
                    } else {
                        System.out.println("Mutual followers:");
                        for (String mutual : mutuals) {
                            System.out.println(mutual);
                        }
                    }
                }
            } else if (c == 0) {
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static boolean isUserExist(int id) {
        for (User user : users) {
            if (user.id == id) {
                return true;
            }
        }
        return false;
    }
}
