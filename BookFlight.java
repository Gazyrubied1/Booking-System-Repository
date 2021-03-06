import java.util.ArrayList;
import java.util.Scanner;

public class BookFlight extends Book{
    private boolean hasPets;
    private ArrayList<Flight> Flights = new ArrayList<Flight>();

    public BookFlight(){

    }
    
    public BookFlight (ArrayList<Flight> flight) {
        this.Flights = flight;

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
        return Flights;
    }
    
    /**
     * Prints out the list of Flights from a start location
     * @param State The stating state the user would leave from
     * @param Blacklisted the 
     */
    public ArrayList<Flight> searchStartLocation(String StartLoc, ArrayList<String> Blacklisted) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(i).equalsIgnoreCase(StartLoc)){
                if(checkBlackList(Blacklisted, i) ) {
                Printout(i, last);
                toReturn.add(Flights.get(i));
                }
            }
            
        }
        return toReturn;
        
    }

    /**
     * Prints out the flight for the user to pick from
     * @param StartLoc A string value of the start location state
     * @param EndLoc A String value of the end location state
     * @param Black the array list of blacklisted states from the registered users
     */
    public ArrayList<Flight> searchLocation(String StartLoc, String EndLoc, ArrayList<String> Black) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(i).equalsIgnoreCase(StartLoc) && Flights.get(i).getlocations().get(last).equalsIgnoreCase(EndLoc) &&
                checkBlackList(Black, i)){
               Printout(i, last);
               toReturn.add(Flights.get(i));
            }
        }
        return toReturn;
        
    }

    /**
     * Prints out the list of flights for the user to pick from
     * @param endLoc
     * @param blackList
     */
    public ArrayList<Flight> searchEndLocation(String endLoc, ArrayList<String> blackList) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for(int i = 0; i < Flights.size(); ++i) {
            int last = Flights.get(i).getlocations().size();
            if(Flights.get(i).getlocations().get(last).equalsIgnoreCase(endLoc)){
                if(checkBlackList(blackList, i)) {
                    Printout(i, last);
                    toReturn.add(Flights.get(i));
                }
                
            }
        }
        return toReturn;
        
    }

    
    private boolean checkBlackList(ArrayList<String> blacklist, int index) {
        //  fix to split the string of flights
        for (int j = 0; j < Flights.get(index).getlocations().size(); ++j) {
            for (int i = 0; i < blacklist.size(); ++i) {
                if (blacklist.get(i).equalsIgnoreCase(Flights.get(index).getlocations().get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    private void Printout(int i, int ii){
        System.out.print(Flights.get(i).getlocations().get(i) + " to " + Flights.get(i).getlocations().get(ii));
    }

    /**
     * Prints out the Flights avable by the date
     * @param Date the date that the user wants to leave on
     * @param Blacklist the users blacklisted states
     */
    public ArrayList<Flight> searchDate(String Date, ArrayList<String> blacklist) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for (int i = 0; i < Flights.size(); ++i) {
            if(Flights.get(i).getDepartureDate().equals(Date) && checkBlackList(blacklist, i)) {
            int last = Flights.get(i).getlocations().size();
            Printout(i, last);
            toReturn.add(Flights.get(i));
            }   
        }
        return toReturn;
    }
   /**
    * Bookes a flight for the passengers 
    * @param input the flight that the users wants to book
    * @param passengers the arraylist of Registed user that are going on the flight
    * @return the flight to be booked
    */
    public Ticket bookFlight(Flight input, ArrayList<RegisteredUser> passengers) {
        Ticket tik = new Ticket();
        Scanner keyBoard = new Scanner(System.in);
        seats use = input.getSeatAvailable();
        System.out.println("The available seats are: ");
       
        for(int i = 0; i < use.getSize(); ++i) {
            ArrayList<seat> toPrint = new ArrayList<seat>();
            toPrint = use.getRowSeat(i);
           for(int ii = 0; ii < toPrint.size(); ++ii)
            System.out.print("row: " + toPrint.get(ii).getRow()+" col: "+toPrint.get(ii).getCol() + "\n");
        }
        System.out.println("The cost of the flight is: "+input.getCost()+"\n Would you Like to book? (1) yes (2) no");
        int anwser =keyBoard.nextInt();
        if(anwser != 1){
            keyBoard.close();
            return tik;
        }
        for(int i = 0; i < passengers.size(); ++i){
            System.out.println("Please enter the column and then the row you would like for " + passengers.get(i).getFirstName() + " " + passengers.get(i).getLastName());
            System.out.println("Column: ");
            int colom = keyBoard.nextInt();
            System.out.println("Row: ");
            String CrowTemp = keyBoard.next();
            char Crow = CrowTemp.charAt(0);
            for(int ii = 0; ii < use.getSize(); ii++){
                if(use.getseat(ii).getRow() == Crow && use.getseat(ii).getCol() == colom) {
                    tik = passengers.get(i).addPlaneTicket(input.getDepartureDate(), input.getDepartureDate(), input.getlocations(), this, use.getseat(ii), input);
                    }
                }
            } 
            input.print();
            return tik;
    }

}
