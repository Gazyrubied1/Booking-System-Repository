import java.io.*;
import java.util.*;

public class Ticket {
    
    private String departDate;  //  
    private String arriveDate;  //  for end date of hotel
    private ArrayList<String> locations;
    private Book reservation;
    private HotelBrands brand;
    private String hotelDate;
    private boolean isHotel;

    public Ticket() {}

    /**
     * Instantiates values if the Ticket is holding informaion for a flight
     * @param locations the location(s) that will be visited on the trip
     * @param departDate the date that the flight will depart
     * @param arriveDate the arrival date of the flight
     * @param reservation
     */
    public void flight(ArrayList<String> locations, String departDate, String arriveDate, Book reservation, int cost) {
        this.isHotel = false;
        this.locations = locations;
        this.departDate = departDate;
        this.arriveDate = arriveDate;
        this.reservation = reservation;
    }

    /**
     * Instantiates values if the Ticket is holding information for a hotel stay
     * @param brand the brand of the hotel
     * @param hotelDate the date that the hotel stay will occur on
     */
    public void hotel(HotelBrands brand, String hotelDate) {
        this.isHotel = true;
        this.brand = brand;
        this.hotelDate = hotelDate;
    }

    /**
     * Gets a boolean value that checks if the Ticket represents a flight
     * @return a boolean that is true if the Ticket holds a flight, false if it does not
     */
    public boolean isFlight() {
        return !isHotel;
    }

    /**
     * Gets a boolean value that checks if the Ticket represents a hotel stay
     * @return a boolean that is true if the Ticket holds a hotel stay, false if it does not
     */
    public boolean isHotel() {
        return isHotel;
    }

    /**
     * Gets the departure date of the flight/hotel stay
     * @return a String that holds the departure date
     */
    public String getDepartDate() {
        return departDate;
    }

    /**
     * Gets the arrival date of the flight/hotel stay
     * @return a String that holds the arrival date
     */
    public String getArriveDate() {
        return arriveDate;
    }

    /**
     * Gets the list of locations that will be visited on the trip that is held in the Ticket
     * @return the list of locations that will be visited
     */
    public ArrayList<String> getLocations() {
        return locations;
    }

    /**
     * Sets the reservation to an inputted Book object
     * @param reservation the Book object that will be set as the reservation of the Ticket
     */
    public void setReservation(Book reservation) {
        this.reservation = reservation;
    }

    /**
     * Gets the reservation of the Ticket
     * @return a reservation that is held in the Book class
     */
    public Book getReservation() {
        return reservation;
    }

    /**
     * Prints the info of the Ticket as a print statement.
     */
    public void printInfo() {
        if (this.isFlight()) {
            System.out.print("Flight depart date: " + departDate + " # of transfers: " + (locations.size()-1) + " locations: ");
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
            System.out.println("Hotel brand: " + brand.toString() + " Date of reservation: " +departDate +"-"+arriveDate);
        }
    }

    /**
     * will print out the details and reservation into text file
     * Needs to be implemented
     */
    public void print() {
        
        try {
            File file = new File("BOOK/Flight and Hotel Itinerary.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter("Flight and Hotel Itinerary.txt");
            writer.write("***Flight Information***\n\nDeparture Date: " 
                + departDate + "\nArrival Date: " + arriveDate + "\n\n***Hotel Information***\n\n" + "Brand: " + brand + "\nHotel Date: " + hotelDate);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) {
            System.out.println("An error occurred while trying to print the Itinerary.");
            e.printStackTrace();
        }
    }
}
