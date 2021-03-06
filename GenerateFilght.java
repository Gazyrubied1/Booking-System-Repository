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

            JSONArray locatiArray = (JSONArray)flightJSON.get(Locations); 
            String [] depaturelocations = new String [locatiArray.size()];
            for(int ii = 0; ii < locatiArray.size();++ii){
                depaturelocations[ii] = (String)locatiArray.get(ii);
            }
            ArrayList<String> location = new ArrayList<String>();
           
            for(int ii = 0; ii < depaturelocations.length; ++ii) {
                location.add(depaturelocations[ii]);
            }

            int flight_Duration = ((Long)flightJSON.get(Flight_Duration)).intValue();  // 2
            String depatureDate = (String)flightJSON.get(DepatureDate);  // 3
            JSONArray seatsAvalableJSON = (JSONArray)flightJSON.get(SeatsAvalable);
            ArrayList<seat> seatsAvailable = new ArrayList<>();  // 4

            for(int j = 0; j < seatsAvalableJSON.size(); ++j) {
                JSONObject seatJson = (JSONObject)seatsAvalableJSON.get(j);
                
                String temp = (String)seatJson.get(col);
                char colToAdd = temp.charAt(0);
                Long rowToAdd = ((Long)seatJson.get(row));
                //String idToAdd = (String)seatJson.get(id);
                seat ToAdd = new seat(colToAdd,(rowToAdd.intValue()));
                seatsAvailable.add(ToAdd);
            }
            seats seats = new seats(seatsAvailable);
            int cos = ((Long)flightJSON.get(cost)).intValue();  // 5
            int trans = location.size();  // 6
            String Id = (String)flightJSON.get(id);  //7
            flights.add(new Flight(location, flight_Duration, depatureDate, seats, cos, Id));
        }
        return flights;
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
    }
}
