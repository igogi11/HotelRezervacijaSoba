package Hotel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Radnik extends Osoba{
    private int id;
    private String pozicija;
    private int plata;
    private static int redniBroj;

    public Radnik(String pozicija, int plata) {
        this.id = redniBroj;
        this.pozicija = pozicija;
        this.plata = plata;
        redniBroj++;
    }
    public Radnik(String jmbg, String ime, String prezime, int godine, String pol, String pozicija, int plata) {
        super(jmbg, ime, prezime, godine, pol);
        this.id = redniBroj;
        this.pozicija = pozicija;
        this.plata = plata;
        redniBroj++;
    }
    @Override
    public String toString() {
        return "Radnik: " + "ID: " + id + " Radno mesto: " + pozicija + "\t Mesecna zarada: " + plata;
    }
    public static ArrayList<Radnik> ucitajRadnike(String dat){
        ArrayList<Radnik> ucitaniRadnici = new ArrayList<>();
        try{
            JSONArray jsonLista=(JSONArray) new JSONParser().parse(new FileReader(dat));
            for(Object object : jsonLista){
                JSONObject json =(JSONObject) object;
                String jmbg = json.get("jmbg").toString();
                String ime =json.get("ime").toString();
                String prezime = json.get("prezime").toString();
                int godine = Integer.parseInt(json.get("god").toString());
                String pol=json.get("pol").toString();
                String pozicija=json.get("pozicija").toString();
                int plata = Integer.parseInt(json.get("plata").toString());
                ucitaniRadnici.add(new Radnik(jmbg,ime,prezime,godine,pol,pozicija,plata));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return ucitaniRadnici;
    }

    public int getId() {
        return id;
    }

    public String getPozicija() {
        return pozicija;
    }

    public int getPlata() {
        return plata;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }
}
