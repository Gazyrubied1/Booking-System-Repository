import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import UUID.id;
import netscape.javascript.JSObject;

public class GenerateHotel extends HotelConstants {
    
    public static ArrayList<HotelRoom> GenerateRooms() {
        ArrayList<HotelRoom> rooms = new ArrayList<>();

        try{ 
            FileReader reader = new FileReader(Hotel_Room_File);
            JSONParser parser = new JSONParser();
			JSONArray RoomsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i  = 0; i < RoomsJSON.size(); ++i) {

                JSONObject roomJSON = (JSObject) RoomsJSON.get(i);
                
                
                RoomType roomType = (RoomType)roomJSON.get(rooms);
                ArrayList<DaysBooked> daysBooked = (ArrayList<DaysBooked>)roomJSON.get(rooms);
                String ID = (String)roomJSON.get(ID);

                rooms.add(new HotelRoom(roomType, daysBooked,ID));
            }
            return rooms;

        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
