import java.util.ArrayList;
import java.io.*;

public class RegisteredUser {
    private String firstName;
    private String lastName;
    private String DateOfBirth;
    private String BillingAddress;
    private boolean Discount;
    private boolean RewardMember;
    private int NumFlights;
    private double Review;
    private ArrayList<Ticket> PastReservation = new ArrayList<Ticket>();
    private ArrayList<String> blacklisted = new ArrayList<String>();
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    private String id;
    public int getFirstName;
    public int getLastName;

    public RegisteredUser(String firstName, String lastName, String DOB,String BillingAddress, boolean Discount, boolean RewardMember,
                          int NumFlights, double Review, ArrayList<Ticket> PastReservation, ArrayList<String> Blacklisted, ArrayList<Pet> pets, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth =DOB;
        this.BillingAddress = BillingAddress;
        this.Discount = Discount;
        this.RewardMember = RewardMember;
        this.NumFlights = NumFlights;
        this.Review = Review;
        this.PastReservation = PastReservation;
        this. blacklisted = Blacklisted;
        this.pets = pets;
        this.id = id;

    }

    // existing account loaded from JSON

    public RegisteredUser(String id, String firstName, String lastName, String DOB,String BillingAddress, boolean Discount, boolean RewardMember, int NumFlights, double Review, ArrayList<Ticket> PastFlight, ArrayList<String> Blacklisted, ArrayList<Pet> pets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth = DOB;
        this.BillingAddress = BillingAddress;
        this.Discount = Discount;
        this.RewardMember = RewardMember;
        this.NumFlights = NumFlights;
        this.Review = Review;
        this.blacklisted = Blacklisted;
        this.pets = pets;
        this.PastReservation = PastFlight;
    }

    /**
     * Gets the user's past flights
     * @return an ArrayList of Tickets that contains all of the user's previous flights
     */
    public ArrayList<Ticket> getPastFlights() {
        return PastReservation;
    }

    /**
     * Gets the first name of the user
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the date of birth of the user
     * @return the date of birth of the user
     */
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    /**
     * Gets the user's address
     * @return the address of the user
     */
    public String getBillingAddress() {
        return BillingAddress;
    }

    public boolean getDiscount() {
        return Discount;
    }

    public boolean getRewardMember() {
        return RewardMember;
    }

    public int getNumFlights() {
        return NumFlights;
    }

    public double getReview() {
        return Review;
    }

    /**
     * Reutrns the RegisteredUser's past reservations
     * @return the ArrayList containing all of the user's tickets
     */
    public ArrayList<Ticket> getPastReservation() {
        return PastReservation;
    }

    /**
     * Returns the list of blacklisted states
     * @return a list containing all of the blacklisted states
     */
    public ArrayList<String> getBlackList() {
        return blacklisted;
    }

    /**
     * Returns the pets that the RegisteredUser has
     * @return the ArrayList of pets that contains all of the user's pets+
     */
    public ArrayList<Pet> getPets(){
        return pets;
    }

    /**
     * Returns the id of the RegisteredUser
     * @return the user's id
     */
    public String getID() {
        return id;
    }
    // setters

    /**
     * Changes the first name of the user
     * @param firstName the user's new first name
     */
    public void setfirstName (String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Changes the last name of the user 
     * @param lastName the user's new last name
     */
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth of the user
     * @param DOB the date of birth of the user
     */
    public void setDateOfBirth(String DOB) {
        // check for valid dob
        this.DateOfBirth  = DOB;
    }

    public void setDiscount(boolean Discount) {
        this.Discount = Discount;
    }

    public void setRewardMember(boolean RewardMember) { // update
        this.RewardMember = RewardMember;
    }

    public void setNumFlights(int NumFlights) {
        this.NumFlights = NumFlights;
    }
    
    public void setReview(double Review) {
        this.Review = Review;
    }

    /**
     * Sets an ArrayList of tickets to be all of the user's past flights
     * @param PastReservation the list of tickets that represent previous flights
     */
    public void setPastFlight(ArrayList<Ticket> PastReservation) {
        this.PastReservation = PastReservation;
    }

    /**
     * Takes a list of states and blacklists them
     * @param blackList the list of states to be blacklisted
     */
    public void setBlacklisted(ArrayList<String> blackList) {
        this.blacklisted = blackList;
    }

    /**
     * Sets an ArrayList of pets to be the list of the RegisteredUser's pets
     * @param pets
     */
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Sets an id to the RegisteredUser
     * @param Id the id that will be set to be the user's identifier
     */
    public void setId(String Id) {
        this.id = Id;
    }

    /**
     * Cancels a flight that was booked by the user. Deletes the flight by removing the ticket from the users array of tickets
     * @param flight
     */
    public void cancelFlight(Ticket flight){
        PastReservation.remove(flight);
    }
     /**
      *
      */
     public void addPastFlight() {
         return;
     }

    /**
     * 
     */
    public void viewPastFlights() {
        return;
    }

    /**
     * possible change to have string input
     */
    public void blacklistAirport(String airport) { // will take parameter Airport
        blacklisted.add(airport);
    }

    /**
     * 
     * @return
     */
    public Flight SavedFlights() {
        return null;
    }

    /**
     * Adds a pet to the RegisteredUser
     * @param pet the pet to be added to the user
     */
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    /**
     * Prints the list of pets of the RegisteredUser
     */
    public void printPets() {
        if (pets.size() == 0) System.out.println("This user has no pets.");
        for (Pet pet : pets) {
            System.out.println("Pet: " + pet.toString());
        }
    }

    public void printTicket() {
    
    }

    /**
     * adds a plane trip to the ticket class
     * @param departDate
     * @param arriveDate
     * @param locations
     * @param flight
     */
    public void addPlaneTicket(String departDate, String arriveDate, ArrayList<String> locations, BookFlight flight, seat mySeat){
       Ticket toAdd = new Ticket();
       toAdd.flight(locations,departDate, arriveDate, flight);
       PastReservation.add(toAdd);
    }

    /**
     * Adds a hotel ticket to the ticket array
     * @param startDay the first day that the room is booked
     * @param endDay the last day the room is booked
     * @param hotelLocation the State the hotel is in/ 
     * @param hotel the type of booking 
     */

     public void addHotelTicket(ArrayList<String> Location, String Strat, String end, BookHotel hotel) {
        Ticket toAdd = new Ticket();
        toAdd.flight(Location, Strat, end, hotel);
    }

}
