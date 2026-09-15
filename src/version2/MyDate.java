package version2;

public class MyDate {
    private int date;
    private int day;
    private int month;
    private int year;

    public void myDate(){
        this(0,0,0,0);
    }
    public MyDate(int date, int day, int month, int year) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isMonth(int currentMonth){
        return month == currentMonth;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%02d", month, date, year);
    }
}
