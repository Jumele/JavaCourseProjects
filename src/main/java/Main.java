import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Persoana p1 = new Persoana("Andrei", 20, false);
        Persoana p2 = new Persoana("Bogdan", 20, true);
        Grup g1 = new Grup("familie");
        ArrayList<Persoana> membri =  new ArrayList<>();
        membri.add(new Persoana("GP1", 1, false));
        membri.add(new Persoana("GP2", 45, false));
        g1.setMembri(membri);

        ArrayList<Turist> listaImbarcare = new ArrayList<>();
        listaImbarcare.add(p1);
        listaImbarcare.add(p2);
        listaImbarcare.add(g1);


        System.out.println(listaImbarcare);
        Collections.sort(listaImbarcare);
        System.out.println(listaImbarcare);


    }

}
