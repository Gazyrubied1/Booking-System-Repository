import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GenerateSeats extends SeatsConstants {
    
    public static ArrayList<seat> generateSeats() {
        ArrayList<seat> Seats = new ArrayList<>();

        try {

            FileReader reader = new FileReader(Seats_File_Name);
            JSONParser parser = new JSONParser();
			JSONArray seatsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < seatsJSON.size(); ++i) {
                JSONObject seatJSON = (JSONObject)seatsJSON.get(i);

                char Row = (char)seatJSON.get(row);
                int Col = (int)seatJSON.get(col);

                Seats.add(new seat(Row, Col));
            }
            return Seats;
        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
