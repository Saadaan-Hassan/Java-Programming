public class Dates {
    private int day;
    private int month;
    private int year;

Dates(int day, int month, int year) {
        setDay(day);    
        setMonth(month);
        setYear(year);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day > 0 && day <= 31) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 0 && month <= 12) {
            this.month = month;

        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0)
            this.year = year;
    }

    @Override
    public String toString() {
        return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
    }

    public boolean equals(Dates obj){
        boolean a = false;
        if(this.day == obj.day && this.month == obj.month && this.year == obj.year)
            a = true;
        return a;
    }

    public Object clone(){
        Object temp;
        temp = new Dates(this.day, this.month, this.year);
        return temp;
    }
    

}
