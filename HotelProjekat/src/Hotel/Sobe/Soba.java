package Hotel.Sobe;

import java.util.ArrayList;

public abstract class Soba {
    protected int id;
    protected double kvadratura;
    protected int brojSoba;
    protected int brojKreveta;
    protected int cena;
    protected static int redniBr=1;

    public Soba(int id,double kvadratura, int brojSoba, int brojKreveta, int cena){
        this.id = id;
        this.kvadratura = kvadratura;
        this.brojSoba = brojSoba;
        this.brojKreveta = brojKreveta;
        this.cena = cena;
    }
    public Soba(double kvadratura, int brojSoba, int brojKreveta, int cena) {
        this.id = redniBr;
        this.kvadratura = kvadratura;
        this.brojSoba = brojSoba;
        this.brojKreveta = brojKreveta;
        this.cena = cena;
        redniBr++;
    }
    public abstract String getNaziv();

    public int getId() {
        return id;
    }

    public double getKvadratura() {
        return kvadratura;
    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public int getCena() {
        return cena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKvadratura(double kvadratura) {
        this.kvadratura = kvadratura;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
