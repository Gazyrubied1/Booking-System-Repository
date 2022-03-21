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

    public Book getResrvation() {
        return reservation;
    }

    /**
     * will print out the details and reservation in readable formate
     */
    public void print() {
        System.out.println(details);
        
    }
}
