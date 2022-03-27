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
            ArrayList<String> location;
            for(int ii = 0; ii < depatureLocation.length; ++ii) {
                location.add(depatureLocation[i]);
            }
            int Flight_Duration = (int)flightJSON.get(Flight_Duration);
            String depatureDate = (String)flightJSON.get(DepatureDate);
            ArrayList<seat>SeatsAvalable = (ArrayList<seat>)flightJSON.get(SeatsAvalable);
            int cost = (int)flightJSON.get(cost);
            int trans = (int)flightJSON.get(transfers);
            String id = (String)flightJSON.get(id);

            flights.add(new Flight(location, Flight_Duration, depatureDate, SeatsAvalable,cost,trans,id));
        }
        return flights;
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
    }
}
