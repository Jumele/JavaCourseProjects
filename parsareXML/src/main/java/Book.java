import java.time.LocalDate;

public class Book {

    public final String numeAutor;
    public final String numeCarte;
    public final String categorie;
    public final float pret;
    public final String dataPublicare;
    public final String descriere;


    public Book(String numeAutor, String numeCarte, String categorie, float pret,
                LocalDate dataPublicare, String descriere) {
        this.numeAutor = numeAutor;
        this.numeCarte = numeCarte;
        this.categorie = categorie;
        this.pret = pret;
        this.dataPublicare = String.valueOf(dataPublicare);
        this.descriere = descriere;


    }

    @Override

    public String toString() {

        return numeAutor + "\n" + numeCarte + "\n" + categorie + "\n" +
        pret + "\n" + dataPublicare + "\n" + descriere;

}



}





