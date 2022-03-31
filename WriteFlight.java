import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteFlight extends FlightConstant{
    
    public static void saveFlights(ArrayList<Flight> Flights) {
        JSONArray jsonFlight = new JSONArray();


        for(int i = 0; i < Flights.size();++i) {
            jsonFlight.add(getFlight(Flights.get(i)));
        }

        try(FileWriter file = new FileWriter("place hold")) {

            file.write(jsonFlight.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFlight(Flight flight) {
        JSONObject FlightInfo = new JSONObject();
        String [] loc = new String [flight.getlocations().size()];
        for(int i = 0; i < flight.getlocations().size(); ++i) {
            loc[i] = flight.getlocations().get(i);
        }
        FlightInfo.put(Locations, loc);
        FlightInfo.put(Flight_Duration, flight.getFlightDuration());
        FlightInfo.put(DepatureDate, flight.getDepartureDate());

        JSONArray seats = new JSONArray();
        for(int i = 0; i < flight.getSeatAvailable().getSize(); ++i) {
            
            seats.add(row, flight.getSeatAvailable().getseat(i).getRow());
            seats.add(col, flight.getSeatAvailable().getseat(i).getCol());
        }
        FlightInfo.put(SeatsAvalable, seats);
        FlightInfo.put(cost, flight.getCost());
        FlightInfo.put(transfers, flight.getTransfers());
        FlightInfo.put(id, flight.getID());

        return FlightInfo;
    }

}
