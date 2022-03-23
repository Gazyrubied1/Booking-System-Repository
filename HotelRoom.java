import java.util.ArrayList;

public class HotelRoom {
    private String City;
    private RoomType roomType;
    private ArrayList<DaysBooked> DaysBook;
    private String id;

    public HotelRoom(String City, RoomType roomType, ArrayList<DaysBooked> DaysBook, String id) {
        this.City = City;
        this.roomType = roomType;
        this.DaysBook = DaysBook;
        this.id = id;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setDaysBook(ArrayList<DaysBooked> daysBookeds) {
        this.DaysBook = daysBookeds;
    }

    public void setID(String Id) {
        this.id = Id;
    }

    public String getCity(){
        return City;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public ArrayList<DaysBooked> getDaysBook () {
        return DaysBook;
    }

    public String getId() {
        return id;
    }

}
