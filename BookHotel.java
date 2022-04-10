import java.util.ArrayList;
import java.util.Scanner;


public class BookHotel extends Book {

    //private String location;
    private ArrayList<Hotels> HotelList = new ArrayList<Hotels>();
   
   
    public BookHotel(ArrayList<Hotels> HotelList) {
        this.HotelList = HotelList;
    }


    /**
     * Sets the location of the hotel to an inputted String
     * 
     * @param Location the hotel's new location
     */
    
    // public void setLocation(String Location) {
    //    this.location = Location;
    //}

    /**
     * Gets the location of the hotel
     * 
     * @return a String that holds the location of the hotel
     */
   // public String getLocation() {
    //    return location;
    //}


    /**
     * Gets the list of hotels
     * 
     * @return an ArrayList that holds all of the available hotels
     */

    public ArrayList<Hotels> getHotelList() {
        return HotelList;
    }

    public void BookHotelRoom(ArrayList<Hotels> Hotels, RegisteredUser user) {
        Scanner KeyBoard = new Scanner(System.in);
        System.out.println("Enter the number of the hotel you would like"); // prints hotels (fix)
        int index = KeyBoard.nextInt();
        Hotels current = Hotels.get(index);
        String toAddLoc = Hotels.get(index).getState();
        for (int i = 0; i < current.getRooms().size()-1; ++i) {
            System.out.println("Room: " + i + ". " + current.getRooms().get(i).getRoomType().toString());
        }

        System.out.println("Enter the number of the room you would like");
        int type = KeyBoard.nextInt();
        HotelRoom room = current.getRooms().get(type);

        System.out.println("What days and year would you like to book for? Enter the month, then the day, then the year of your start date");
        int[] timeFrame = new int[3];
        int[] endDays = new int[3];
        for (int i = 0; i < 3; ++i) {
            timeFrame[i] = KeyBoard.nextInt();
        }
        System.out.println("Enter the month, then the day, then the year of the end date of your hotel stay.");
        for (int i = 0; i < 3; ++i) {
            endDays[i] = KeyBoard.nextInt();
        }
        KeyBoard.close();
        int[] toAddDays = CalcTime(timeFrame, endDays);
        int conflix = 0;
        for (int i = 0; i < room.getDaysBook().size(); ++i) {
            int temp[] = room.getDaysBook().get(i).getDayRange();
            int size = temp.length;
            for (int ii = 0; ii < size && ii < toAddDays.length; ++ii) {
                if (temp[ii] == toAddDays[ii]) {
                    System.out.println(toAddDays[ii] + " is already booked");
                    conflix++;
                    break;
                }
            }
        }
        String StartD = timeFrame[0] + "/" + timeFrame[1] + "/" + timeFrame[2];
        String endD = endDays[0] + "/" + endDays[1] + "/" + endDays[2];
        if (conflix == 0) {
            room.addDays(toAddDays, timeFrame[2]);

        }
    ArrayList<String> locations = new ArrayList<String>();
    locations.add(toAddLoc); 
    Ticket temp = user.addHotelTicket(locations,StartD,endD, this,room.getRoomType(), current.getBrands());  
    temp.printInfo(); 
    KeyBoard.close();
    
    // TODO fix up to work with loop 
}

    private int[] CalcTime(int[] time, int[] last) {
        // if (time[0] < 1 || time[0] > 12 || time[4] < 0 || time[4] > 12) {
        // }
        // invalid input months

        // int fDay = dayNum(time);

        // int lDay = dayNum(last);
        // int dif = last[3] - time[3];
        // if (dif != 0 && last[3] > time[3]) {
        //     dif *= 365;
        // } else {
        //     dif = 1;
        //     ;
        // }
        // lDay += dif;
        // int num = lDay - fDay;
        // int[] days = new int[num];
        // for (int i = fDay, j = 0; i <= lDay; ++i, ++j) {
        //     days[j] = i;
        // }
        // return days;
        return new int[2];
    }

    private int dayNum(int[] time) {
        int first = -1;
        switch(time[0]) {
            case 1:
                first = 0; // 31
                first += time[1];
                break;
            case 2:
                first = 31; // 28
                first += time[1];
                break;
            case 3:
                first = 59; // 31
                first += time[1];
                break;
            case 4:
                first = 90; // 30
                first += time[1];
                break;
            case 5:
                first = 120; // 31
                first += time[1];
                break;
            case 6:
                first = 151; // 30
                break;
            case 7:
                first = 181; // 31
                first += time[1];
                break;
            case 8:
                first = 212;
                first += time[1]; // 31
                break;
            case 9:
                first = 242;
                first += time[1]; // 30
                break;
            case 10:
                first = 272;
                first += time[1]; // 31
                break;
            case 11:
                first = 303; // 30
                first += time[1];
                break;
            case 12:
                first = 333;
                first += time[1];// 31
                break;  
            default:
                break;
        }
        if (first > 365 || first < 0) { // check year
            first = -1;
        }
        return first;
    }

    /**
     * Searches through the list of hotels by state and returns the hotels from that
     * state
     * 
     * @param State A String that holds the value of a state's two letter
     *              abbreviation
     * @return an ArrayList of hotels from that state
     */
    public ArrayList<Hotels> SearchHotel(String State) {
        ArrayList<Hotels> toReturn = new ArrayList<Hotels>();
        for (int i = 0; i < HotelList.size(); ++i) {
            if (State.equalsIgnoreCase(HotelList.get(i).getState())) {
                System.out.println(i + ". " + HotelList.get(i).getBrands().toString() + " ");
                toReturn.add(HotelList.get(i));
            }
        }
        return toReturn;
    }

    /**
     * Searches through the list of hotels by state and brand
     * 
     * @param State a String that holds the state in form of its two letter
     *              abbreviation
     * @param brand the hotel brand as a String
     * @return An ArrayList of found Hotels
     */
    public ArrayList<Hotels> SearchHotel(String State, String brand) {
        ArrayList<Hotels> toReturn = new ArrayList<Hotels>();
        String UseBrand = brand.toString();
        for (int i = 0; i < HotelList.size(); ++i) {
            if (State.equalsIgnoreCase(HotelList.get(i).getState())) {
                if (UseBrand.equalsIgnoreCase(HotelList.get(i).getBrands().toString())) {
                    System.out.println(i + ". " + HotelList.get(i).toString() + " ");
                    toReturn.add(HotelList.get(i));
                }
            }

        }
        return toReturn;
    }


}
