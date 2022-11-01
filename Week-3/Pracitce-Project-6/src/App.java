public class App {
    public static void main(String[] args) throws Exception {
        
        
        Products productsList[] = new Products[100];
        // productsList[2] = new Products(null, null, 0, null);
        
        productsList[0] = new Products(0,"Keyboard", "Best keyboard ever.", 12.34f, new Dates(12, 10, 2002));
        productsList[1] = new Products(1,"Keyboard", "Best keyboard ever.", 12.34f, new Dates(12, 10, 2002));

        // System.out.println(productsList[0]);
        for (int i = 0; i < productsList.length; i++) {
            if (productsList[i] != null) {
                System.out.println(productsList[i]);
            }
        }

        Dates d1 = new Dates(1, 3, 2003);
        Dates d2 = new Dates(1, 2, 2003);
        
        System.out.println(d1.equals(d2));

        Dates d3 = (Dates)d2.clone();
        System.out.println(d3);
    }
}
