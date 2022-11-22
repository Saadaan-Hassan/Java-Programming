import java.lang.reflect.Method;
import java.security.SecureRandom;

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        //Using random
////        SecureRandom rand = new SecureRandom();
////
////        for (int i = 0; i <20; i++) {
////            System.out.println(rand.nextInt(5));
////        }
//
//        //Shallow Copy and Deep Copy
//        Calculate c1 = new Calculate(12,13,3,5,6,4);
//        System.out.println(c1);
//
//        Calculate c2 = c1;  // Shallow Copy
//        System.out.println(c2);
//
////        c1.setLength(14);
////        System.out.println(c1);
////        System.out.println(c2);
//
//        Calculate c3 = new Calculate(c2);   // Deep Copy
//
//        c2.setLength(14);
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);
//
//        Calculate c4 = (Calculate) c1.clone();  // Deep copy through clone object
//        System.out.println(c4);
//        c1.setLength(20);
//        System.out.println(c1);
//        System.out.println(c4);
//
//        // Displaying declare methods in a Class
//        Method methods[] = Calculate.class.getDeclaredMethods();
//        int i = 1 ;
//        for (Method m :
//                methods) {
//            System.out.printf("%d %s\n", i++, m);
//        }
//
//        Method method2 [] = String.class.getDeclaredMethods();
//        i=1;
//        for (Method m :
//                method2) {
//            System.out.printf("%d %s\n", i++, m);
//        }
//
//        // Using Equals Method
//
//        System.out.println(c1.equals(c2));
//        System.out.println(c1.equals(c3));
//        System.out.println(c1.equals(c4));
//        System.out.println(c3.equals(c3));


//        A a = new A();
//        B b = new B();
//        C c = new C();
//        B b2 = new C();
//        A a1 = new C();
//        A a2 = new B();









//        A a1 = new A();
//        B b1 = new B();
//
//        b1.hide();
//
//        A a1 = new B();
//        a1.



//        A a1 = new A();
//        A a2 = new A(a1);
//        A a3 = a1;
//
//        a1.length = 12;
//
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3);






//    }

//    class A{
//        static int a=5;
//        static{
//            System.out.println("Static of A");
//            a++;
//        }
//        {
//            System.out.println("non-Static of A");
//        }
//    }
//    class B extends A{
//
//        static{
//            System.out.println("Static of B");
//        }
//        B(){
//            a++; // 7
//            //super()
//            System.out.println("Constructor of B");
//        }
//    }
//    class C extends B{
//        int b = 4;
//        {
//            System.out.println("non-Static of C");
//        }
//        C(){
//
//            b = b + super.a;
//            System.out.println("Constructor of C");
//        }
//    }
//    public class Main{
//        public static void main(String[] args) {
//            // C c=new C();
//            C b=new C();
//            System.out.println(b.b);
//
//        }
//    }

