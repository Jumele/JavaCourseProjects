package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="angajati")
public class Angajat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_angajati",  nullable = false)
    private int id;

    @Column(name="Prenume",  nullable = false)
    private String prenume;

    @Column(name="Varsta",  nullable = false)
    private int varsta;

    @Column(name="Adresa",  nullable = false)
    private String adresa;

    @Column(name="Salariu",  nullable = false)
    private int salariu;

    public Angajat(int id) {
        this.id = id;
    }

    public Angajat(int id, String prenume, int varsta, String adresa, int salariu) {
        this.id = id;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }

    public Angajat(String prenume, int varsta, String adresa, int salariu) {
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.salariu = salariu;
    }



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }
    public int getVarsta() { return varsta; }
    public void setVarsta(int varsta) { this.varsta = varsta; }
    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }
    public int getSalariu() { return salariu; }
    public void setSalariu(int salariu) { this.salariu = salariu; }


    public Angajat(){}
    @Override
    public String toString(){
        return "Id:" + getId() + "\n" + "Prenume:" + getPrenume() + "\n" + "Varsta:" + getVarsta()
                + "\n" + "Adresa:" + getAdresa() +"\n"+ "Salariu:" + getSalariu();
    }

}
