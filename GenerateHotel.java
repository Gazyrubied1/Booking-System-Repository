import java.io.FileReader;
import java.time.Year;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import netscape.javascript.JSObject;

public class GenerateHotel extends HotelConstants {
    
    public static ArrayList<Hotels> GenerateRooms() {
        ArrayList<Hotels> hotel = new ArrayList<>();

        try{ 
            FileReader reader = new FileReader(Hotel_Room_File);
            JSONParser parser = new JSONParser();
			JSONArray HotelsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i  = 0; i < HotelsJSON.size(); ++i) {
                JSONObject HotelJSON = (JSObject) RoomsJSON.get(i);
                String state = HotelJSON.get(Const_State);  //1  state
                HotelBrands brand = HotelJSON.get(Const_Brand);  //2 Brand


                JSONArray RoomsJSON = (JSONArray)HotelJSON.get(Const_rooms);  // 3 arraylist hotelroom
                ArrayList<HotelRoom> RoomsToAdd = new ArrayList<>();
                for(int ii = 0; ii < RoomsJSON.size();++ii) {
                    RoomType type = RoomsJSON.get(Const_ROOM_TYPE);  //  4 room type
                    String RoomID = RoomsJSON.get(Const_ID);  // 5  room id

                    ArrayList<DaysBooked> DaysBookToAddRoom = new ArrayList<>();
                    JSONArray bookedDaysJSON = (JSONArray)HotelsJSON.get(Const_rooms);  // 6 arraylist day booked
                    for(int iii = 0; iii < bookedDaysJSON.size(); ++i) {
                        JSONObject DaysJSON = (JSONObject)bookedDaysJSON.get(iii);

                        int AddYear = (int)DaysJSON.get(Const_Year);  //  7 year
                        int [] Days = (int [])DaysJSON.get(Const_days);
                        DaysBooked bookedDaysToAddList = new DaysBooked(AddYear, Days);
                        DaysBookToAddRoom.add(bookedDaysToAddList);
                    }
                    HotelRoom RoomToaddList = new HotelRoom(type, DaysBookToAddRoom, RoomID);
                    RoomsToAdd.add(RoomToaddList);
                }

                // daybook 
                Hotels toAdd = new Hotels(RoomsToAdd, state, brand);
                hotel.add(toAdd);
               // ArrayList<HotelRoom> rooms, String state, HotelBrands brand
            }
            return hotel;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
