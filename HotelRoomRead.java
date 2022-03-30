import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class HotelRoomRead {
    public static void main(String[] args) throws Exception {
        File f = new File(HotelRoom.json");
        if (f.exists()){
            InputStream is = new FileInputStream("Hotel.json");
            String HotelTxt = IOUtils.toString(is, "");
            System.out.println(json);
            JSONObject json = new JSONObject(HotelTxt);       
            String a = json.getString
        }
    }
}