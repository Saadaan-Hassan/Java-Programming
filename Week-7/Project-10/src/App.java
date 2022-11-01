public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Vehicle v1 = new Vehicle() {

            @Override
            public void drive() {
                // TODO Auto-generated method stub
                
            }
            
        };
        v1.dispaly();

        Vehicle v2 = new Car();
        v2.dispaly();
        v2.drive();;
    }

    // Use Abstract Word 
    // Abstract methods can be one , more, none in any abstract or non abstract class
    // Can not create variable of abstract class
    // It is nessessary to override the the abstract methods otherwise it gives an error

    //Polymorphesim
    //Poly -> many
    //morphesim -> shapes

    //Polymorphesim is also called late binding

    //Methods overloading is called early binding


}
