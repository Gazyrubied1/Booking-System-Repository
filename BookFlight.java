import java.util.ArrayList;

public class BookFlight extends Book{
    private boolean hasPets;
    private ArrayList<Flight> Flights = new ArrayList<Flight>();

    public BookFlight (String date, String location,boolean hasPets, ArrayList<Flight> Flights) {
        super(date, hasPets, location, location);
        this.hasPets =hasPets;
        this.Flights = Flights;
    }
    public void setHasPets(boolean hasPets) {
        this.hasPets =hasPets;
    } 

    public void setFlights(ArrayList<Flight> Flights) {
        this.Flights = Flights;
    }

    public boolean getHasPets() {
        return true;
    }

    public ArrayList<Flight> getFlights() {
        return null;
    }
    /**
     * 
     * @param State
     * @return
     */
    public ArrayList<Flight> searchLocation(String State) {
        return null;
    }
    /**
     * 
     * @param Date
     * @return
     */
    public ArrayList<Flight> searchDate(String Date) {
        return null;
    }
    /**
     * 
     * @param Date
     * @param time
     * @return
     */
    public ArrayList<Flight> searchDateTime(String Date, String time) {
        return null;
    } 
    /**
     * 
     * @param input
     * @param passengers
     * @param Tikets
     * @return
     */
    public Flight bookFlight(ArrayList<Flight> input, ArrayList<RegisteredUser> passengers, int Tikets) {
        return null;
    }
}
