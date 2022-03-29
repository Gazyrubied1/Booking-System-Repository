public class DaysBooked {
    private int year;
    private int[] dayRange;
    private String id;


    public DaysBooked(int year, int[] dayRange, String id) { // TODO Possibly remove the id parameter from the constructor
        this.year = year;
        this.dayRange = dayRange;
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDayRange(int [] dayRange) {
        this.dayRange = dayRange;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getYear() {
         return year;
    }

    public int [] getDayRange () {
        return dayRange;
    }

    public String getID() {
        return id;
    }

}
