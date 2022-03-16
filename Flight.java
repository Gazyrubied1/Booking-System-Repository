public class Flight {
    private AirPort departureLocation;
    private AirPort arrivalLocation;
    private int FlightDuration;
    private String DepartureDate;
    private ArrayList<Seats> SeatAvalable;
    private int cost; 

    public Flight(AirPort departureLocation, AirPort arrivalLocation, int FlightDuration,String DepartureDate, ArrayList<Seats> SeatAvalable, int cost) {
            
           this.departureLocation = departureLocation;
           this.arrivalLocation = arrivalLocation;
           this.FlightDuration = FlightDuration;
           this.DepartureDate = DepartureDate;
           this.SeatAvalable = SeatAvalable;
           this.cost = cost;
}

    public void setdepartureLocation (AirPort departureLocation) {

       this.departureLocation = departureLocation;
    }

    public void setarrivalLocation(AirPort arrivalLocation) {

        this.arrivalLocation = arrivalLocation;
    }
    public void setFlightDurrantion(int time) {
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
    public AirPort getDepartureLocation  () {

        return null;
    }

    public AirPort getArrivalLocation() {
        return null;
    }

    public int getFlightDuration() {
        return null;
    }

    public String getDepartureDate() {
        return null;
    }

    public ArrayList<Seats> getSeatAvalable () {
        return SeatAvalable;
    }

    public int getCost() {
        return cost;
    }

    public boolean isFlightCanceled() {

    }

    public void print(int time, AirPort destination, int cost) {

    }
}
