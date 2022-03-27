import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class BookHotel extends Book {
    
    private String HotelName;
    private String location;
    private String guest;
    private ArrayList<Hotels> HotelList = new ArrayList<Hotels>();
    
    public BookHotel(String book, Boolean cancel, String date, String type, String HotelName, 
        String location, String guest, RoomType roomType, HotelBrands brands, ArrayList<Hotels> hotel) {
        
        super(book, cancel, date, type);
        this.HotelName = HotelName;
        this.location = location;
        this.guest = guest;
        this.HotelList = hotel;
    }


    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }


    public String getHotelName() {
        return HotelName;
    }

    public String getLocation() {
        return location;
    }
    public String getGuest() {
        return guest;
    }
    

public void Book(){

        
    }

/**
 * Searches through the list of hotels by state and returns the hotels from that state
 * @param State A string value of the two letter state abreviation
 * @return an array list of hotels from that state
 */
public ArrayList<Hotels> SearchHotel(String State) {

    ArrayList<Hotels> toReturn = new ArrayList<Hotels>();
    for(int i = 0; i < HotelList.size(); ++i){
    
        if(State.equalsIgnoreCase(HotelList.get(i).getState())) {
            toReturn.add(HotelList.get(i));
        }

    }
    return toReturn;
}


public ArrayList<Hotels> SearchHotel(String State, HotelBrands brand) {

    ArrayList<Hotels> toReturn = new ArrayList<Hotels>();
    String UseBrand = brand.toString();
    for (int i =0; i < HotelList.size(); ++i) {
        if(State.equalsIgnoreCase(HotelList.get(i).getState())){
            if (UseBrand.equalsIgnoreCase(HotelList.get(i).getBrands().toString())) {
                toReturn.add(HotelList.get(i));
            } 
        }

    }

    return toReturn;
}


public ArrayList<Hotels> SearchHotel(HotelBrands brand) {

    ArrayList<Hotels> toReturn = new ArrayList<Hotels>();
    String UseBrand = brand.toString();
    for (int i = 0; i < HotelList.size();++i) {
        if(UseBrand.equalsIgnoreCase(HotelList.get(i).getBrands().toString())) {
            toReturn.add(HotelList.get(i));
        }
    }
    return toReturn;
}


}
