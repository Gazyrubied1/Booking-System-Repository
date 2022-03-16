import java.util.ArrayList;

public class RegisteredUser {
    private String firstName;
    private String lastName;
    private String DateOfBirth;
    private String BillingAddress;
    private boolean Discount;
    private boolean RewardMember;
    private int NumFlights;
    private double Review;
    private ArrayList<Flight> PastFlight;
    private ArrayList<String> blacklisted;
    private ArrayList<Pet> pets;

    public RegisteredUser(String firstName, String lastName, String DOB,String BillingAddress, boolean Discount, boolean RewardMember, int NumFlights, double Review, ArrayList<Flights> PastFlight, ArrayList<Airport> Blacklisted, ArrayList<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth =DOB;
        this.BillingAddress = BillingAddress;
        this.Discount = Discount;
        this.RewardMember = RewardMember;
        this.NumFlights = NumFlights;
        this.Review = Review;
        this.PastFlight = PastFlight;
        this. blacklisted = Blacklisted;
        this.pets =pets;
    }
    // gettters
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
    public ArrayList<Flight> getPastFlight() {
        return PastFlight;
    }
    public ArrayList<String> getBlackList() {
        return blacklisted;
    }
    public ArrayList<Pet> getPets(){
        return pets;
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
        this.RewardMember = RewardMember;
    }
    public void setNumFlights(int NumFlights) {
        this.NumFlights = NumFlights;
    }
    public void setReview(double Review) {
        this.Review = Review;
    }
    public void setPastFlight(ArrayList<Flight> PastFlight) {
        this.PastFlight = PastFlight;
    }
    public void setBlacklisted(ArrayList<String> blackList) {
        this.blacklisted = blackList;
    }
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * 
     * @param flight
     */
    public void cancelFlight(Flight flight){
        return;   
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
    public void blacklistAirport() {
        return;
    }

    /**
     * 
     * @return
     */
    public Flights SavedFlights() {
        return null;
    }

}