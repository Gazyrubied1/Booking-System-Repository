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

            String depatureLocation = (String)flightJSON.get(Depature_Location);
            String arrivalLocation = (String)flightJSON.get(Arrival_Location);
            int Flight_Duration = (int)flightJSON.get(Flight_Duration);
            String depatureDate = (String)flightJSON.get(DepatureDate);
            ArrayList<seats> SeatsAvalable = (ArrayList<seats>)flightJSON.get(SeatsAvalable);
            int cost = (int)flightJSON.get(cost);
            String id = (String)flightJSON.get(id);

            flights.add(new Flight(depatureLocation, arrivalLocation, Flight_Duration, depatureDate, SeatsAvalable, cost));
        }
        return flights;
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
    }
}
