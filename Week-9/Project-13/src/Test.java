import java.util.Comparator;

public class Test implements Comparator<Mobiles>{

    @Override
    public int compare(Mobiles arg0, Mobiles arg1) {
        
        return arg0.getName().compareTo(arg1.getName());
    }
    
}
