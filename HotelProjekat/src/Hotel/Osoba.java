package Hotel;

public abstract class Osoba {
    private String jmbg;
    private String ime;
    private String prezime;
    private int godine;
    private String pol;

    public Osoba() {
        this.jmbg=null;
        this.ime=null;
        this.prezime=null;
        this.godine=0;
        this.pol=null;
    }
    public Osoba(String jmbg, String ime, String prezime, int godine, String pol) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.pol = pol;
    }
    @Override
    public String toString() {
        return "Osoba:"+" Ime: "+ime+" Prezime: "+prezime+" Godine: "+godine+" Pol: "+ pol+"\tMaticni broj: " + jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getGodine() {
        return godine;
    }

    public String getPol() {
        return pol;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }
}
