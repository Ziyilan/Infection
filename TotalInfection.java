import java.util.*;

public class TotalInfection{
  /**
   * Perform total infection on a user network
   */
  private Network net;
  int infected = 0;
  
  public TotalInfection(int size){
    /**
     * Constructor for total infection
     * @param: int network_size
     * @return: 
     */
    net = new Network(size);
    Random rand = new Random();
    int index = rand.nextInt(size);
    User chosen = net.getList().get(index);
    bfs(chosen);
//    infect(chosen);
  }
  
  /**
   * Infect all the other users on the network connected with the input user using Depth First Search.
   * @param: User starting_point
   * @return: 
   */
  public void infect(User c){
    if (!c.isInfected()){
      c.setInfected();
      ArrayList<User> teachers = c.getTeachers();
      ArrayList<User> students = c.getStudents();
      for (int i = 0; i < teachers.size(); i++){
        infect(teachers.get(i));
      }
      for (int i = 0; i < students.size(); i++){
        infect(students.get(i));
      }
    } else {
      return;
    }
  }
  
  /**
   * Infect all the other users on the network connected with the input user using Breadth First Search.
   * @param: User starting_point
   * @return: 
   */
  public void bfs(User c){
    Queue<User> q = new LinkedList<User>();
    q.add(c);
    c.setInfected();
    while (!q.isEmpty()){
      User next = q.peek();
      ArrayList<User> adj = groupInfected(next);
      if (!adj.isEmpty()){
        for (int i = 0; i < adj.size(); i++){
          adj.get(i).setInfected();
          q.add(adj.get(i));
        }
      } else {
        q.remove();
      }
    }
  }
  
  /**
   * Return all the users connected to the current user in an arraylist
   * @param: User c
   * @return: ArrayList<User> adjacent
   */
  public ArrayList<User> groupInfected(User c){
    ArrayList<User> teachers = c.getTeachers();
    ArrayList<User> students = c.getStudents();
    ArrayList<User> unvisited  = new ArrayList<User>();
    if (!teachers.isEmpty()){
      for (int i = 0; i < teachers.size(); i++){
        if (!teachers.get(i).isInfected()){
          unvisited.add(teachers.get(i));
        }
      }
      for (int i = 0; i < students.size(); i++){
        if ((!students.get(i).isInfected()) && (!teachers.contains(students.get(i)))){
          unvisited.add(students.get(i));
        }
      }
    }
    return unvisited;
  }
  
  /**
   * Return the number of users being infected
   * @param: N/A
   * @return: int num 
   */
  public int numInfected(){
    int n = 0;
    ArrayList<User> users = net.getList();
    for (int i = 0; i < users.size(); i++){
      if (users.get(i).isInfected()){
        n++;
      }
    }
    return n;
  }
  
//  testing
  public static void main(String[] args){
    TotalInfection ti = new TotalInfection(1000);
    System.out.println(ti.numInfected());
  }
  
}