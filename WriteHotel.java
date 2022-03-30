import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteHotel extends HotelConstants {
 
    public static void saveHotels(ArrayList<Hotels> Hotel) {
        JSONArray jsonHotel = new JSONArray();

        for(int i = 0; i < Hotel.size(); ++i) {
            jsonHotel.add(getHotel(Hotel.get(i)));
        }

        try(FileWriter file = new FileWriter("temp file")) {

            file.write(jsonHotel.toJSONString());
            file.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getHotel(Hotels hotel){
        JSONObject hotelDetails = new JSONObject();
        hotelDetails.put(Const_State, hotel.getState());
        hotelDetails.put(Const_Brand, hotel.getBrands());
        
        
        JSONArray HotelroomJSON = new JSONArray();
        for(int i = 0; i <hotel.getRooms().size();++i) {
            HotelRoom room = hotel.getRooms().get(i);
            HotelroomJSON.add(Const_Brand, room.getRoomType());
            HotelroomJSON.add(Const_ID, room.getId());

        JSONArray BookedRoomJSON = new JSONArray();
            for(int ii = 0; ii < room.getDaysBook().size();++i) {
                DaysBooked book = room.getDaysBook().get(ii);
                BookedRoomJSON.add(Const_Year, book.getYear());
                BookedRoomJSON.add(Const_days, book.getDayRange()); 
            }         
            HotelroomJSON.add(Const_bookedDays, BookedRoomJSON);   
        }
        hotelDetails.put(Const_rooms, HotelroomJSON);
        return hotelDetails;
    }

    
}
