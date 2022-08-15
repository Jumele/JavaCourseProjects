import java.util.ArrayList;

public class Grup extends Turist {
    private String tip;
    private ArrayList<Persoana> membri;

    public Grup(String tip) {
        this.tip = tip;
        this.membri = new ArrayList<Persoana>();
    }



    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public ArrayList<Persoana> getMembri() {
        return membri;
    }

    public void setMembri(ArrayList<Persoana> membri) {
        this.membri = membri;
    }

    @Override
    public String toString() {
        return "Grup{" +
                "tip='" + tip + '\'' +
                ", membri=" + membri +
                '}';
    }

    @Override
    public int prioritate() {
        for(Persoana p: membri) {
            if (p.prioritate() != 4) {
                return p.prioritate();
            }

        }return 3;
    }


}
