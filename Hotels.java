import java.util.ArrayList;

public class Hotels {
  
    private ArrayList<HotelRoom> Rooms = new ArrayList<HotelRoom>();
    private String state;
    private HotelBrands Brand;
    

    public Hotels (ArrayList<HotelRoom> rooms, String state, HotelBrands brand) {
        this.Rooms = rooms;
        this.state = state;
        this.Brand = brand;
    }

    public void setBrand(HotelBrands brands) {
        Brand = brands;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRooms(ArrayList<HotelRoom> rooms) {
        this.Rooms = rooms;
    }

    public HotelBrands getBrands(){
        return Brand;
    }

    public String getState() {
        return state;
    }

    public ArrayList<HotelRoom> getRooms(){
        return Rooms;
    } 
}
