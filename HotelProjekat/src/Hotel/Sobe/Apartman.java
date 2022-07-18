package Hotel.Sobe;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Apartman extends Soba {
    private String naziv;

    public Apartman(double kvadratura, int brojSoba, int brojKreveta, int cena) {
        super(kvadratura, brojSoba, brojKreveta, cena);
        this.naziv = "Apartman";
    }
    public Apartman(int id,double kvadratura, int brojSoba, int brojKreveta, int cena){
        super(id,kvadratura, brojSoba, brojKreveta, cena);
        this.naziv = "Apartman";
    }
    public String toString() {
        return naziv + ", ID: " + id + ", Kvadratura: " + kvadratura + ", Broj Soba: " + brojSoba + ", Broj kreveta: " + brojKreveta + ", Cena: " + cena;
    }
    public static ArrayList<Apartman> ucitajApartman(String dat){
        ArrayList<Apartman> ucitaneSobe = new ArrayList<>();
        try{
            JSONArray jsonLista=(JSONArray) new JSONParser().parse(new FileReader(dat));
            for(Object object : jsonLista){
                JSONObject json =(JSONObject) object;
                double kvadratura = Double.parseDouble(json.get("kvadratura").toString());
                int brojSoba =Integer.parseInt(json.get("brojSoba").toString());
                int brojKreveta =Integer.parseInt(json.get("brojKreveta").toString());
                int cena =Integer.parseInt(json.get("cena").toString());
                ucitaneSobe.add(new Apartman(kvadratura,brojSoba,brojKreveta,cena));
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
