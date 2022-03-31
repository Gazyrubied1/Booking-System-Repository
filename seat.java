public class seat {
    private char row;
    private int col;
    //private String id;

    /**
     * Constructor of the seat method
     * @param row
     * @param col
     */
    public seat(char row, int col) {
        this.row = row;
        this.col = col;
        //this.id = id;
    }
    
    /**
     * Sets the row of the seat on the flight
     * @param row a char value that holds the row of the seat
     */
    public void setRow(char row) {
        this.row = row;
    }

    /**
     * Sets the col of the seat on the flight
     * @param col a char value that holds the row of the seat
     */
    public void setCol( int col) {
        this.col = col;
    }

    /**
     * Gets the row of the seat
     * @return a char value representing the row of the seat
     */
    public char getRow() {
        return row;
    }

    /**
     * Gets the col of the seat
     * @return an int value representing the column of the seat
     */
    public int getCol() {
        return col;
    }

    public String getId(){
        return null;
    }

}
