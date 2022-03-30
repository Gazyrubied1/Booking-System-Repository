import java.util.ArrayList;
import java.util.Random;

public class Flight {
    private ArrayList<String> locations = new ArrayList<String>();
    private int FlightDuration;
    private String DepartureDate;
    private seats SeatAvailable;
    private int cost; 
    private int transfers;
    private String id;


    /**
     * The flight class constructor
     * @param locations the locations that the trip will visit (list of transfer flights)
     * @param FlightDuration the total duration of the trip/flight
     * @param DepartureDate the date at which the flight leaves
     * @param SeatAvailable a list that holds all of the available seats of the flight
     * @param cost the cost of the flight
     * @param transfers the number of transfers of the flight // not needed because it can be represented as locations.size()-1
     * @param id the id that identifies a specific flight
     */
    public Flight(ArrayList<String> locations, int FlightDuration, String DepartureDate, seats SeatAvailable, int cost, int transfers, String id) {
        this.locations = locations;
        this.FlightDuration = FlightDuration;
        this.DepartureDate = DepartureDate;
        this.SeatAvailable = SeatAvailable;
        this.cost = cost;
        this.transfers = transfers;
        this.id = id;
}

    /**
     * Adds a location to the list of locations (Creates a transfer flight in the trip)
     * @param location the location to be added to the list of locations
     */
    public void addLocation (String location) {
       this.locations.add(location);
    }

    /**
     * Sets the duration of the flight to an int
     * @param time the int value that represents the duration of the flight
     */
    public void setFlightDuration(int time) {
        this.FlightDuration = time;
    }

    /**
     * Sets the departure date of the flight
     * @param DepartureDate the departure date of the flight
     */
    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    /**
     * Sets the available of seatsAvailable to an inputted list
     * @param SeatsAvailable the list that contains the available seats of the flight
     */
    public void setSeatAvailable(seats SeatsAvailable) {
        this.SeatAvailable = SeatsAvailable;
    }

    /**
     * Sets the cost of the flight
     * @param cost the cost of the flight
     */
    public void setCost(int cost) {

        this.cost = cost;
    }

    /**
     * Sets the id of the flight
     * @param id the id of the flight
     */
    public void setid(String id) {

        this.id = id;
    }
 
    /**
     * Gets the list of locations that the trip will stop in (if the trip is a direct flight, the size of locations will be 1)
     * @return the list of locations visited
     */
    public ArrayList<String> getlocations() {
        return locations;
    }

    /**
     * Gets the duration of the flight
     * @return an int representing the duration of the flight
     */
    public int getFlightDuration() {
        return FlightDuration;
    }

    /**
     * Gets the departure date of the flight
     * @return the String that represents the date of the flight's departure
     */
    public String getDepartureDate() {
        return DepartureDate;
    }

    /**
     * Gets the available seats on the flight
     * @return the ArrayList of seats that are available on the flight
     */
    public seats getSeatAvailable () {
        return SeatAvailable;
    }

    /**
     * Gets the cost of the flight
     * @return the cost of the flight
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets the id of the flight
     * @return the id of the flight
     */
    public String getID() {
        return id;
    }

    /**
     * gets the Number of transfers as an in
     * @return int transfers
     */
    public int getTransfers() {
        return transfers;
    }

    /**
     * generates if the flight is cancled or not 0.1% chance it is 
     * @return a boolean value of true or false where true is flight canceled
     */
    public boolean isFlightCanceled() {
        Random random = new Random();
        int isCanceled = random.nextInt(1000);
        if(isCanceled == 38) {
            return true;
        }
        return false;
    }

    /**
     * Prints details of individuals flights
     */
    public void print() {
        System.out.println("Flight details:\nYour trip has " + transfers + "transfers.");
        for (int i = 0; i < locations.size(); i++) { // prints travel path
            System.out.print(locations.get(i) + " ");
            if (i != locations.size()) {
                System.out.print("-> ");
            }
            else {
                System.out.println();
            }
        }
        System.out.println("cost: $" + cost + "\ndate: " + DepartureDate + " transfers: " + (locations.size()-1));
    }
}