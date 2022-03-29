import java.util.ArrayList;
import java.io.*;
import java.security.PrivilegedExceptionAction;

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

    public ArrayList<Ticket> getPastFlights() {
        return PastReservation;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getDateOfBirth() {
        return DateOfBirth;
    }
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
    public ArrayList<Ticket> getPastReservation() {
        return PastReservation;
    }
    public ArrayList<String> getBlackList() {
        return blacklisted;
    }
    public ArrayList<Pet> getPets(){
        return pets;
    }
    public String getID() {
        return id;
    }
    // setters

    public void setfirstName (String firstName) {
        this.firstName = firstName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDateOfBirth(String DOB) {
        // check for valid dob
        this.DateOfBirth  = DOB;
    }
    public void setDiscount(boolean Discount) {
        this.Discount = Discount;
    }
    public void setRewardMember(boolean RewardMember) {
        if(PastReservation.size() > 3){
            this.RewardMember = true;
        }else{
        this.RewardMember = RewardMember;
        }
    }
    public void setNumFlights(int NumFlights) {
        this.NumFlights = NumFlights;
    }
    public void setReview(double Review) {
        this.Review = Review;
    }
    public void setPastFlight(ArrayList<Ticket> PastReservation) {
        this.PastReservation = PastReservation;
    }
    public void setBlacklisted(ArrayList<String> blackList) {
        this.blacklisted = blackList;
    }
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    /**
     *
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

    public void addPet(Pet pet) {
        pets.add(pet);
    }

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
    public void addPlaneTicket(String departDate, String arriveDate, ArrayList<String> locations, BookFlight flight, seat mySeat, Flight ToBook){
       Ticket toAdd = new Ticket();
       int price = ToBook.getCost();
       if(Discount) {
          price = (int)(price * 0.15);
       }
       toAdd.flight(locations,departDate, arriveDate, flight, price);
       PastReservation.add(toAdd);
       setRewardMember(RewardMember);
    }

    /**
     * Adds ahotel ticket to the ticket array
     * @param startDay the first day that the room is booked
     * @param endDay the last day the room is booked
     * @param hotelLocation the State the hotel is in/ 
     * @param hotel the type of booking 
     */

     public void addHotelTicket(ArrayList<String> Location, String Strat, String end, BookHotel Booktype, RoomType type) {
        Ticket toAdd = new Ticket();
        // make cost here baised on room type 
        
        RoomType Twin = RoomType.Twin_Beds;
        RoomType Queens = RoomType.Queen_twin_beds;
        int price = 0;
        if(type == Twin || type == Queens){
              price = 150;
        }else{
            price = 250;
        }
        toAdd.flight(Location, Strat, end, Booktype, price);
    }

}
