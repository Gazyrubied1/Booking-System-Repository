import java.time.LocalDate;
import java.util.ArrayList;

public class Hotels {
  
    private ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
    private String state;
    private HotelBrands Brand;
    

    /**
     * Constructor of the hotel
     * @param rooms the ArrayList of rooms inside of the hotel
     * @param state the state in which the hotel is located
     * @param brand the brand of the hotel
     */
    public Hotels (ArrayList<HotelRoom> rooms, String state, HotelBrands brand) {
        this.Rooms = rooms;
        this.state = state;
        this.Brand = brand;
    }

    /**
     * Assigns the hotel to a specific hotel brand
     * @param brands the brand of the hotel
     */
    public void setBrand(HotelBrands brands) {
        Brand = brands;
    }

    /**
     * Assigns the hotel to a state
     * @param state the state in which the hotel is located
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Fills the hotel with an ArrayList of rooms
     * @param rooms the rooms to fill the hotel
     */
    public void setRooms(ArrayList<HotelRoom> rooms) {
        this.Rooms = rooms;
    }

    /**
     * Gets the brand of the hotel
     * @return an enum of the brand of the hotel
     */
    public HotelBrands getBrands(){
        return Brand;
    }

    /**
     * Gets the state that the hotel is in
     * @return the state of the hotel
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the list of hotel rooms in the hotel
     * @return an ArrayList of HotelRooms
     */
    public ArrayList<HotelRoom> getRooms(){
        return Rooms;
    } 

    public void print() {
        System.out.println("Hotel brand: " + this.getBrands().toString() + " location: " + this.getState());
    }
}
