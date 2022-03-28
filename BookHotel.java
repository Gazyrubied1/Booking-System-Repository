import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;

public class BookHotel extends Book {
    
    private String HotelName;
    private String location;
    private String guest;
    private ArrayList<Hotels> HotelList = new ArrayList<Hotels>();
    
    public BookHotel() {

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

    public ArrayList<Hotels> getHotelList() {
        return HotelList;
    }
    

public void Book(){

        
    }

/**
 * Searches through the list of hotels by state and returns the hotels from that state
 * @param State A string value of the two letter state abreviation
 * @return an array list of hotels from that state
 */
public void SearchHotel(String State) {
    for(int i = 0; i < HotelList.size(); ++i){
        if(State.equalsIgnoreCase(HotelList.get(i).getState())) {
            System.out.println(HotelList.get(i).toString() + " ");
        }
    }
}

/**
 * Searches throught the list of hotels by state an brand
 * @param State a string state in form of two letter abreviation
 * @param brand the hotel brand as a string
 */
public void SearchHotel(String State, String  brand) {
    String UseBrand = brand.toString();
    for (int i =0; i < HotelList.size(); ++i) {
        if(State.equalsIgnoreCase(HotelList.get(i).getState())){
            if (UseBrand.equalsIgnoreCase(HotelList.get(i).getBrands().toString())) {
                System.out.println(HotelList.get(i).toString() + " ");
            } 
        }

    }
}

/**
 * Searches throught the list of hotels by brand
 * @param brand the hotel brand as a string
 */
public void SearchHotel(HotelBrands brand) {
    String UseBrand = brand.toString();
    for (int i = 0; i < HotelList.size();++i) {
        if(UseBrand.equalsIgnoreCase(HotelList.get(i).getBrands().toString())) {
            System.out.println(HotelList.get(i).toString() + " ");
        }
    }
}


}
