import java.util.ArrayList;

public class seats {
    private static seats seats = null;
    private static ArrayList<seat> seatList = new ArrayList<seat>();

    private seats() {
        seatList = GenerateSeats.generateSeats();
    }

    public static seats getInstance() {
        if(seats == null) {
            seats = new seats();
        }
        return seats;
    }

    public void addSeat(char row, int col, String Id) {
        seatList.add(new seat(row, col));
    }
}
