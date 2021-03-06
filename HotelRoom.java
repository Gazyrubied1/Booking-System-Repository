import java.util.ArrayList;

public class HotelRoom {
    private RoomType roomType;
    private ArrayList<DaysBooked> DaysBook;
    private String id;

    public HotelRoom(RoomType roomType, ArrayList<DaysBooked> DaysBook, String id) {
        this.roomType = roomType;
        this.DaysBook = DaysBook;
        this.id = id;
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


    public RoomType getRoomType() {
        return roomType;
    }

    public ArrayList<DaysBooked> getDaysBook() {
        return DaysBook;
    }

    public String getId() {
        return id;
    }

    public void addDays(int [] days, int year) {

        for (int i = 0; i < days.length; ++i) {
            if(days[i] > 0 && days[i] <=365 ) {
            DaysBooked toAdd = new DaysBooked(year, days);
            DaysBook.add(toAdd);
            }
        }
    }

    public void print(){ 
        System.out.println("Booked " + this.getRoomType() + "for days: " + this.getDaysBook());
    }
}
