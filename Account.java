import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    public String UserID;
    private String Email;
    private String Password;
    private ArrayList<RegisteredUser> Users;
    public HashMap<Flight, ArrayList<RegisteredUser>> currentFlights; 

    public Account ( String UserID, String Email, String Password, ArrayList<RegisteredUser> Users, HashMap<Flights, ArrayList<RegisteredUser> currentFlights) {
        this.UserID = UserID;
        this.Email = Email;
        this.Password = Password;
        this.Users = Users;
        this.currentFlights = currentFlights;
    }
    
    public void setUserID(String ID) {
        this.UserID = ID;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setUsers(ArrayList<RegisteredUser> Users) {
        this. Users = Users;
    }
    /**
     * pribaly needs to be fixed
     * @param currentFlights
     */
    public void setCurrentFlights(HashMap<Flights, ArrayList<RegisteredUser>> currentFlights) {
        this.currentFlights = currentFlights;
    }

    public String getUserID() {
        return UserID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<RegisteredUsers> getUsers() {
        return Users;
    }
    /**
     * 
     * @return
     */
    public HashMap<Flights, ArrayList<RegisteredUser>> getCurrentFlights() {

        return currentFlights;
    }

    /**
     * to string method
     */
    public String toString(){
        return null;
    }



}