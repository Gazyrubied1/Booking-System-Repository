import java.util.ArrayList;

public class seats {
    private ArrayList<seat> seatList = new ArrayList<seat>();

    public seats(ArrayList<seat> seats) {
        this.seatList = seats;
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

    public seat getseat(int index){
        return seatList.get(index);
    }
    public void addSeat(char row, int col, String Id) {
        seatList.add(new seat(row, col, Id));
    }

    public seat removeSeat(char row, int col, String Id) {
       for(int i = 0; i < seatList.size(); ++i){
        if(seatList.get(i).getId().equals(Id)){
            seatList.remove(i);
            return seatList.get(i);
        }
       }
       return null; 
    }

    public int getSize() {
        return seatList.size();
    }
}
