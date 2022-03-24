import java.util.ArrayList;

public class Flight {
    private String departureLocation;
    private String arrivalLocation;
    private int FlightDuration;
    private String DepartureDate;
    private ArrayList<seats> SeatAvalable;
    private int cost; 
    private String id;

    public Flight(String departureLocation, String arrivalLocation, int FlightDuration,String DepartureDate, ArrayList<seats> SeatAvalable, int cost, String id) {
            
           this.departureLocation = departureLocation;
           this.arrivalLocation = arrivalLocation;
           this.FlightDuration = FlightDuration;
           this.DepartureDate = DepartureDate;
           this.SeatAvalable = SeatAvalable;
           this.cost = cost;
           this.id = id;
}

    public void setdepartureLocation (String departureLocation) {

       this.departureLocation = departureLocation;
    }

    public void setarrivalLocation(String arrivalLocation) {

        this.arrivalLocation = arrivalLocation;
    }
    public void setFlightDurrantion(int time) {
        this.FlightDuration = time;
    }
    public void setDepartureDate(String DepartureDate) {

        this.DepartureDate = DepartureDate;
    }
    public void setSeatAvalable(ArrayList<seats> SeatsAvalable) {

        this.SeatAvalable = SeatsAvalable;
    }
    public void setCost  (int cost) {

        this.cost = cost;
    }
    public String getDepartureLocation  () {

        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
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
        return true; 

    }

    /**
     *prints out the info of the flight before the flight  
     */
    public void print(int time, String destination, int cost) {

    }
}
