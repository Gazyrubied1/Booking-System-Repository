import java.util.ArrayList;

import Library.*;
import java.util.*;

class BookFlightTest {
    public void testSearchStartLocation() { // tests if the method correctly searches through the list of locations and sees that there are two locations that match the specific starting location
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertEquals(flight.searchStartLocation("loc1", new ArrayList<String>()).size(), 2);
    }
    public void testSearchLocation() { // tests if the method correctly searches through the list of locations and sees that there are three possible flights to be made with the list of locations
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc1", "loc2", "loc2", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertEquals(flight.searchLocation("loc1", "loc2", new ArrayList<String>()).size(), 3);
    }

    public void testSearchEndLocation() { // tests if the method correctly searches through the list of locations and sees that there is one possible flight that can be made with the specified start and end locations
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertEquals(flight.searchEndLocation("loc2", new ArrayList<String>()).size(), 1);
    }

    public void testcheckBlackList() { // test if the method correctly searches through the list of blacklisted locations and sees that the blacklisted locations are in the list of specified locations (therefore returning false)
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertFalse(flight.checkBlackList(new ArrayList<>(Arrays.asList("loc1", "loc3")),0));
    }

    public void testPrintout() {

    }

    public void testSearchDate() { // test if the method correctly searches through the list of flights and finds the flights that are on a specific day
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertEquals(flight.searchDate("04/11/2022", new ArrayList<String>()).size(), 1);
    }

    public void testBookFlight() {
        BookFlight flight = new BookFlight();
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("loc1", "loc1", "loc2", "loc3"));
        flights.add(new Flight(locations, 3, "04/11/2022", new seats(new ArrayList<seat>()), 100, "test"));
        AssertFalse(flight.bookFlight(new ArrayList<>(Arrays.asList("loc1", "loc3")),0));
    }
}