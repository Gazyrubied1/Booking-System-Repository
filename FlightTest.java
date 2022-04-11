import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Verifier;
import org.junit.jupiter.*;
class FlightTest{
    ArrayList<Flight> flights = new ArrayList<>();
    
    @BeforeAll
    public void setUpClass(){
    flights = GenerateFilght.Generateflight();
    }

    @Test
    public void testIsFlightCancled(){
    boolean test = flights.get(0).isFlightCanceled();
    Verifier verifier;
    verify(flights.get(0).isFlightCanceled());
    }

}
