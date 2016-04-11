import java.util.*;

public class Network{
  /**
   * Creats a network connect all users and set the relationship between users
   */
  
  private ArrayList<User> users;
  private Random rand = new Random();
  
  /**
   * Constructor for the network class
   * @param: int size_of_the_network 
   * @return: Network
   */
  public Network(int size){
    users = new ArrayList<User>();
    for (int i = 0; i < size; i++){
      int version = rand.nextInt(5) + 1; //generate a random version number from integer 1 to 5
      users.add( new User(version));
    }
    for (int i = 0; i < size; i++){
      setRelation(i);
    }
  }
  
  /**
   * Determine the relationship between two users. There is 2% chance that one user 
   * is the teacher/student of another other user.
   * @param: N/A
   * @return: int
   */
  public int relationType(){
    int n = rand.nextInt(100) + 1;
    if (n <= 2){
//      teacher: 2% chance
      return 1;
    } else {
//      no relationship: 98%
      return 2;
    }
  }
  
  /**
   * Traverse through the network to set the relationship between one user and all the other users in the network. 
   * @param: int index_of_user
   * @return: void
   */
  public void setRelation(int a){
    User u = users.get(a);
    int relation = 0;
    for (int i = a + 1; i < users.size(); i++){
      relation = relationType();
      if (relation == 1){
        u.addTeacher(users.get(i));
        users.get(i).addStudent(u);
      } 
    }
  }
  
  /**
   * Return a list of all users in the network.
   * @param: N/A
   * @return: ArrayList<User> users
   */
  public ArrayList<User> getList(){
    return users;
  }
  
  /**
   * Get a random user from the network
   * @param: N/A
   * @return: User a
   */
  public User getRandom(){
    int index = rand.nextInt(users.size());
    return users.get(index);
  }
  
//  tester
  public static void main(String[] args){
    Network w = new Network(100);
    ArrayList<User> l = w.getList();
    for (int i = 0; i < l.size(); i++){
      System.out.println(l.get(i).relativeUsers());
    }
  }
  
}