import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Verifier;
public class seatstest {
    

    @Test
    public void testgetsizeTrue(){
        seat seat1 = new seat('a', 1);
        seat seat2 = new seat('a', 1);
        seat seat3 = new seat('a', 1);
        seat seat4 = new seat('a', 1);
        seat seat5 = new seat('a', 1);
        seat seat6 = new seat('a', 1);
        ArrayList<seat> add = new ArrayList<>();
        add.add(seat1);
        add.add(seat2);
        add.add(seat3);
        add.add(seat4);
        add.add(seat5);
        add.add(seat6);
        seats seats = new seats(add);
        assertSame(6, seats.getSize(),"Falue - not the same");
    }

    @Test
    public void testgetsizeFalse(){
        seat seat1 = new seat('a', 1);
        seat seat2 = new seat('a', 1);
        seat seat3 = new seat('a', 1);
        seat seat4 = new seat('a', 1);
        seat seat5 = new seat('a', 1);
        seat seat6 = new seat('a', 1);
        ArrayList<seat> add = new ArrayList<>();
        add.add(seat1);
        add.add(seat2);
        add.add(seat3);
        add.add(seat4);
        add.add(seat5);
        seats seats = new seats(add);
        assertNotSame(7, seats.getSize(),"Falue - not the same");
    }

    @Test
    public void testAddSeat(){
        seat seat1 = new seat('a', 1);
        seat seat2 = new seat('a', 1);
        seat seat3 = new seat('a', 1);
        seat seat4 = new seat('a', 1);
        seat seat5 = new seat('a', 1);
        seat seat6 = new seat('a', 1);
        
        ArrayList<seat> add = new ArrayList<>();
        add.add(seat1);
        add.add(seat2);
        add.add(seat3);
        add.add(seat4);
        add.add(seat5);
        add.add(new seat('w', 2));
        seats seats = new seats(add);
        seats seatscheck = seats;
        seatscheck.addSeat('w', 2, "Id");
        add.add(new seat('w', 2));
        assertEquals(seats, seatscheck,"Falue - not the same");
    }

    @Test
    public void testRemoveSeatTrue(){
        seat seat1 = new seat('a', 1);
        seat seat2 = new seat('a', 1);
        seat seat3 = new seat('a', 1);
        seat seat4 = new seat('a', 1);
        seat seat5 = new seat('a', 1);
        seat seat6 = new seat('a', 1);
        
        ArrayList<seat> add = new ArrayList<>();
        add.add(seat1);
        add.add(seat2);
        add.add(seat3);
        add.add(seat4);
        add.add(seat5);
        add.add(new seat('w', 2));
        seats seats = new seats(add);
        seats seatscheck = seats;
        seats.removeSeat('w', 2, "id");
        assertSame(seats, seatscheck,"Falue - the two are still same");
    }

    @Test
    public void testRemoveSeatFalse(){
        seat seat1 = new seat('a', 1);
        seat seat2 = new seat('a', 1);
        seat seat3 = new seat('a', 1);
        seat seat4 = new seat('a', 1);
        seat seat5 = new seat('a', 1);
        
        ArrayList<seat> add = new ArrayList<>();
        add.add(seat1);
        add.add(seat2);
        add.add(seat3);
        add.add(seat4);
        add.add(seat5);
        add.add(new seat('w', 2));
        seats seats = new seats(add);
        seats seatscheck = seats;
        seats.removeSeat('w', 2, "id");
        assertNotSame(seats, seatscheck,"Falue - the two are still same");
    }
    
}
