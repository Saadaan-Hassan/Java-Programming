public class Date {
    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year){

        setDay(day);
        setMonth(month);
        setYear(year);

    }

    public void setDay(int day) {
        if (day>0 && day<31) {
            this.day = day;
        }
    }
    public void setMonth(int month) {
        if (month>0 && month<=12) {
            this.month = month;
        }
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getDay() + "-" + getMonth() + "-" + getYear();
    }

}
