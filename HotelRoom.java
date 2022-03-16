import java.util.ArrayList;

public class HotelRoom {
    private String City;
    private RoomType roomType;
    private ArrayList<DaysBooked> DaysBook;

    public HotelRoom(String City, RoomType roomType, ArrayList<DaysBooded> DaysBook) {
        this.City = City;
        this.roomType = roomType;
        this.DaysBook = DaysBook;
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

    public String getCity(){
        return City;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public ArrayList<DaysBooked> getDaysBook () {
        return DaysBook;
    }

}
