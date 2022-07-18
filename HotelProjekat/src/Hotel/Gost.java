package Hotel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Gost extends Osoba{
    private int idCard;
    private int racun;
    private String brojTelefona;
    private static int redniBr=1;

    public Gost(double racun, String brojTelefona) {
        this.idCard = redniBr;
        this.racun = 0;
        this.brojTelefona = brojTelefona;
        redniBr++;
    }
    public Gost(String jmbg, String ime, String prezime, int godine, String pol, String brojTelefona) {
        super(jmbg, ime, prezime, godine, pol);
        this.idCard = redniBr;
        this.racun = 0;
        this.brojTelefona = brojTelefona;
        redniBr++;
    }
    @Override
    public String toString() {
        return "Gost: " + "IDCard: " + idCard + " Racun: " + racun + " "+super.toString() +" Broj telefona: " + brojTelefona;
    }
    public static ArrayList<Gost> ucitajGoste(String dat){
        ArrayList<Gost> ucitaniGosti = new ArrayList<>();
        try{
            JSONArray jsonLista=(JSONArray) new JSONParser().parse(new FileReader(dat));
            for(Object object : jsonLista){
                JSONObject json =(JSONObject) object;
                String jmbg = json.get("jmbg").toString();
                String ime =json.get("ime").toString();
                String prezime = json.get("prezime").toString();
                int godine = Integer.parseInt(json.get("god").toString());
                String pol=json.get("pol").toString();
                String brTelefona=json.get("brojTelefona").toString();
                ucitaniGosti.add(new Gost(jmbg,ime,prezime,godine,pol,brTelefona));
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return ucitaniGosti;
    }

    public int getIdCard() {
        return idCard;
    }

    public double getRacun() {
        return racun;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public static int getRedniBr() {
        return redniBr;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public static void setRedniBr(int redniBr) {
        Gost.redniBr = redniBr;
    }
}
