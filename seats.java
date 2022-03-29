import java.util.ArrayList;

public class seats {
    private ArrayList<seat> seatList = new ArrayList<seat>();

    /**
     * Constructor for the seats class
     */
    public seats() {
        seatList = GenerateSeats.generateSeats();
    }

    public ArrayList<seat> getRowSeat(int index){
        if(index == seatList.size())
            return null;
        ArrayList<seat> toReturn = new ArrayList<seat>();
        for(int i = index; i < seatList.size(); ++i) {
            if(seatList.get(i).getCol() <= 5 && seatList.get(i) != null){
                toReturn.add(seatList.get(i));
            }
        }
        return toReturn;
    }

    /**
     * Gets the seat of a specified index
     * @param index the index of the seat to be searched for
     * @return the seat that was searched for at the given index
     */
    public seat getseat(int index){
        return seatList.get(index);
    }

    /**
     * Adds a seat to the list of seats 
     * @param row the row of the new seat
     * @param col the col of the new seat
     * @param Id the id of the new seat
     */
    public void addSeat(char row, int col, String Id) {
        seatList.add(new seat(row, col));
    }

    /**
     * Removes a seat from a list of seats
     * @param row the row of the seat to be removed
     * @param col the col of the seat to be removed
     * @param Id the id of the seat to be removed
     * @return null if the inputted seat is not found and returns the seat that was removed
     */
    public seat removeSeat(char row, int col, String Id) {
       for(int i = 0; i < seatList.size(); ++i){
        if(seatList.get(i).getId().equals(Id)){
            seat temp = seatList.remove(i);
            return temp;
        }
       }
       return null; 
    }

    /**
     * Gets the size of the list that stores seats
     * @return an ArrayList<seat>
     */
    public int getSize() {
        return seatList.size();
    }
}
