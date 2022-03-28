import java.io.*;
import java.util.*;

public class Ticket {
    
    private String departDate;  //  
    private String arriveDate;  //  for end date of hotel
    private ArrayList<String> locations;
    private Book reservation;

    public Ticket() {}

    public void flight(ArrayList<String> locations, String departDate, String arriveDate, Book resrvation) {
        this.locations = locations;
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.reservation = resrvation;
    }

    public String getDepartDate() {
        return departDate;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setReservation(Book reservation) {
        this.reservation = reservation;
    }

    public Book getReservation() {
        return reservation;
    }

    /**
     * will print out the details and reservation into text file
     */
    public void print() {
        System.out.println("details");
        
        try {
            File myObj = new File("filename.txt");
            myObj.createNewFile(); // creates file
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
