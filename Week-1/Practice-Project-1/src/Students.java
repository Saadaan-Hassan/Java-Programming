public class Students {
    String name;
    int age;
    float cgpa;

    circle sc1 = new circle();

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setAge(int a){
        age = a;
    }

    public int getAge(){
        return age;
    }

    public void setCGPA(float c){
        cgpa = c;
    }

    public float getCGPA(){
        return cgpa;
    }

    public void getStudArea(){
        sc1.getArea();
    }
}
