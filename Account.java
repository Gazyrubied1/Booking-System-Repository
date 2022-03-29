import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Account extends User {
    public String UserID;
    private String Email;
    private String Password;
    private ArrayList<RegisteredUser> Users = new ArrayList<RegisteredUser>();


    /**
     * The constructor method for the Account class
     * @param UserID the identifing id of the Account
     * @param Email the email of the Account
     * @param Password the password of the Account
     * @param users the users that will be in the Account
     * @param currentFlights 
     */
    public Account (String UserID, String Email, String Password, ArrayList<RegisteredUser> users) {
        super();
        this.UserID = UserID;
        this.Email = Email;
        this.Password = Password;
        this.Users = users;
    }
    
    /**
     * Checks if a user is in the Account
     * @param name the name of the user 
     * @return a boolean value that will be true if the user is in the account and false if it is not
     */
    public boolean hasUser(String name) {
        for (RegisteredUser user : Users) {
            if ((user.getFirstName() + user.getLastName()).equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a user given the user's name
     * @param name the name of the user that is to be found
     * @return the user that has the inputted name
     */
    public RegisteredUser getUser(String name) {
        for (RegisteredUser user : Users) {
            if ((user.getFirstName() + user.getLastName()).equals(name)) {
                return user;
            }
        }
        return null;
    }
    /**
     * Adds a user to the Account
     * @param user the user to be added to the account
     */
    public void addUser(RegisteredUser user) {
        Users.add(user);
    }

    /**
     * Adds a user to the Account 
     * @param firstName the first name of the new user
     * @param lastName the last name of the new user
     * @param DOB the date of birth of the new user
     * @param address the new user's address
     * @return a boolean that will be true if the creation of the new user was successful and false if there is already a user in the account that shares the same first and last name of another user
     */
    public boolean addUser(String firstName, String lastName, String DOB, String address) {
        if (hasUser(firstName + lastName)) return false;
        Users.add(new RegisteredUser(firstName, lastName, DOB, address, false, false, 0, 0.0, new ArrayList<Ticket>(), new ArrayList<String>(), new ArrayList<Pet>(), UUID.randomUUID().toString()));
        return true;
    }

    public void saveUsers() {
        // fill in later
    }

    public void setUserID(String ID) {
        //TODO Convert the String ID Parameter to an instance of UUID
        this.UserID = ID;
    }

    /**
     * Sets the email of the Account to a specified value
     * @param email the Account's new email
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Sets the password of the Account to a specified value
     * @param password the Account's new password
     */
    public void setPassword(String password) {
        this.Password = password;
    }

    /**
     * Fills the users of the Account's users with an ArrayList of users
     * @param Users an ArrayList<RegisteredUser> that represents all of the Account's users
     */
    public void setUsers(ArrayList<RegisteredUser> Users) {
        this. Users = Users;
    }

    /**
     * Gets the id of the user
     * @return the id of the user
     */
    public String getUserID() {
        return UserID;
    }

    /**
     * Gets the email of the account
     * @return the email of the account
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Gets the password of the account
     * @return the password of the account
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Gets a list of users in the accout
     * @return the ArrayList of RegisteredUsers in the account
     */
    public ArrayList<RegisteredUser> getUsers() {
        return Users;
    }

    /**
     * to string method
     */

    public String toString(){
        return "id: " + this.getUserID() + " email: " + this.getEmail() + " password: " + this.getPassword() + " users: " + this.getUsers();
    }
}
