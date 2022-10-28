public class Person {
    private String firstName;
    private String lastName;
    private Date dob ;

    Person(String firstName, String lastName, Date dob){

        setFirstName(firstName);
        setLastName(lastName);
        setDob(dob);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getFirstName() + " " + getLastName() + " date of birth is: " + getDob();
    }
}
