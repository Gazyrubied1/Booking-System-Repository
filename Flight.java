import java.util.ArrayList;

public class Flight {
<<<<<<< HEAD
    private String departureLocation;
    private String arrivalLocation;
=======
    private ArrayList<String> locations;
>>>>>>> Anavami/21-22
    private int FlightDuration;
    private String DepartureDate;
    private ArrayList<seats> SeatAvalable;
    private int cost; 
    int transfers;

<<<<<<< HEAD
    public Flight(String departureLocation, String arrivalLocation, int FlightDuration,String DepartureDate, ArrayList<seats> SeatAvalable, int cost) {
            
           this.departureLocation = departureLocation;
           this.arrivalLocation = arrivalLocation;
           this.FlightDuration = FlightDuration;
           this.DepartureDate = DepartureDate;
           this.SeatAvalable = SeatAvalable;
           this.cost = cost;
}

    public void setdepartureLocation (String departureLocation) {

       this.departureLocation = departureLocation;
    }

    public void setarrivalLocation(String arrivalLocation) {

        this.arrivalLocation = arrivalLocation;
    }
    public void setFlightDurrantion(int time) {
=======
    public Flight(ArrayList<String> locations, int FlightDuration, String DepartureDate, ArrayList<Seats> SeatAvalable, int cost, int transfers) {
        this.locations = locations;
        this.arrivalLocations = arrivalLocations;
        this.FlightDuration = FlightDuration;
        this.DepartureDate = DepartureDate;
        this.SeatAvalable = SeatAvalable;
        this.cost = cost;
        this.transfets = transfers;
}

    public void addLocation (String location) {
       this.locations.add(location);
    }

    public void setFlightDuration(int time) {
>>>>>>> Anavami/21-22
        this.FlightDuration = time;
    }
    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }
<<<<<<< HEAD
    public void setSeatAvalable(ArrayList<seats> SeatsAvalable) {

=======
    public void setSeatAvalable(ArrayList<Seats> SeatsAvalable) {
>>>>>>> Anavami/21-22
        this.SeatAvalable = SeatsAvalable;
    }
    public void setCost  (int cost) {

        this.cost = cost;
    }
<<<<<<< HEAD
    public String getDepartureLocation  () {

        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
=======
 
    public ArrayList<String> getlocations() {
        return locations;
>>>>>>> Anavami/21-22
    }

    public int getFlightDuration() {
        return FlightDuration;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public ArrayList<seats> getSeatAvalable () {
        return SeatAvalable;
    }

    public int getCost() {
        return cost;
    }

    /**
     * prints out if the flight is Flight is canceld or not
     */
    public boolean isFlightCanceled() {
<<<<<<< HEAD
        return true; 

    }

    /**
     *prints out the info of the flight before the flight  
     */
    public void print(int time, String destination, int cost) {

=======
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
>>>>>>> Anavami/21-22
    }
}
