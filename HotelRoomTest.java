import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HotelRoomTest {
   
    @Test
    public void testAddDaysWorks(){
        int [] days = {1,2,3,4,34,35,36,37,345};
        int year = 2022;
        String ids = "12345";
        DaysBooked temp = new DaysBooked(year, days);
        ArrayList<DaysBooked> day =new ArrayList<>();
        HotelRoom test = new HotelRoom(RoomType.King_Bed, day, "id");
        HotelRoom compair = test;
        int [] add = {38,39,40};
        ArrayList<DaysBooked> num =test.getDaysBook();
        test.addDays(add, year);
        assertSame(test.getDaysBook().get(0).getDayRange(), num.get(0).getDayRange(), "false - the two are still same");
    }

    @Test
    public void testAddDaysFails(){
        int [] days = {1,2,3,4,34,35,36,37,345};
        int year = 2022;
        String ids = "12345";
        DaysBooked temp = new DaysBooked(year, days);
        ArrayList<DaysBooked> day =new ArrayList<>();
        HotelRoom test = new HotelRoom(RoomType.King_Bed, day, "id");
        HotelRoom compair = test;
        int [] add = {38,39,400};
        ArrayList<DaysBooked> num =test.getDaysBook();
       DaysBooked toAdd = new DaysBooked(2022, new int [] {400, 401});
        num.add(toAdd);
        test.addDays(add, year);
        
        assertNotSame(test.getDaysBook().get(0).getDayRange(), num.get(0).getDayRange(), "false - the two are still same");
    }
}
