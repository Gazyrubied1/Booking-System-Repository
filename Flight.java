public class Flight {
    private ArrayList<String> locations;
    private int FlightDuration;
    private String DepartureDate;
    private ArrayList<Seats> SeatAvalable;
    private int cost; 
    int transfers;

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
        this.FlightDuration = time;
    }
    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }
    public void setSeatAvalable(ArrayList<Seats> SeatsAvalable) {
        this.SeatAvalable = SeatsAvalable;
    }
    public void setCost  (int cost) {

        this.cost = cost;
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

    public ArrayList<Seats> getSeatAvalable () {
        return SeatAvalable;
    }

    public int getCost() {
        return cost;
    }

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
