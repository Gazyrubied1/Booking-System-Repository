public class BookHotel extends Book {
    
    private String HotelName;
    private String location;
    private String guest;
    private RoomType roomType;
    private HotelBrands Brand;
    
    public BookHotel(String book, Boolean cancel, String date, String type, String HotelName, 
        String location, String guest, RoomType roomType, HotelBrands brands) {
        super(book, cancel, date, type);
        this.HotelName = HotelName;
        this.location = location;
        this.guest = guest;
        this.roomType = roomType;
        this.Brand = brands;
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

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public void setBrand(HotelBrands brands) {
        this.Brand = brands;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public HotelBrands getBrand() {
        return Brand;
    }
    
    public void Book(){
        
    }


}
