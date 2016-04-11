import java.util.*;

public class User{
  /**
   * Basic class for user model. 
   */
  private ArrayList<User> Teachers, Students;
  private int version;
  private boolean infected = false;
  
  /**
   * Constructor for the User class
   * @param: int version   the version of the website the user is using
   * @return: a new User object
   */
  public User(int version){
    this.version = version;
    Teachers = new ArrayList<User>();
    Students = new ArrayList<User>();
  }
  
  /**
   * Add a student to the list of students that are coached by the current user
   * @param: User student
   * @return: void
   */
  public void addStudent(User a){
    Students.add(a);
  }
  
  /**
   * Add a teacher to the list of teachers that are teaching the current user
   * @param: User teacher
   * @return: void
   */
  public void addTeacher(User a){
    Teachers.add(a);
  }
  
  /**
   * Return a list of all students of the user
   * @param: N/A
   * @return: ArrayList<User> students
   */
  public ArrayList<User> getStudents(){
    return Students;
  }
  
  /**
   * Return a list of all teachers of the user
   * @param: N/A
   * @return: ArrayList<User> teachers
   */
  public ArrayList<User> getTeachers(){
    return Teachers;
  }
  
  /**
   * Return the number of users connected with this user
   * @param: N/A
   * @return: int number_of_connections
   */
  public int relativeUsers(){
    return Teachers.size() + Students.size();
  }
  
  /**
   * Set whether the use is infected
   * @param: N/A
   * @return: N/A
   */
  public void setInfected(){
    infected = !infected;
  }
  
  /**
   * Check whether the stident is infected
   * @param: N/A
   * @return: boolean isInfected
   */
  public boolean isInfected(){
    return infected;
  }
  
}