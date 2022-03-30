import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GenerateDaysBooked extends DaysBookedConstants {
   
    public static ArrayList<DaysBooked> loadDaysBooked() {
       ArrayList<DaysBooked> daysBooked = new ArrayList<DaysBooked>();

       try{
           FileReader reader = new FileReader(Days_Booked_File);
           JSONParser parser = new JSONParser();
           JSONArray DayBookedJSON = (JSONArray) new JSONParser().parse(reader);

           for(int i = 0; i < DayBookedJSON.size(); ++i) {
            JSONObject DaysBookedJSON = (JSONObject)DayBookedJSON.get(i);
            int Year = (int)DaysBookedJSON.get(year);
            int [] dayRange = (int[])DaysBookedJSON.get(days);
            String ID = (String)DaysBookedJSON.get(id);
            
            daysBooked.add(new DaysBooked(Year, dayRange, ID));
           }
           return daysBooked;
       } catch(Exception e){
           e.printStackTrace();
       }

        return null;
        }
    }
}