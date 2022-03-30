import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//import netscape.javascript.JSObject;

public class GenerateFilght extends FlightConstant {
    
    public static ArrayList<Flight> Generateflight() {
    ArrayList<Flight> flights = new ArrayList<>();


    try{
        FileReader reader = new FileReader(Flight_File_name);
        //JSONParser parser = new JSONParser();
		JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);

        for(int i = 0; i < flightsJSON.size(); ++i) {

            JSONObject flightJSON = (JSONObject)flightsJSON.get(i);

            String[] depatureLocation = (String[])flightJSON.get(Locations);  
            ArrayList<String> location = new ArrayList<String>();
           
            for(int ii = 0; ii < depatureLocation.length; ++ii) {
                location.add(depatureLocation[i]);
            }

            int flight_Duration = (int)flightJSON.get(Flight_Duration);  // 2
            String depatureDate = (String)flightJSON.get(DepatureDate);  // 3
            JSONArray seatsAvalableJSON = (JSONArray)flightJSON.get(SeatsAvalable);
            ArrayList<seat> seatsAvailable = new ArrayList<>();  // 4

            for(int j = 0; j < seatsAvalableJSON.size(); ++j) {
                JSONObject seatJson = (JSONObject)seatsAvalableJSON.get(j);

                
                char colToAdd = (char)seatJson.get(col);
                int rowToAdd =(int)seatJson.get(row);
                //String idToAdd = (String)seatJson.get(id);
                seat ToAdd = new seat(colToAdd,rowToAdd);
                seatsAvailable.add(ToAdd);
            }
            seats seats = new seats(seatsAvailable);
            int cos = (int)flightJSON.get(cost);  // 5
            int trans = (int)flightJSON.get(transfers);  // 6
            String Id = (String)flightJSON.get(id);  //7
            flights.add(new Flight(location, flight_Duration, depatureDate, seats, cos, trans, Id));
        }
        return flights;
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
    }
}
