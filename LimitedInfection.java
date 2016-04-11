import java.util.*;

public class LimitedInfection{
  /**
   * The class that performs limited infection on a network
   */
  
  private int target;
  private User start;
  
  public LimitedInfection(User c, int target){
    /**
     * Constructor
     * @param: User c starting point of the infection; int target: target number of infection
     * @return: 
     */
    this.target = target;
    this.start = start;
  }
  
  public int Infect(User start){
    /**
     * Starting from a paticular user, this method uses Breadth First Search to infect other users layer-by-layer.
     * The counted will update every time all the adjacent users of the current user-group are infected. When the counter 
     * is larger or equal to the target value, it returns the counter number.
     * @param: User starting_point
     * @return: int counter
     */
    int progress = 1;
    int preprogress = 0;
    HashSet<User> currentGen = new HashSet<User>();
    currentGen.add(start);
    while( progress <= target || preprogress >= progress){
      ArrayList<User> temp = new ArrayList<User>(currentGen);
      currentGen.clear();
      for (int i = 0; i < temp.size(); i++){
        currentGen.addAll(temp.get(i).getTeachers());
        currentGen.addAll(temp.get(i).getStudents());
      }
      preprogress = progress;
      progress += currentGen.size();
    }
    return progress;
  }
  
//  testing
  public static void main(String[] args){
    Network nw = new Network(100);
    User start = nw.getRandom();
    LimitedInfection li1 = new LimitedInfection(start,20);
    LimitedInfection li2 = new LimitedInfection(start,30);
    LimitedInfection li3 = new LimitedInfection(start,50);
    System.out.println("Input target infections: 20    Actual infections: " + li1.Infect(start));
    System.out.println("Input target infections: 30    Actual infections: " + li2.Infect(start));
    System.out.println("Input target infections: 50    Actual infections: " + li2.Infect(start));
  }
}