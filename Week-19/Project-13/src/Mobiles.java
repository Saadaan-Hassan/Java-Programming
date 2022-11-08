import java.util.Comparator;

public class Mobiles implements Comparable<Mobiles>, Comparator<Mobiles> {
    private String name;
    private String company;
    private int ram;
    private int rom;
    private String os;

    public Mobiles(String name, String company, int ram, int rom, String os) {
        this.name = name;
        this.company = company;
        this.ram = ram;
        this.rom = rom;
        this.os = os;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Mobiles{" +
                "name=" + name + ", company= "+ company+
                ", ram=" + ram +
                ", rom=" + rom +
                ", os=" + os +
                '}';
    }


    @Override
    public int compareTo(Mobiles obj) {
        return this.name.compareTo(obj.name);
    }

    @Override
    public int compare(Mobiles o1, Mobiles o2) {
        int flag = -1;

        if (o1.ram > o2.ram)
            flag = 1;
        else if(o1.ram < o2.ram)
            flag = -1;
        else
            flag = 0;

        return flag;
    }
}
