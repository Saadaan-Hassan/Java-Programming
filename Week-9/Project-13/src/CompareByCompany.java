import java.util.Comparator;

public class CompareByCompany implements Comparator<Mobiles> {
    @Override
    public int compare(Mobiles m1, Mobiles m2){
        return m1.getCompany().compareTo(m2.getCompany());
    }
}
