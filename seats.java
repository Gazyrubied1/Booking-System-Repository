public class seats {
    private char row;
    private int col;

    public seats(char row, int col) {
        this.row = row;
        this.col = col;
    }
    public void setRow(char row) {
        this.row = row;
    }

    public void setCol( int col) {
        this.col = col;
    }

    public char getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
