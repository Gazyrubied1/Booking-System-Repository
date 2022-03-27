import java.util.ArrayList;

public class Flight {
    private ArrayList<String> locations;
    private int FlightDuration;
    private String DepartureDate;
    private seats SeatAvalable;
    private int cost; 
    private int transfers;
    private String id;

    public Flight(ArrayList<String> locations, int FlightDuration, String DepartureDate, seats SeatAvalable, int cost, int transfers, String id) {
        this.locations = locations;
        
        this.FlightDuration = FlightDuration;
        this.DepartureDate = DepartureDate;
        this.SeatAvalable = SeatAvalable;
        this.cost = cost;
        this.transfers = transfers;
        this.id = id;
}

    public void addLocation (String location) {
       this.locations.add(location);
    }

    public void setFlightDuration(int time) {
        this.FlightDuration = time;
    }

    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public void setSeatAvalable(seats SeatsAvalable) {
        this.SeatAvalable = SeatsAvalable;
    }

    public void setCost  (int cost) {

        this.cost = cost;
    }

    public void setid(String id) {

        this.id = id;
    }
 
    public ArrayList<String> getlocations() {
        return locations;
    }

    public int getFlightDuration() {
        return FlightDuration;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public seats getSeatAvalable () {
        return SeatAvalable;
    }

    public int getCost() {
        return cost;
    }

    public String getID() {
        return id;
    }

    /**
     * prints out if the flight is Flight is canceld or not
     */
    public boolean isFlightCanceled() {
        return false;
    }

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
        System.out.println("cost: " + cost + "\ndate: " + DepartureDate);
    }
}
