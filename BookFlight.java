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
     * Prints out the list of Flights from a start location
     * @param State The stating state the user would leave from
     * @param Blacklisted the 
     */
    public void searchStartLocation(String StartLoc, ArrayList<String> Blacklisted) {
        
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(i).equalsIgnoreCase(StartLoc)){
                if(checkBlackList(Blacklisted, i) ) {

                Printout(i, last);
                }
            }
            
        }
        
    }

    /**
     * Prints out the flight for the user to pick from
     * @param StartLoc A string value of the start location state
     * @param EndLoc A String value of the end location state
     * @param Black the array list of blacklisted states from the registered users
     */
    public void searchLocation(String StartLoc, String EndLoc, ArrayList<String> Black) {
        
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(i).equalsIgnoreCase(StartLoc) && Flights.get(i).getlocations().get(last).equalsIgnoreCase(EndLoc) &&
                checkBlackList(Black, i)){
               Printout(i, last);
                
            }
        }
        
    }

    /**
     * Prints out the list of flights for the user to pick from
     * @param endLoc
     * @param blackList
     */
    public void searchEndLocation(String endLoc, ArrayList<String> blackList) {
        
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(last).equalsIgnoreCase(endLoc)){
                if(checkBlackList(blackList, i)) {
                    Printout(i, last);
                }
                
            }
        }
        
    }


    private boolean checkBlackList(ArrayList<String> blacklist, int index) {

        for (int i = 0; i < blacklist.size(); ++i) {
            if(blacklist.get(i).equalsIgnoreCase(Flights.get(index).getlocations().get(i))){
                return false;
            }
        }
        return true;
    }

    private void Printout(int i, int ii){
        System.out.print(Flights.get(i).getlocations().get(i) + "to" + Flights.get(i).getlocations().get(ii));
    }

    /**
     * Prints out the Flights avable by the date
     * @param Date the date that the user wants to leave on
     * @param Blacklist the users blacklisted states
     */
    public void searchDate(String Date, ArrayList<String> blacklist) {
        
        for (int i = 0; i < Flights.size(); ++i) {
            if(Flights.get(i).getDepartureDate().equals(Date) && checkBlackList(blacklist, i)) {
            int last = Flights.get(i).getlocations().size();
            Printout(i, last);
            }   
        }
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
