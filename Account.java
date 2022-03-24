import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Account {
    public UUID UserID;
    private String Email;
    private String Password;
    private ArrayList<RegisteredUser> Users;
    public HashMap<Flight, ArrayList<RegisteredUser>> currentFlights; 

    public Account (UUID UserID, String Email, String Password, ArrayList<RegisteredUser> Users, HashMap<Flight, ArrayList<RegisteredUser>> currentFlights) {
        this.UserID = UserID;
        this.Email = Email;
        this.Password = Password;
        this.Users = Users;
        this.currentFlights = currentFlights;
    }
    
    public boolean hasUser(String name) {
        for (RegisteredUser user : Users) {
            if ((user.getFirstName() + user.getLastName()).equals(name)) {
                return true;
            }
        }
        return false;
    }

    public RegisteredUser getUser(String name) {
        for (RegisteredUser user : Users) {
            if ((user.getFirstName() + user.getLastName()).equals(name)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(String firstName, String lastName, String DOB, String address) {
        if (hasUser(firstName + lastName)) return false;
        Users.add(new RegisteredUser(firstName, lastName, DOB, address, false, false, 0, 0.0, new ArrayList<Flight>(), new ArrayList<Airport>(), new ArrayList<Pet>()));
        return true;
    }

    public void saveUsers() {
        // fill in later
    }

    public void setUserID(String ID) {
        //TODO Convert the String ID Parameter to an instance of UUID
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
    public void setCurrentFlights(HashMap<Flight, ArrayList<RegisteredUser>> currentFlights) {
        this.currentFlights = currentFlights;
    }

    public UUID getUserID() {
        //TODO Return UUID instead of String
        return UserID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<RegisteredUser> getUsers() {
        return Users;
    }
    
    public HashMap<Flight, ArrayList<RegisteredUser>> getCurrentFlights() {

        return currentFlights;
    }

    /**
     * to string method
     */
    public String toString(){
        return null;
    }
}