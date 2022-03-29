import java.io.*;
import java.util.*;

public class Ticket {
    
    private String departDate;  //  
    private String arriveDate;  //  for end date of hotel
    private ArrayList<String> locations;
    private Book reservation;
    private HotelBrands brand;
    private String hotelDate;
    private int cost; 


    public Ticket() {}

    public void flight(ArrayList<String> locations, String departDate, String arriveDate, Book reservation, int cost) {
        this.locations = locations;
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.reservation = reservation;
        this.cost = cost;
    }

    public void hotel(HotelBrands brand, String hotelDate) {
        this.brand = brand;
        this.hotelDate = hotelDate;
    }

    public boolean isFlight() {
        return locations != null;
    }

    public boolean isHotel() {
        return locations == null;
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

    public void printInfo() {
        if (this.isFlight()) {
            System.out.print("Flight depart date: " + departDate + " arrival date: " + arriveDate + " # of transfers: " + (locations.size()-1) + " locations: ");
            for (int i = 0; i < locations.size(); i++) {
                System.out.print(locations.get(i));
                if (i < locations.size()-1) {
                    System.out.print(" -> ");
                }
                else {
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("Hotel brand: " + brand.toString() + " Date of reservation: " + hotelDate);
        }
    }
    /**
     * will print out the details and reservation into text file
     * Needs to be implemented
     */
    public void print() {
        
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
