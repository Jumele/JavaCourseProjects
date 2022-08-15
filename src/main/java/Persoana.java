public class Persoana extends Turist {

    private String nume;
    private int varsta;
    private boolean dizabilitate;

    public Persoana(String nume, int varsta, boolean dizabilitate) {
        this.nume = nume;
        this.varsta = varsta;
        this.dizabilitate = dizabilitate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public boolean getDizabilitate() {
        return dizabilitate;
    }

    public void setDizabilitate(boolean dizabilitate) {
        this.dizabilitate = dizabilitate;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", dizabilitate='" + dizabilitate + '\'' +
                '}';
    }

    @Override
    public int prioritate() {
        if(this.dizabilitate){
            return 0;
        }

        if(this.varsta<2){
            return 1;
        }
        if(this.varsta>70){
            return 2;
        }
        return 4;
    }
}
