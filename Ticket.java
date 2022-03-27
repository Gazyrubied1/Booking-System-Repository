import java.io.*;

public class Ticket {
    
    private String details;
    private Book reservation;

    public Ticket(String details, Book resrvation) {
        this.details = details;
        this.reservation = resrvation;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setReservation(Book reservation) {
        this.reservation = reservation;
    }

    public String getDetails() {
        return details;
    }

    public Book getReservation() {
        return reservation;
    }

    /**
     * will print out the details and reservation into text file
     */
    public void print() {
        System.out.println(details);
        
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
