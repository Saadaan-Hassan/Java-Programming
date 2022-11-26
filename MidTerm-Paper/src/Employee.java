public abstract class Employee implements Comparable<Employee>{
    private Date dateOfHiring;
    private String name;

    public Employee(Date dateOfHiring, String name) {
        this.dateOfHiring = dateOfHiring;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfHiring() {
        return dateOfHiring;
    }

    public void setDateOfHiring(Date dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }


    //Abstract Method
    public abstract double earnings();

    @Override
    public String toString() {
        return String.format("%s %s", name, dateOfHiring);
    }

    @Override
    public int compareTo(Employee emp){
        return this.name.compareTo(emp.name);
    }
}
