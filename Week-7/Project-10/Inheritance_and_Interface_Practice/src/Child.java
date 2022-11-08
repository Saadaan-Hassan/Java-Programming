/**
 * Child
 */
public class Child extends Parent{

    public void childCall(){
        System.out.println("I am child class");
    }

    @Override
    public void display() {
        
        System.out.println("I am display Method in child");
    }

    @Override
    public void biryani(){
        System.out.println("I ate Biryani.\nYummmmm.");
    }
    
    @Override
    public void salad() {
        System.out.println("I ate salad.\nEeuuuuu.");
        
    }
    
    @Override
    public void spoon() {
        System.out.println("I ate Spoon.\nAiiiiiii.");
        
    }
    
}