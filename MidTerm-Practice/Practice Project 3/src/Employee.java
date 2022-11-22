public abstract class Employee implements Comparable<Employee>{
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%d %s", id, name);
    }

    @Override
    public int compareTo(Employee o){
        if (this.id<o.id)
            return -1;
        else if (this.id > o.id)
            return 1;
        else
            return 0;
    }

    public abstract double calculatePay();
}
