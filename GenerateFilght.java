import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import netscape.javascript.JSObject;

public class GenerateFilght extends FlightConstant {
    
    public static ArrayList<Flight> Generateflight() {
    ArrayList<Flight> flights = new ArrayList<>();


    try{
        FileReader reader = new FileReader(Flight_File_name);
        JSONParser parser = new JSONParser();
		JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

        for(int i = 0; i < flightsJSON.size(); ++i) {

            JSONObject flightJSON = (JSONObjct)flightsJSON.get(i);

            String[] depatureLocation = (String[])flightJSON.get(Locations);  
            ArrayList<String> location;  // 1 
           
            for(int ii = 0; ii < depatureLocation.length; ++ii) {
                location.add(depatureLocation[i]);
            }

            int Flight_Duration = (int)flightJSON.get(Flight_Duration);  // 2
            String depatureDate = (String)flightJSON.get(DepatureDate);  // 3
            JSONArray seatsAvalableJSON = (JSONArray)flightJSON.get(SeatsAvalable);
            ArrayList<seat> seatsAvailable = new ArrayList<>();  // 4

            for(int j = 0; j < seatsAvalableJSON.size(); ++j) {
                JSONObject seatJson = (JSONObjct)seatsAvalableJSON.get(j);

                
                char colToAdd = (char)seatJson.get(col);
                int rowToAdd =(int)seatJson.get(row);
                String idToAdd = (String)seatJson.get(id);
                seat ToAdd = new seat(colToAdd,rowToAdd,idToAdd);
                seatsAvailable.add(ToAdd);
            }
            seats seats = new seats(seatsAvailable);
            int cost = (int)flightJSON.get(cost);  // 5
            int trans = (int)flightJSON.get(transfers);  // 6
            String id = (String)flightJSON.get(id);  //7
            flights.add(new Flight(location, Flight_Duration, depatureDate, seats,cost,trans,id));
            // ArrayList<String> locations, int FlightDuration, String DepartureDate, seats SeatAvailable, int cost, int transfers, String id)
        }
        return flights;
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
    }
}
