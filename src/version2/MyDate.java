package version2;

public class MyDate {
    private int date;
    private int day;
    private int month;
    private int year;

    public MyDate(){

        this(0,1,1,2000);
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
        if (day < 1 || day > 31){
            System.out.println("Invalid day\n");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12){
            System.out.println("Invalid month\n");
        }
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

    public void displayDate(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%02d", month, date, year);
    }
}
