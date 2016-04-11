import java.util.*;

public class ExactInfection{
    /**
   * Perform exact infection over the network.
   */
  
  private int target;
  private Network nw;
  private HashSet<User> infected;
  
  public ExactInfection(int target){
      /**
   * Constructor for the class
   * @param: int target_infection_number
   * @return: 
   */
    this.target = target;
    nw = new Network(100);
    infected = new HashSet<User>();
  }
  
  public int Infect(int progress){
   /**
     * Similiar to the limited infection, this algorithm starts from a starting point and performs BFS to infect all the 
     * connecting nodes. When it runs out of nodes and still haven't got the target number of infection, it will recursively
     * select another starting point and repeat the same step. When it goes over the targeted value, it will deduct the last 
     * few nodes it infected.
     * @param: int progress(how many nodes have been infected)
     * @return: int counter
     */
    User start = nw.getRandom();
    ArrayList<User> currentGen = new ArrayList<User>();
    currentGen.add(start);
    ArrayList<User> temp = new ArrayList<User>(currentGen);
    infected.add(start);
    int preprogress = 0;
    while(progress <= target || preprogress >= progress){
      currentGen.clear();
      int presize = infected.size();
      for (int i = 0; i < temp.size(); i++){
        currentGen.addAll(temp.get(i).getTeachers());
        currentGen.addAll(temp.get(i).getStudents());
        infected.addAll(temp.get(i).getTeachers());
        infected.addAll(temp.get(i).getStudents());
      }
      preprogress = progress;
      progress += (infected.size()-presize);
    }
    if (progress == target){
      return progress;
    } else if (progress < target){
      return Infect(progress);
    } else{
      int deduct = progress - target;
      for (int i = currentGen.size()-1; i >= 0; i--){
        infected.remove(currentGen.get(i));
        currentGen.get(i).setInfected();
        progress--;
          if (progress == target){
          return progress;
        }
      }
    }
    return progress;
  }
  
//  testing
  public static void main(String[] args){
    ExactInfection li1 = new ExactInfection(20);
    ExactInfection li2 = new ExactInfection(40);
    System.out.println("Input target infections: 20    Actual infections: " + li1.Infect(0));
    System.out.println("Input target infections: 40    Actual infections: " + li2.Infect(0));
  }
  
}