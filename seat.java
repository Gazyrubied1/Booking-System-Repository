public class seat {
    private char row;
    private int col;
    private String id;

    public seat(char row, int col, String id) {
        this.row = row;
        this.col = col;
        this.id = id;
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

    public String getId() {
        return id;
    }
}
