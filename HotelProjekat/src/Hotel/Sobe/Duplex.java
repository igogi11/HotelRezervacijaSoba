package Hotel.Sobe;

import Hotel.Gost;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Duplex extends Soba{
    private String naziv;

    public Duplex( double kvadratura, int brojSoba, int brojKreveta, int cena) {
        super(kvadratura, brojSoba, brojKreveta, cena);
        this.naziv = "Duplex";
    }
    public Duplex(int id,double kvadratura, int brojSoba, int brojKreveta, int cena){
        super(id,kvadratura, brojSoba, brojKreveta, cena);
        this.naziv = "Duplex";
    }
    public String toString() {
        return naziv + ", ID: " + id + ", Kvadratura: " + kvadratura + ", Broj Soba: " + brojSoba + ", Broj kreveta: " + brojKreveta + ", Cena: " + cena;
    }
    public static ArrayList<Duplex> ucitajDuplex(String dat){
        ArrayList<Duplex> ucitaneSobe = new ArrayList<>();
        try{
            JSONArray jsonLista=(JSONArray) new JSONParser().parse(new FileReader(dat));
            for(Object object : jsonLista){
                JSONObject json =(JSONObject) object;
                double kvadratura = Double.parseDouble(json.get("kvadratura").toString());
                int brojSoba =Integer.parseInt(json.get("brojSoba").toString());
                int brojKreveta =Integer.parseInt(json.get("brojKreveta").toString());
                int cena =Integer.parseInt(json.get("cena").toString());
                ucitaneSobe.add(new Duplex(kvadratura,brojSoba,brojKreveta,cena));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return ucitaneSobe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
